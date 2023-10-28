package com.ajeet.reactivedemo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    Mono<Student> save(@RequestBody Student student){
        return  studentService.save(student);
    }

    @GetMapping
    Flux<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    Mono<Student> findById(@PathVariable("id") Integer id){
        return studentService.findById(id);
    }

    @GetMapping("/stream-data")
    public Flux<String> streamData() {
        // Create a Flux that emits data as a stream
        return Flux.just("Data 1", "Data 2", "Data 3", "Data 4", "Data 5")
                .delayElements(Duration.ofSeconds(1));
    }

}
