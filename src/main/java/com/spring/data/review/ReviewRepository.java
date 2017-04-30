package com.spring.data.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by krishna1bhat on 4/30/17.
 */

@RepositoryRestResource
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
