package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>(List.of(
                new Student("Nghia", "Le"),
                new Student("Thao", "le"),
                new Student("Nhan", "Le"),
                new Student("Thuy", "Le")
        ));
    }


    @GetMapping("students")
    public List<Student> students(){
        return theStudents;
    }

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int id){
        if(id < 0 || id >= theStudents.size()){
            throw new StudentNotFoundException("lam meo gi co " + id);
        }
        return theStudents.get(id);
    }


}
