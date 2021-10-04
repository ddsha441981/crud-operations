package com.codewithcup.crudoperations.student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student getStudentById(Long stdId);
    public Student getStudentByName(String studentName);
    public Optional<Student> getStudentByEmail(String email);
    public List<Student> getStudentsList();
    public Student createStudent(Student student);
    public Student updateStudent(Student student);
    public Student deleteStudent(Long stdId);
    public Student getListByCourse(Long courseId);
}
