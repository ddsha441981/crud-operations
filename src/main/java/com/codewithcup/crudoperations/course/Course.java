package com.codewithcup.crudoperations.course;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String duration;
    @Column(name = "ename")
    private String name;

    public Course() {
    }

    public Course(String duration, String name) {
        this.duration = duration;
        this.name = name;
    }
}
