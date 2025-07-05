package com.xhuong.legalcheckproject.service.student;

import com.xhuong.legalcheckproject.dto.request.StudentInfoRequest;
import com.xhuong.legalcheckproject.dto.response.StudentInfoResponse;
import com.xhuong.legalcheckproject.model.Student;

import java.util.List;

public interface IStudentService {
    Student getStudentInfoById(String studentId);
    List<Student> getAllStudents();
    Student createStudent(StudentInfoRequest student);
    Student updateStudentInfo(String studentId, StudentInfoRequest student);
    void deleteStudent(String studentId);
    StudentInfoResponse covertToResponse(Student student);
}
