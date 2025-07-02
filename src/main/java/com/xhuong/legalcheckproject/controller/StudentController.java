package com.xhuong.legalcheckproject.controller;

import com.xhuong.legalcheckproject.dto.response.ApiResponse;
import com.xhuong.legalcheckproject.model.Student;
import com.xhuong.legalcheckproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllStudent() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(new ApiResponse(200, "success", students));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse> getStudentById(@PathVariable("studentId") String studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(new ApiResponse(200, "success", student));
    }
}
