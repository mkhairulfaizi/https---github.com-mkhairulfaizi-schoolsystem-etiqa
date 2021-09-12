package com.faizi.school.controller;

import com.faizi.school.common.WebConstant;
import com.faizi.school.service.CourseEnrollmentService;
import com.faizi.school.vm.CourseEnrollmentVM;
import com.faizi.school.vm.StudentCourseVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = WebConstant.COURSE_ENROLLMENT.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseEnrollmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseEnrollmentController.class);

    @Autowired
    private CourseEnrollmentService enrollmentService;

    @GetMapping(WebConstant.COURSE_ENROLLMENT.PARAM)
    public ResponseEntity<CourseEnrollmentVM> getEnrollmentById(@PathVariable(name ="id") Integer id){
        LOGGER.info("getEnrollmentById id  : {}",id);
        return ResponseEntity.ok().body(enrollmentService.getById(id));
    }

    @GetMapping(WebConstant.COURSE_ENROLLMENT.STUDENT)
    public ResponseEntity<StudentCourseVM> getEnrollmentByStudentId(@PathVariable(name ="student-id") Integer studentId){
        LOGGER.info("getEnrollmentByStudentId studentId  : {}",studentId);
        return ResponseEntity.ok().body(enrollmentService.getByStudentId(studentId));
    }

    @PostMapping
    public ResponseEntity<Integer> addOrUpdateEnrollment(@RequestBody CourseEnrollmentVM vm){
        LOGGER.info("addOrUpdateEnrollment vo : {}",vm.toString());
        return ResponseEntity.ok().body(enrollmentService.addOrUpdate(vm));
    }

    @DeleteMapping
    public ResponseEntity<Integer> deleteEnrollmentById(@PathVariable(name ="id") Integer id){
        LOGGER.info("deleteEnrollmentById vo : {}",id);
        return ResponseEntity.ok().body(enrollmentService.deleteById(id));
    }
}
