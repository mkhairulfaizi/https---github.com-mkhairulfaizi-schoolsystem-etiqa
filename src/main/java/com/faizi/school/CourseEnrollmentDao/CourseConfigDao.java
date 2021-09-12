package com.faizi.school.CourseEnrollmentDao;

import com.faizi.school.vo.CourseConfigVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseConfigDao extends CrudRepository<CourseConfigVO, Integer>{

    Optional<CourseConfigVO> findByCourseId(Integer courseId);
}
