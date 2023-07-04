package com.example.mongodbspringcourse.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String name;
    @Field(name = "mail")
    private String email;
    @DBRef
    private Department department;
    @DBRef
    private List<Subject> subjects;
    @Transient
    private double percentage;

    @PersistenceCreator
    public Student(String id, String name, String email, Department department, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.subjects = subjects;
    }

    public Student() {
    }

    public double getPercentage() {
        if(subjects != null && subjects.size()>0){
            double total = 0.0;
            for(Subject subject: subjects){
                total += subject.getMarksObtained();
            }
            return total/subjects.size();
        }
        return 0.0;
    }
}
