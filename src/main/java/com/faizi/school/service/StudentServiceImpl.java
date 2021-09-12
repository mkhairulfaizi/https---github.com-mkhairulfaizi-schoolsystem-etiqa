package com.faizi.school.service;

import com.faizi.school.common.RecordNotFoundException;
import com.faizi.school.CourseEnrollmentDao.StudentDao;
import com.faizi.school.vm.StudentVM;
import com.faizi.school.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Integer addOrUpdate(StudentVM studentVM) {

        StudentVO studentVO = studentDao.findByCardId(studentVM.getCardId()).orElse(null);

        if (studentVO == null) {
            studentVO = new StudentVO();
        }
        studentVO.setCardId(studentVM.getCardId());
        studentVO.setName(studentVM.getName());
        studentVO.setIcNo(studentVM.getIcNo());
        studentVO.setPhoneNo(studentVM.getPhoneNo());
        studentDao.save(studentVO);
        return studentVO.getId();
    }

    @Override
    public StudentVM getById(Integer id) {

        StudentVO vo = studentDao.findById(id).orElseThrow(RecordNotFoundException::new);

        StudentVM vm = new StudentVM();
        vm.setId(vo.getId());
        vm.setCardId(vo.getCardId());
        vm.setName(vo.getName());
        vm.setPhoneNo(vo.getPhoneNo());
        vm.setIcNo(vo.getIcNo());
        return vm;
    }

    @Override
    public Page<StudentVM> getAll(Integer pageNumber, Integer size) {

        Page<StudentVO> allStudentVO = studentDao.findAll(PageRequest.of(pageNumber - 1, size));

        List<StudentVM> allStudentVM = allStudentVO.stream().map(this::mapToStudentVm).collect(Collectors.toList());

        return new PageImpl<>(allStudentVM, PageRequest.of(pageNumber, size), allStudentVM.size());

    }
    @Override
    public List<StudentVM> getAll() {

        Iterable<StudentVO> allStudentVO = studentDao.findAll();

        List<StudentVM> allStudentVM = new ArrayList<>();
        for (StudentVO vo : allStudentVO){
            allStudentVM.add(mapToStudentVm(vo));
        }

        return allStudentVM;
    }

    @Override
    public Integer deleteById(Integer id) {
        StudentVO vo = studentDao.findById(id).orElseThrow(RecordNotFoundException::new);

        studentDao.deleteById(id);

        return id;
    }

    private StudentVM mapToStudentVm(StudentVO vo){
        StudentVM vm = new StudentVM();
        vm.setId(vo.getId());
        vm.setName(vo.getName());
        vm.setCardId(vo.getCardId());
        vm.setIcNo(vo.getIcNo());
        vm.setPhoneNo(vo.getPhoneNo());
        return vm;
    }
}
