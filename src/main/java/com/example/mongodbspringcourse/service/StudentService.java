package com.example.mongodbspringcourse.service;

import com.example.mongodbspringcourse.model.Student;
import com.example.mongodbspringcourse.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
