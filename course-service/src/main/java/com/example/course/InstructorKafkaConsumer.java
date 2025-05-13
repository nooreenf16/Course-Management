package com.example.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;



@Service
public class InstructorKafkaConsumer {

    @KafkaListener(topics = "instructor-events", groupId = "course-group")
    public void consume(String message) {
        String[] parts = message.split(":");
        String operation = parts[0];
        String instructorName = parts[1];
        System.out.println("Received Kafka message - Operation: " + operation + ", Instructor: " + instructorName);
        // Handle event logic (e.g., cache, sync, etc.)
    }
}
