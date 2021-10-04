package com.codewithcup.crudoperations.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    protected CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        Course addCourse = courseRepository.save(course);
        if (addCourse == null)
            throw new RuntimeException("Course not added ");

        return addCourse;
    }

    @Override
    public Boolean getCourse(String name) {
        Boolean findByName = courseRepository.findByName(name);
        System.out.println(findByName);
        return findByName;
    }

    @Override
    public Course getCourseById(Long courseId) {
        Optional<Course> byCourseId = courseRepository.findById(courseId);
        if(byCourseId.isPresent())
            return byCourseId.get();
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = new Course();
        course.setCourseId(courseId);
    }

    @Override
    public Course updateCourse(Course course) {
        Course updateCourse = courseRepository.save(course);
        if (updateCourse==null)
            throw new RuntimeException("Coursse not updated");
        return updateCourse;
    }

    @Override
    public List<Course> getDurationByCourse(String duration) {
        System.out.println("---------In Service ------------> " + duration);
        List<Course> byDuration = courseRepository.findByDuration(duration);
        System.out.println("-------------> " + byDuration);
        return byDuration;
    }
}
