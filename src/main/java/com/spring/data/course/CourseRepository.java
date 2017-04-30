package com.spring.data.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by krishna1bhat on 4/30/17.
 */

@RepositoryRestResource
public interface CourseRepository extends CrudRepository<Course, Long> {

}
