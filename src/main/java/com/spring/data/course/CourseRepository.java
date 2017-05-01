package com.spring.data.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by krishna1bhat on 4/30/17.
 */

@RepositoryRestResource
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    //title-contains instead of findByTitleContaining --- method name
    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);

}
