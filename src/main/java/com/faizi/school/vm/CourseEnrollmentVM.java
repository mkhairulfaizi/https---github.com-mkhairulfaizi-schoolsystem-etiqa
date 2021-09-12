package com.faizi.school.vm;

import lombok.Data;

@Data
public class CourseEnrollmentVM {

    private Integer id;
    private Integer courseId;
    private String courseCode;
    private String courseName;
    private Integer tutorId;
    private String tutorName;
    private String tutorPhoneNo;
    private Integer studentId;
    private String studentCardId;
    private String studentName;
}
