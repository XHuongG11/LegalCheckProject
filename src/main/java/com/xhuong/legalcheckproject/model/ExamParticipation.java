package com.xhuong.legalcheckproject.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Builder
public class ExamParticipation {
    @Field("exam_date")
    private LocalDate examDate;
    private String area;
    private String room;
    private String shift;

    private ViolationReport violation;
}
