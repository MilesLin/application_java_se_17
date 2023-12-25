package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import com.pluralsight.courseinfo.cli.service.PluralsightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.function.Predicate.not;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String[] args) {
        LOG.info("CourseRetriever started");
        if (args.length == 0) {
            LOG.warn("Please provide an author name as first argument.");
            return;
        }
        try{
            retrieveCourses(args[0]);
        } catch (Exception e){
            LOG.error("Unexpected error", e);
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrievalService svc = new CourseRetrievalService();

        List<PluralsightCourse> r = svc.getCourse(authorId)
                .stream()
                .filter(not(PluralsightCourse::isRetired))
//                .filter(course -> !course.isRetired())
                .toList();
        LOG.info("Retrieved the following {} courses {}", r.size(),r);
    }
}
