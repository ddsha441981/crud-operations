package com.codewithcup.crudoperations.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

  Student findByStudentName(String studentName);


  @Query(value = "select email from Student  where email = ?1")
  Optional<Student> findByEmail(String email);
}
