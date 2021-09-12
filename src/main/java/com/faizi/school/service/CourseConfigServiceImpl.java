package com.faizi.school.service;

import com.faizi.school.CourseEnrollmentDao.CourseConfigDao;
import com.faizi.school.common.RecordNotFoundException;
import com.faizi.school.vo.CourseConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseConfigServiceImpl implements CourseConfigService{

    @Autowired
    private CourseConfigDao courseConfigDao;

    @Override
    public CourseConfigVO getByCourseId(Integer courseId) {
        return courseConfigDao.findByCourseId(courseId).orElseThrow(RecordNotFoundException::new);
    }
}
