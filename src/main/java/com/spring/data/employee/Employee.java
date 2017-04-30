package com.spring.data.employee;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by krishna1bhat on 4/30/17.
 */
@Data
@Entity
class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    String firstName;
    String lastName;

    private Employee(){}
    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}