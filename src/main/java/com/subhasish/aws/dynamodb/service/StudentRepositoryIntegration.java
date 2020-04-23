package com.subhasish.aws.dynamodb.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.google.gson.Gson;
import com.subhasish.aws.dynamodb.db.StudentRepository;
import com.subhasish.aws.dynamodb.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentRepositoryIntegration {

    private static final Logger logger = LogManager.getLogger(StudentRepositoryIntegration.class);

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private StudentRepository repository;


    public List<Student> getStudent() {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        Optional<Student> awsServiceQueried = repository.findById("1");
        if (awsServiceQueried.get() != null) {
            logger.info("Queried object: " + new Gson().toJson(awsServiceQueried.get()));
        }

        Iterable<Student> awsServices = repository.findAll();
        for (Student awsServiceObject : awsServices) {
            logger.info("List object: " + new Gson().toJson(awsServiceObject));
        }
        return (List<Student>) awsServices;
    }


    public String getStudentByID(String id) {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        Optional<Student> awsServiceQueried = repository.findById(id);
        if (awsServiceQueried.get() != null) {
            logger.info("Queried object: " + new Gson().toJson(awsServiceQueried.get()));
        }
        return  new Gson().toJson(awsServiceQueried.get());

    }


    public String saveStudent() {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        //repository.save(new Student("2", "Jack", "Mumbai"));

        // save a list of student
        repository.saveAll(Arrays.asList(new Student("3", "Adam", "Delhi"),new Student("4", "Kim", "Cuttack"),new Student("5", "David", "Noida")));
        return  "Inserted Successfully";

    }


}
