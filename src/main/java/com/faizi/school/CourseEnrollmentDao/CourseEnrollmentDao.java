package com.faizi.school.CourseEnrollmentDao;

import com.faizi.school.vo.CourseEnrollmentVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseEnrollmentDao extends CrudRepository<CourseEnrollmentVO, Integer>, PagingAndSortingRepository<CourseEnrollmentVO, Integer> {

    Optional<CourseEnrollmentVO> findByCourseIdAndTutorIdAndStudentId(Integer courseId, Integer tutorId, Integer studentId);
    Optional<List<CourseEnrollmentVO>> findByStudentId(Integer studentId);
}
