package com.spring.data.core;

import javax.persistence.*;

/**
 * Created by krishna1bhat on 4/30/17.
 */

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    //this is for Entity versioning
    //to check
    //get request any api url: check the header, you will see ETag = 0 first time
    //then if you PUT(add new record for same),  check header => ETag = 1
    //currently ETag is 1
    //if you request GET sending ETag = 1 you will get 304 status code
    //you can use this concept in different apps like android, ios, web app....
    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
