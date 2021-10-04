package com.codewithcup.crudoperations.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/course/")
public class CourseController {

    @Autowired
    protected CourseService courseService;

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable Long courseId){
        Course course = courseService.getCourseById(courseId);
        if(course != null){
            return ResponseEntity.status(HttpStatus.OK).body(course);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(course);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addingCourses(@RequestBody Course course) {
        try {
            Course add = courseService.addCourse(course);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/{courseId}")
                    .buildAndExpand(add.getCourseId())
                    .toUri();
            return ResponseEntity.created(location).build();

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> getCourseByname(@PathVariable String name){
       Boolean course = courseService.getCourse(name);
        if(course != null){
            return ResponseEntity.status(HttpStatus.OK).body(course);
        }
        return new ResponseEntity<>("Something went wrong" , HttpStatus.BAD_REQUEST);
    }



    @GetMapping("/duration/{duration}")
    public ResponseEntity<?> getCourseByDuration(@PathVariable String duration){
        List<Course> course = courseService.getDurationByCourse(duration);
        System.out.println(course.toString());
        if(course != null){
            return ResponseEntity.status(HttpStatus.OK).body(course);
        }
        return new ResponseEntity<>("Something went wrong" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses(){
        try{
            List<Course> allCourse = courseService.getAllCourse();
            if(allCourse != null)
                return  ResponseEntity.status(HttpStatus.OK).body(allCourse);
        }catch(RuntimeException e){
            return new ResponseEntity<>("Something went wrong while fetching data from database",HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatedCourses(@RequestBody Course course){
        Course course1 = courseService.updateCourse(course);
        if(course != null)
            return  ResponseEntity.status(HttpStatus.OK).body(course1);
        return new ResponseEntity<>("Course not updated...",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{courseId}")
    public void courseDeleted(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
    }
}
