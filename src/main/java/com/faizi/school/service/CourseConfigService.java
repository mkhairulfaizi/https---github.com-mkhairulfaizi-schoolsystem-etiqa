package com.faizi.school.service;

import com.faizi.school.vo.CourseConfigVO;

public interface CourseConfigService {
    CourseConfigVO getByCourseId(Integer courseId);
}
