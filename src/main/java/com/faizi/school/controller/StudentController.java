package com.faizi.school.controller;

import com.faizi.school.common.WebConstant;
import com.faizi.school.service.StudentService;
import com.faizi.school.vm.StudentVM;
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

import java.util.List;

@RestController
@RequestMapping(value = WebConstant.STUDENT.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(WebConstant.STUDENT.PARAM)
    public ResponseEntity<StudentVM> getStudentById(@PathVariable(name ="id") Integer id){
        LOGGER.info("getStudentById id  : {}",id);
        return ResponseEntity.ok().body(studentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<StudentVM>> getStudents(@RequestParam(name ="page-number") Integer pageNumber, @RequestParam(name ="size") Integer size){
        return ResponseEntity.ok().body(studentService.getAll(pageNumber, size));
    }

    @GetMapping(WebConstant.STUDENT.LIST)
    public ResponseEntity<List<StudentVM>> getStudents(){
        return ResponseEntity.ok().body(studentService.getAll());
    }

    @PostMapping
    public ResponseEntity<Integer> addOrUpdateStudent(@RequestBody StudentVM vm){
        LOGGER.info("addOrUpdateStudent vo : {}",vm.toString());
        return ResponseEntity.ok().body(studentService.addOrUpdate(vm));
    }

    @DeleteMapping(WebConstant.STUDENT.PARAM)
    public ResponseEntity<Integer> deleteStudentById(@PathVariable(name ="id") Integer id){
        LOGGER.info("deleteStudentById vo : {}",id);
        return ResponseEntity.ok().body(studentService.deleteById(id));
    }
}
