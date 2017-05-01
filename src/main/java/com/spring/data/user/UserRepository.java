package com.spring.data.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by krishna1bhat on 5/1/17.
 */

@RepositoryRestResource(exported = false)//there is no /users in our API ...
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);
}
