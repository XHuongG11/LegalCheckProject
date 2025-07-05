package com.xhuong.legalcheckproject.service.student;

import com.xhuong.legalcheckproject.dto.request.StudentInfoRequest;
import com.xhuong.legalcheckproject.dto.response.StudentInfoResponse;
import com.xhuong.legalcheckproject.exception.ResourceNotFoundException;
import com.xhuong.legalcheckproject.model.Student;
import com.xhuong.legalcheckproject.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    public Student getStudentInfoById(String studentId) {
        return studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found."));
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(StudentInfoRequest student) {
        Student newStudent = Student.builder()
                .studentId(student.getStudentId())
                .currentInfo(student.getCurrentInfo())
                .createdAt(LocalDateTime.now())
                .build();
        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudentInfo(String studentId, StudentInfoRequest request) {
        Student student = getStudentInfoById(studentId);
        Student.StudentInfo currentInfo = student.getCurrentInfo();

        List<Student.StudentInfoHistory> studentInfoHistory = student.getInfoHistory();
        if(studentInfoHistory == null)
            studentInfoHistory = new ArrayList<>();

        // luu thong tin cu
        studentInfoHistory.add(
                Student.StudentInfoHistory.builder()
                        .fullName(currentInfo.getFullName())
                        .dob(currentInfo.getDob())
                        .gender(currentInfo.getGender())
                        .studentClass(currentInfo.getStudentClass())
                        .email(currentInfo.getEmail())
                        .phone(currentInfo.getPhone())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );

        student.setInfoHistory(studentInfoHistory);
        student.setCurrentInfo(request.getCurrentInfo());
        student.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        studentRepository.deleteByStudentId(studentId);
    }


    public StudentInfoResponse covertToResponse(Student student) {
        return modelMapper.map(student, StudentInfoResponse.class);
    }
}
