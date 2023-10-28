package com.ajeet.reactivedemo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Flux<Student> findAll(){
       return studentRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Integer id){
        return  studentRepository.findById(id);
    }

    public Mono<Student> save(Student student){
        return  studentRepository.save(student);
    }
}
