package com.spring.data.core;

import com.spring.data.course.Course;
import com.spring.data.course.CourseRepository;
import com.spring.data.review.Review;
import com.spring.data.user.User;
import com.spring.data.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by krishna1bhat on 4/30/17.
 */

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final CourseRepository courses;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(CourseRepository courses, UserRepository users) {
        this.courses = courses;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Course course = new Course("GitHub Link", "https://github.com/krishnabhat81");
        course.addReview(new Review(4, "This is first review"));
        courses.save(course);

        String[] templates = {
                "Application is running with %s",
                "%s basics",
                "%s for starter",
                "Under construction: %s",
                "This is test %s"
        };

        String[] messages = {
                "Spring Data REST",
                "Java",
                "Spring tutorial",
                "This website",
                "Spring boot project"
        };

        List<User> students = Arrays.asList(
                new User("Krishna1", "Bhat", "krishna1", "krishna1", new String[] {"ROLE_USER"}),
                new User("Krishna2", "Bhat", "krishna2", "krishna2", new String[] {"ROLE_USER"}),
                new User("Krishna3", "Bhat", "krishna3", "krishna3", new String[] {"ROLE_USER"}),
                new User("Krishna4", "Bhat", "krishna4", "krishna4", new String[] {"ROLE_USER"})
        );

        users.save(students);
        users.save(new User("Krishna", "Bhat", "krishna", "krishna", new String[] {"ROLE_USER", "ROLE_ADMIN"}))

        List<Course> tmpCources = new ArrayList<>();

        IntStream.range(0, 100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String message = messages[i % messages.length];
                    String title = String.format(template, message);
                    Course c = new Course(title, "http:www.example.com");
                    Review review = new Review((i % 5) + 1, String.format("More %s please!", message));
                    review.setReviewer(students.get(i % students.size()));
                    c.addReview(review);
                    tmpCources.add(c);
                });

        courses.save(tmpCources);
    }
}
