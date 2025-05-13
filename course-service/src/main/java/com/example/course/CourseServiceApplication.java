package com.example.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



//@SpringBootApplication
//
//public class CourseServiceApplication {
//	public static void main(String[] args) {
//		SpringApplication.run(CourseServiceApplication.class, args);
//	}
//}
@EnableDiscoveryClient  // Enable Eureka client
@EnableKafka
@SpringBootApplication
public class CourseServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}
}
