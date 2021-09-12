package com.faizi.school.controller;

import com.faizi.school.common.WebConstant;
import com.faizi.school.service.CourseService;
import com.faizi.school.vm.CourseVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = WebConstant.COURSE.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping(WebConstant.COURSE.PARAM)
    public ResponseEntity<CourseVM> getCourseById(@PathVariable(name ="id") Integer id){
        LOGGER.info("getCourseById id  : {}",id);
        return ResponseEntity.ok().body(courseService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CourseVM>> getCourses(@RequestParam(name ="page-number") Integer pageNumber, @RequestParam(name ="size") Integer size){
        return ResponseEntity.ok().body(courseService.getAll(pageNumber, size));
    }

    @PostMapping
    public ResponseEntity<Integer> addOrUpdateCourse(@RequestBody CourseVM vm){
        LOGGER.info("addOrUpdateCourse vo : {}",vm.toString());
        return ResponseEntity.ok().body(courseService.addOrUpdate(vm));
    }

    @DeleteMapping(WebConstant.COURSE.PARAM)
    public ResponseEntity<Integer> deleteCourseById(@PathVariable(name ="id") Integer id){
        LOGGER.info("deleteCourseById vo : {}",id);
        return ResponseEntity.ok().body(courseService.deleteById(id));
    }

}
