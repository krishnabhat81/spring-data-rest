package com.spring.data.employee;

import com.spring.data.com.spring.data.core.BaseEntity;
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
class Employee extends BaseEntity{
    String firstName;
    String lastName;

    private Employee(){
        super();
    }
    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}