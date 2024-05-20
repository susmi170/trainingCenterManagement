package com.buyogo.tcm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for Address table
 */

@Entity(name = "ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "FULL_ADDRESS")

    private String fullAddress;
    @Column(name = "CITY")

    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "PIN")

    private int pinCode;
}
