package com.pluralsight.courseinfo.respository;

import com.pluralsight.courseinfo.doamin.Course;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.util.List;

public class CourseJdbcRepository implements CourseRepository{
    private static final String H2_DATABASE_URL =
            "jdbc:h2:file:%s;AUTO_SERVER_TRUE;INIT=RUNSCRIPT FROM './db_init.sql'";
    private final DataSource dataSource;
    public CourseJdbcRepository(String databaseFile){
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL(H2_DATABASE_URL.formatted(databaseFile));
        this.dataSource = jdbcDataSource;
    }
    @Override
    public void saveCourse(Course course) {

    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }
}
