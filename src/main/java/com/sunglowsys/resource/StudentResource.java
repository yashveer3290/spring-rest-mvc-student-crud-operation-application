package com.sunglowsys.resource;

import com.sunglowsys.domain.Student;
import com.sunglowsys.service.impl.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student result = studentService.save(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(student);
    }

    @PutMapping("students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        Student result = studentService.update(student,id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<Page<Student>> getAll() {
        Page<Student> result = studentService.findAll(PageRequest.of(0,10));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> getOneStudent(@PathVariable Long id) {
        Optional<Student> result = studentService.findOne(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
