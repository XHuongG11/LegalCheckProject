package com.xhuong.legalcheckproject.service;

import com.xhuong.legalcheckproject.exception.ResourceNotFound;
import com.xhuong.legalcheckproject.model.Student;
import com.xhuong.legalcheckproject.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student getStudentById(String studentId) {
        return studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFound("Student not found."));
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
