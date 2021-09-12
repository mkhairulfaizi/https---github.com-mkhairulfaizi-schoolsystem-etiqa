package com.faizi.school.CourseEnrollmentDao;

import com.faizi.school.vo.StudentVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentDao extends CrudRepository<StudentVO, Integer>, PagingAndSortingRepository<StudentVO, Integer> {

    Optional<StudentVO> findByCardId(String cardId);
}