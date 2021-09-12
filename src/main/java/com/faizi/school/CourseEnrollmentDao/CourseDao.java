package com.faizi.school.CourseEnrollmentDao;

import com.faizi.school.vo.CourseVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseDao extends CrudRepository<CourseVO, Integer>, PagingAndSortingRepository<CourseVO, Integer> {

    Optional<CourseVO> findByCode(String code);
}
