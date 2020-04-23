package com.subhasish.aws.dynamodb.db;

import com.subhasish.aws.dynamodb.model.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface  StudentRepository extends CrudRepository<Student, String> {

    Optional<Student> findById(String id);


}
