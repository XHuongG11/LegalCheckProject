package com.xhuong.legalcheckproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamStatus {
    @Field("exam_eligibility")
    private String examEligibility; // active, suspended, expelled
    private String reason;
}
