package com.spring.data.review;

import com.spring.data.core.BaseEntity;
import com.spring.data.course.Course;
import com.spring.data.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by krishna1bhat on 4/30/17.
 */

@Data
@Entity
public class Review extends BaseEntity {
    private int rating;
    private String description;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User reviewer;

    public Review() {
        super();
    }

    public Review(int rating, String description) {
        this();
        this.rating = rating;
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setReviewer(User reviewer){
        this.reviewer = reviewer;
    }
}
