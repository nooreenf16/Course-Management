package com.example.course;

import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq_generator")
    @SequenceGenerator(name = "course_seq_generator", sequenceName = "course_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "coursenumber")
    private String courseNumber;

    @Column(name = "coursename")
    private String courseName;
    private Integer capacity;

    public Course() {
    }

    public Course( String courseName, String courseNumber, Integer capacity) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.capacity = capacity;
    }

    public Course(Long id,  String courseName, String courseNumber, Integer capacity) {
        this.id = id;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getcourseNumber() {
        return courseNumber;
    }

    public void setcourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;}

}
