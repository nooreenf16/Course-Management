package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    private InstructorKafkaConsumer kafkaPublisher;
    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getCourses() {
        kafkaPublisher.consume("executed:GET");

        return courseRepository.findAll();
    }

    @PostMapping
    public void addCourse(@RequestBody Course course) {

        kafkaPublisher.consume("executed:POST");
        courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        kafkaPublisher.consume("executed:DELETE");
        courseRepository.deleteById(id);
    }
}
