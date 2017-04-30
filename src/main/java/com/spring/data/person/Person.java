package com.spring.data.person;

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
class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    protected Person(){
        super();//id = null
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
