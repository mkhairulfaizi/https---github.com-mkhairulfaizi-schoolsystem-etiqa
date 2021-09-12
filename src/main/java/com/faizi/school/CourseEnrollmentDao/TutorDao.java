package com.faizi.school.CourseEnrollmentDao;

import com.faizi.school.vo.StudentVO;
import com.faizi.school.vo.TutorVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorDao extends CrudRepository<TutorVO, Integer>, PagingAndSortingRepository<TutorVO, Integer> {

}