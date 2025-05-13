package com.example.student;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class StudentInstructorKafkaConsumer {

    @KafkaListener(topics = "instructor-events", groupId = "student-group")
    public void consume(String message) {
        String[] parts = message.split(":");
        String operation = parts[0];
        String instructorName = parts[1];
        System.out.println("Received Kafka message - Operation: " + operation + ", Instructor: " + instructorName);
    }
}
