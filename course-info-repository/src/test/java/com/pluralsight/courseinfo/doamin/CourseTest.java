package com.pluralsight.courseinfo.doamin;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void filledTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Course("", "", 1, "", Optional.empty());
        });

        assertDoesNotThrow(() -> {
            new Course("1", "1", 1, "123", Optional.of("as"));
        });
    }
}