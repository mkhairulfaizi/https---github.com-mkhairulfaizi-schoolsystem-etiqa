package com.faizi.school.service;

import com.faizi.school.vm.CourseVM;
import org.springframework.data.domain.Page;

public interface CourseService {

    Integer addOrUpdate(CourseVM courseVM);
    CourseVM getById(Integer id);
    Page<CourseVM> getAll(Integer pageNumber, Integer size);
    Integer deleteById(Integer id);
}
