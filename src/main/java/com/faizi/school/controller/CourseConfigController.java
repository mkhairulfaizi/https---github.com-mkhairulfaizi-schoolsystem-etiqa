package com.faizi.school.controller;


import com.faizi.school.common.WebConstant;
import com.faizi.school.service.CourseConfigService;
import com.faizi.school.vo.CourseConfigVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = WebConstant.COURSE_CONFIG.ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseConfigController.class);

    @Autowired
    private CourseConfigService courseConfigService;

    @GetMapping
    public ResponseEntity<CourseConfigVO> getCourseConfigByCourseId(@RequestParam(name ="course-id") Integer courseId){
        LOGGER.info("getCourseConfigByCourseId id  : {}",courseId);
        return ResponseEntity.ok().body(courseConfigService.getByCourseId(courseId));
    }
}
