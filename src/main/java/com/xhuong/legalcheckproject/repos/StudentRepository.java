package com.xhuong.legalcheckproject.repos;

import com.xhuong.legalcheckproject.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByStudentId(String id);
    void deleteByStudentId(String id);
}
