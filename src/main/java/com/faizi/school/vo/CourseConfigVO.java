package com.faizi.school.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="course_config")
@Data
public class CourseConfigVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private int id;

    @Column(name ="course_id")
    private Integer courseId;

    @Column(name ="code")
    private String code;

    @Column(name = "value")
    private String value;
}
