package com.faizi.school.service;

import com.faizi.school.common.RecordNotFoundException;
import com.faizi.school.CourseEnrollmentDao.CourseDao;
import com.faizi.school.vm.CourseVM;
import com.faizi.school.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

    @Override
    public Integer addOrUpdate(CourseVM courseVM) {

        CourseVO courseVO = courseDao.findByCode(courseVM.getCode()).orElse(null);

        if (courseVO == null) {
            courseVO = new CourseVO();
            courseVO.setCode(courseVM.getCode());
        }
        courseVO.setName(courseVM.getName());
        courseDao.save(courseVO);
        return courseVO.getId();
    }

    @Override
    public CourseVM getById(Integer id) {

        CourseVO vo = courseDao.findById(id).orElseThrow(RecordNotFoundException::new);

        CourseVM vm = new CourseVM();
        vm.setCode(vo.getCode());
        vm.setId(vo.getId());
        vm.setName(vo.getName());
        return vm;
    }

    @Override
    public Page<CourseVM> getAll(Integer pageNumber, Integer size) {

        Page<CourseVO> allCourseVO = courseDao.findAll(PageRequest.of(pageNumber - 1, size));

        List<CourseVM> allCourseVM = allCourseVO.stream().map(this::mapToCourseVm).collect(Collectors.toList());

        return new PageImpl<>(allCourseVM, PageRequest.of(pageNumber, size), allCourseVM.size());

    }

    @Override
    public Integer deleteById(Integer id) {
        CourseVO vo = courseDao.findById(id).orElseThrow(RecordNotFoundException::new);

        courseDao.deleteById(id);

        return id;
    }

    private CourseVM mapToCourseVm(CourseVO vo){
        CourseVM vm = new CourseVM();
        vm.setId(vo.getId());
        vm.setCode(vo.getCode());
        vm.setName(vo.getName());
        return vm;
    }
}
