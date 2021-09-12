package com.faizi.school.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="course_enrollment")
@Data
public class CourseEnrollmentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private int id;

    @Column(name ="course_id")
    private Integer courseId;

    @Column(name ="student_id")
    private Integer studentId;

    @Column(name = "tutor_id")
    private Integer tutorId;
}
