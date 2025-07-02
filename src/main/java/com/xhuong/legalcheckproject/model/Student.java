package com.xhuong.legalcheckproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "students")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String id;

    @Field("student_id")
    private String studentId;

    @Field("current_info")
    private StudentInfo currentInfo;

    @Field("info_history")
    private List<StudentInfoHistory> infoHistory;

    @Field("exam_participations")
    private List<ExamParticipation> examParticipations;

    private ExamStatus status;

    @Field("created_at")
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentInfo {
        @Field("full_name")
        private String fullName;
        private String dob;
        private String gender;
        @Field("class")
        private String studentClass;
        private String email;
        private String phone;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentInfoHistory extends StudentInfo {
        @Field("update_at")
        private LocalDateTime updatedAt;
    }
}
