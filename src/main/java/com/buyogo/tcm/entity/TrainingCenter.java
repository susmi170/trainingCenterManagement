package com.buyogo.tcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Entity class for TRAINING_CENTER table
 */
@Entity(name = "TRAINING_CENTER")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "CENTER_NAME")

    private String centerName;
    @Column(name = "CENTER_CODE")

    private String centerCode;
    @Column(name = "STUDENT_CAPACITY")
    private int studentCapacity;
    @OneToOne(cascade = CascadeType.ALL)

    private Address address;
    @Column(name = "COURSES")

    private String courses;
    @Column(name = "CONTACT_EMAIL")

    private String contactEmail;
    @Column(name = "CONTACT_PHONE")

    private String contactPhone;
    @Column(name = "CREATED_ON")
    private Date createdOn;


}
