package com.faizi.school.vm;

import lombok.Data;

import java.util.List;

@Data
public class StudentCourseVM {

    private Integer studentId;
    private String studentCardId;
    private String studentIcNo;
    private String studentName;
    private List<CourseEnrollmentVM> courses;

}
