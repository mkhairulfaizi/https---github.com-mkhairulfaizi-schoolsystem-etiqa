package com.faizi.school.service;

import com.faizi.school.vm.CourseVM;
import com.faizi.school.vm.StudentVM;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    Integer addOrUpdate(StudentVM StudentVM);
    StudentVM getById(Integer id);
    Page<StudentVM> getAll(Integer pageNumber, Integer size);
    List<StudentVM> getAll();
    Integer deleteById(Integer id);
}
