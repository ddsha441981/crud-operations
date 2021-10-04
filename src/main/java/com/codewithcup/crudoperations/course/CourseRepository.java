package com.codewithcup.crudoperations.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByDuration(String duration);

    @Query("select c from Course c where c.name = ?1")
    Boolean findByName(String name);
}