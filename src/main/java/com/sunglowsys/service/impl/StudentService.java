package com.sunglowsys.service.impl;

import com.sunglowsys.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    Student update(Student student,Long id);

    Page<Student> findAll(Pageable pageable);

    Optional<Student> findOne(Long id);

    void delete(Long id);
}
