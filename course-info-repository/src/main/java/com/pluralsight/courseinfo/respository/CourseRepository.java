package com.pluralsight.courseinfo.respository;

import com.pluralsight.courseinfo.doamin.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);
    List<Course> getAllCourses();

    static CourseRepository openCourseRepository(String databaseFile){
        return new CourseJdbcRepository(databaseFile);
    }
}
