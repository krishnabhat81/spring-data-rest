package com.spring.data.review;

import com.spring.data.user.User;
import com.spring.data.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by krishna1bhat on 5/1/17.
 */
@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {
    private final UserRepository users;

    @Autowired
    public ReviewEventHandler(UserRepository users) {
        this.users = users;
    }

    /*
    Spring Data REST -- write custom logic...
    ----------------
    BeforeCreateEvent
    AfterCreateEvent
    BeforeSaveEvent
    AfterSaveEvent
    BeforeLinkSaveEvent
    AfterLinkSaveEvent
    BeforeDeleteEvent
    AfterDeleteEvent
     */

    @HandleBeforeCreate
    public void addReviewrBasedOnLoggedInUser(Review review){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUserName(username);
        review.setReviewer(user);
    }
}
