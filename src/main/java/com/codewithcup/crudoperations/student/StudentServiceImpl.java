package com.codewithcup.crudoperations.student;

import com.codewithcup.crudoperations.exceptions.EmailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long stdId) {
        return null;
    }

    @Override
    public Student getStudentByName(String studentName) {
       Student sName = studentRepository.findByStudentName(studentName);
        return sName;
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        Optional<Student> isEmailExist = studentRepository.findByEmail(email);
        if(isEmailExist.isPresent())
            return isEmailExist;
        return null;
    }

    @Override
    public List<Student> getStudentsList() {
        return null;
    }

    @Override
    public Student createStudent(Student student) {
        Student save = studentRepository.save(student);
        return save;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(Long stdId) {
        return null;
    }

    @Override
    public Student getListByCourse(Long courseId) {
        return null;
    }
}
