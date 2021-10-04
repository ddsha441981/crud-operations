package com.codewithcup.crudoperations.student;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stdId;
    @Column(name = "std_name")
    private String studentName;
    private String email;
    private Long courseId;

    public Student() {
    }
}
