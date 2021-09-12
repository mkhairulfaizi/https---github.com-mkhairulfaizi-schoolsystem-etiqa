package com.faizi.school.service;

import com.faizi.school.vm.CourseEnrollmentVM;
import com.faizi.school.vm.StudentCourseVM;

public interface CourseEnrollmentService {

    Integer addOrUpdate(CourseEnrollmentVM courseEnrollmentVM);
    CourseEnrollmentVM getById(Integer id);
    StudentCourseVM getByStudentId(Integer id);
    Integer deleteById(Integer id);
}
