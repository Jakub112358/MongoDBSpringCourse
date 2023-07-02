package com.example.mongodbspringcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.mongodbspringcourse.repository")
@ComponentScan("com.example.mongodbspringcourse.*")
public class MongoDbSpringCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbSpringCourseApplication.class, args);
    }

}
