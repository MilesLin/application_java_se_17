package com.pluralsight.courseinfo.cli.service;

import com.pluralsight.courseinfo.doamin.Course;
import com.pluralsight.courseinfo.respository.CourseRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseStorageServiceTest {

    @Test
    void storePluralsightCourses() {
        CourseRepository repo = new InMemoryCourseRepository();
        CourseStorageService svc = new CourseStorageService(repo);

        PluralsightCourse ps1 = new PluralsightCourse("1", "Title 1",
                "01:40:00.123", "/url-1", false);
        svc.storePluralsightCourses(List.of(ps1));

        Course expected = new Course("1", "Title 1",
                100, "https://app.pluralsight.com/url-1", Optional.empty());

        assertEquals(List.of(expected), repo.getAllCourses());
    }
    static class InMemoryCourseRepository implements CourseRepository{

        private final List<Course> courses = new ArrayList<>();
        @Override
        public void saveCourse(Course course) {
            courses.add(course);
        }

        @Override
        public List<Course> getAllCourses() {
            return courses;
        }
    }
}