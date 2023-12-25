package com.pluralsight.courseinfo.cli.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PluralsightCourseTest {

    @Test
    void durationInMinutes() {
        PluralsightCourse course =
                new PluralsightCourse("id", "test course", "00:05:34", "url", false);
        assertEquals(5, course.durationInMinutes());
    }

    @Test
    void durationInMinutesOverHour() {
        PluralsightCourse course =
                new PluralsightCourse("id", "test course", "01:05:34", "url", false);
        assertEquals(65, course.durationInMinutes());
    }

    @Test
    void durationInMinutesZero() {
        PluralsightCourse course =
                new PluralsightCourse("id", "test course", "00:00:00", "url", false);
        assertEquals(0, course.durationInMinutes());
    }
}