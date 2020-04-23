package com.subhasish.aws.dynamodb.controller;

import com.subhasish.aws.dynamodb.model.Student;
import com.subhasish.aws.dynamodb.service.StudentRepositoryIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Subhasish Sahu
 * @date : 27/03/2020
 **/
@RestController
@RequestMapping(value = "/api/tests")
public class Controller {


    @Autowired
    private StudentRepositoryIntegration studentRepositoryIntegration;


    @RequestMapping("/findByAll")
    public List<Student> getDBObjects(HttpServletRequest request) {
        List<Student> studentData  =studentRepositoryIntegration.getStudent();
        return studentData;
    }

    @RequestMapping("/findById")
    public String findById(@RequestParam("id") String id) {
        String result = "";
        result = studentRepositoryIntegration.getStudentByID(id);
        return result;
    }

    @RequestMapping("/save")
    public String saveStudent() {
        String result = "";
        result =studentRepositoryIntegration.saveStudent();
        return result;
    }
}
