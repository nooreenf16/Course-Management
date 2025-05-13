package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    private StudentInstructorKafkaConsumer kafkaPublisher;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents() {
        kafkaPublisher.consume("executed:GET");

        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        kafkaPublisher.consume("executed:POST");

        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")

    public void deleteStudent(@PathVariable Long id) {
        kafkaPublisher.consume("executed:DELETE");

        studentRepository.deleteById(id);
    }
}
