package com.example.mongodbspringcourse.repository;

import com.example.mongodbspringcourse.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {
}
