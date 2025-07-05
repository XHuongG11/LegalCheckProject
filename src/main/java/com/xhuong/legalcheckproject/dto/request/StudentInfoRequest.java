package com.xhuong.legalcheckproject.dto.request;

import com.xhuong.legalcheckproject.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoRequest {
    private String studentId;
    private Student.StudentInfo currentInfo;
}
