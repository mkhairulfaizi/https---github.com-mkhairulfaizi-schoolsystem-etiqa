package com.faizi.school.service;

import com.faizi.school.CourseEnrollmentDao.CourseDao;
import com.faizi.school.CourseEnrollmentDao.CourseEnrollmentDao;
import com.faizi.school.CourseEnrollmentDao.StudentDao;
import com.faizi.school.CourseEnrollmentDao.TutorDao;
import com.faizi.school.common.RecordNotFoundException;
import com.faizi.school.vm.CourseEnrollmentVM;
import com.faizi.school.vm.StudentCourseVM;
import com.faizi.school.vo.CourseEnrollmentVO;
import com.faizi.school.vo.CourseVO;
import com.faizi.school.vo.StudentVO;
import com.faizi.school.vo.TutorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService{

    @Autowired
    private CourseEnrollmentDao enrollmentDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TutorDao tutorDao;

    @Override
    public Integer addOrUpdate(CourseEnrollmentVM courseEnrollmentVM) {

        CourseEnrollmentVO enrollmentVO = enrollmentDao.findByCourseIdAndTutorIdAndStudentId(courseEnrollmentVM.getCourseId(),
                courseEnrollmentVM.getTutorId(), courseEnrollmentVM.getStudentId()).orElse(null);

        TutorVO tutorVO = tutorDao.findById(courseEnrollmentVM.getTutorId()).orElseThrow(() -> new RecordNotFoundException("TutorId not found"));
        CourseVO courseVO = courseDao.findById(courseEnrollmentVM.getCourseId()).orElseThrow(() -> new RecordNotFoundException("CourseId not found"));
        StudentVO studentVO = studentDao.findById(courseEnrollmentVM.getStudentId()).orElseThrow(() -> new RecordNotFoundException("StudentId not found"));

        if (enrollmentVO == null) {
            enrollmentVO = new CourseEnrollmentVO();
        }

        enrollmentVO.setCourseId(courseEnrollmentVM.getCourseId());
        enrollmentVO.setTutorId(courseEnrollmentVM.getTutorId());
        enrollmentVO.setStudentId(courseEnrollmentVM.getStudentId());
        enrollmentDao.save(enrollmentVO);
        return enrollmentVO.getId();
    }

    @Override
    public CourseEnrollmentVM getById(Integer id) {

        CourseEnrollmentVO vo = enrollmentDao.findById(id).orElseThrow(RecordNotFoundException::new);

        TutorVO tutorVO = tutorDao.findById(vo.getTutorId()).orElseThrow(() -> new RecordNotFoundException("TutorId not found"));
        CourseVO courseVO = courseDao.findById(vo.getCourseId()).orElseThrow(() -> new RecordNotFoundException("CourseId not found"));
        StudentVO studentVO = studentDao.findById(vo.getStudentId()).orElseThrow(() -> new RecordNotFoundException("StudentId not found"));

        CourseEnrollmentVM vm = new CourseEnrollmentVM();
        vm.setId(vo.getId());
        vm.setCourseId(courseVO.getId());
        vm.setCourseCode(courseVO.getCode());
        vm.setCourseName(courseVO.getName());
        vm.setTutorId(tutorVO.getId());
        vm.setTutorName(tutorVO.getName());
        vm.setTutorPhoneNo(tutorVO.getPhoneNo());
        vm.setStudentId(studentVO.getId());
        vm.setStudentCardId(studentVO.getCardId());
        vm.setStudentName(studentVO.getName());
        return vm;
    }

    @Override
    public StudentCourseVM getByStudentId(Integer id) {
        List<CourseEnrollmentVO> vo = enrollmentDao.findByStudentId(id).orElseThrow(RecordNotFoundException::new);

        StudentCourseVM vm = new StudentCourseVM();
        StudentVO studentVO = studentDao.findById(vo.get(0).getStudentId()).orElseThrow(() -> new RecordNotFoundException("StudentId not found"));
        vm.setStudentId(studentVO.getId());
        vm.setStudentName(studentVO.getName());
        vm.setStudentCardId(studentVO.getCardId());
        vm.setStudentIcNo(studentVO.getIcNo());

        List<CourseEnrollmentVM> courseEnrollments = new ArrayList<>();

        for (int i=0; i<vo.size(); i ++) {
            TutorVO tutorVO = tutorDao.findById(vo.get(i).getTutorId()).orElseThrow(() -> new RecordNotFoundException("TutorId not found"));
            CourseVO courseVO = courseDao.findById(vo.get(i).getCourseId()).orElseThrow(() -> new RecordNotFoundException("CourseId not found"));

            CourseEnrollmentVM enrollmentVM = new CourseEnrollmentVM();
            enrollmentVM.setCourseId(courseVO.getId());
            enrollmentVM.setCourseCode(courseVO.getCode());
            enrollmentVM.setCourseName(courseVO.getName());
            enrollmentVM.setTutorId(tutorVO.getId());
            enrollmentVM.setTutorName(tutorVO.getName());
            enrollmentVM.setTutorPhoneNo(tutorVO.getPhoneNo());

            courseEnrollments.add(enrollmentVM);
        }

        vm.setCourses(courseEnrollments);
        return vm;
    }

    @Override
    public Integer deleteById(Integer id) {
        CourseEnrollmentVO vo = enrollmentDao.findById(id).orElseThrow(RecordNotFoundException::new);

        enrollmentDao.deleteById(id);

        return id;
    }

}
