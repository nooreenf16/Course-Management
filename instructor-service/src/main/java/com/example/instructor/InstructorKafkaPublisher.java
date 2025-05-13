package com.example.instructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class InstructorKafkaPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public InstructorKafkaPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishInstructorChange(String instructorName, String operation) {
        String topic = "instructor-events";
        String message = operation + ":" + instructorName;

        kafkaTemplate.send(topic, message);
        System.out.println("Published Kafka message -> " + message);
    }
}
