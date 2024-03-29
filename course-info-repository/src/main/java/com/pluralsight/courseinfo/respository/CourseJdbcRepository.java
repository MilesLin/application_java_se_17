package com.pluralsight.courseinfo.respository;

import com.pluralsight.courseinfo.doamin.Course;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class CourseJdbcRepository implements CourseRepository{
    private static final String H2_DATABASE_URL =
            "jdbc:h2:file:%s;AUTO_SERVER_TRUE;INIT=RUNSCRIPT FROM './db_init.sql'";
    private static final String INSERT_COURSE = """
        MERGE INTO COURSES (id, name, length, url)
        VALUES (?, ?, ?, ?)
    """;
    private final DataSource dataSource;
    public CourseJdbcRepository(String databaseFile){
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL(H2_DATABASE_URL.formatted(databaseFile));
        this.dataSource = jdbcDataSource;
    }
    @Override
    public void saveCourse(Course course) {
//        try (Connection connection = this.dataSource.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(INSERT_COURSE);
//            statement.setString(1, course.id());
//            statement.setString(2, course.name());
//            statement.setLong(3, course.length());
//            statement.setString(4, course.url());
//            statement.execute();
//        } catch (SQLException e){
//            throw new RepositoryException("Failed to save" + course, e);
//        }
    }

    @Override
    public List<Course> getAllCourses() {
        return List.of(new Course("1","miles", 100, "abc-url", Optional.of("Example notes")));
//        try (Connection connection = this.dataSource.getConnection()) {
//            Statement statment = connection.createStatement();
//            ResultSet resultSet = statment.executeQuery("SELECT * FROM COURSES");
//            List<Course> courses = new ArrayList<>();
//            while (resultSet.next()){
//                Course course = new Course(
//                        resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getLong(3),
//                        resultSet.getString(4)
//                );
//                courses.add(course);
//            }
//            return Collections.unmodifiableList(courses);
//
//        } catch (SQLException e){
//            throw new RepositoryException("Failed to retrieve courses", e);
//        }
    }
}
