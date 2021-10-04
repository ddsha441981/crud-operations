package com.codewithcup.crudoperations.course;

import java.util.List;

public interface CourseService {

    //Crud Operations
    public Course addCourse(Course course);
    public Boolean getCourse(String name);
    public Course getCourseById(Long courseId);
    public List<Course> getAllCourse();
    public void deleteCourse(Long courseId);
    public Course updateCourse(Course course);
    public List<Course> getDurationByCourse(String duration);
}
