package com.spring.data.course;

import com.spring.data.core.BaseEntity;
import com.spring.data.review.Review;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna1bhat on 4/30/17.
 */

@Data
@Entity
public class Course extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 140)
    private String title;
    private String url;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course() {
        super();
        reviews = new ArrayList<>();
    }

    public Course(String title, String url){
        this();
        this.title = title;
        this.url = url;
    }

    public void addReview(Review review){
        review.setCourse(this);
        reviews.add(review);
    }
}
