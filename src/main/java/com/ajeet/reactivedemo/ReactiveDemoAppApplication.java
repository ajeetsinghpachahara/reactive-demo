package com.ajeet.reactivedemo;

import com.ajeet.reactivedemo.student.Student;
import com.ajeet.reactivedemo.student.StudentService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class ReactiveDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService){

		return args -> IntStream
				.range(0, 100)
				.forEach(i -> studentService.save(Student.builder()
						.firstname("Ajeet "+i)
						.lastname("Singh "+i)
						.age(i)
						.build()).subscribe());
	}
}
