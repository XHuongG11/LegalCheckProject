package com.xhuong.legalcheckproject.dto.response;

import com.xhuong.legalcheckproject.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoResponse {
    private String studentId;
    private Student.StudentInfo currentInfo;
}
