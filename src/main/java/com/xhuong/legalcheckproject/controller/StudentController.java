package com.xhuong.legalcheckproject.controller;

import com.xhuong.legalcheckproject.dto.request.StudentInfoRequest;
import com.xhuong.legalcheckproject.dto.response.ApiResponse;
import com.xhuong.legalcheckproject.dto.response.StudentInfoResponse;
import com.xhuong.legalcheckproject.model.Student;
import com.xhuong.legalcheckproject.service.student.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllStudent() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(new ApiResponse(200, "success", students));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse> getStudentInfoById(@PathVariable("studentId") String studentId) {
        Student student = studentService.getStudentInfoById(studentId);
        StudentInfoResponse response = studentService.covertToResponse(student);
        return ResponseEntity.ok(new ApiResponse(200, "success", response));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createStudent(@RequestBody StudentInfoRequest request) {
        StudentInfoResponse response = studentService.covertToResponse(studentService.createStudent(request));
        return ResponseEntity.ok(new ApiResponse(200, "success", response));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<ApiResponse> updateStudent(@PathVariable String studentId, @RequestBody StudentInfoRequest request) {
        StudentInfoResponse response = studentService.covertToResponse(studentService.updateStudentInfo(studentId, request));
        return ResponseEntity.ok(new ApiResponse(200, "success", response));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable String studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok(new ApiResponse(200, "success", null));
    }
}
