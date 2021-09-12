package com.faizi.school.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="student")
@Data
public class StudentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private int id;

    @Column(name ="card_id")
    private String cardId;

    @Column(name ="name")
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "ic_no")
    private String icNo;
}
