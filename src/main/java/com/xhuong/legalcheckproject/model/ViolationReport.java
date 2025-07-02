package com.xhuong.legalcheckproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViolationReport {
    @Field("has_violation")
    private boolean hasViolation;
    private String level; // Khiển trách, cảnh cáo, đình chỉ, đuổi học
    private String description;
    private List<Invigilator> invigilators;
    private String notes;
}
