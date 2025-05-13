package com.example.instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    @Autowired
    private InstructorKafkaPublisher kafkaPublisher;

    @GetMapping
    public List<Instructor> getInstructors() {
        kafkaPublisher.publishInstructorChange("executed", "GET");
        return instructorRepository.findAll();
    }

    @PostMapping
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        kafkaPublisher.publishInstructorChange(instructor.getName(), "POST");
        return instructorRepository.save(instructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {

        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if (instructor != null) {
            kafkaPublisher.publishInstructorChange(instructor.getName(), "DELETE");
            instructorRepository.deleteById(id);
        } else {
            System.out.println("Instructor with ID " + id + " not found.");
        }
    }
}
