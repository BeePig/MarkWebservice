package com.example.controller;

import com.example.model.StudentSt;
import com.example.service.StudentServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: controller url for student to find information of student
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@RestController
public class StudentController {


        @Autowired
        private StudentServiceDAO service;

        //-----------------------------------------GET---------------------------------------------------------------//

        /**
         * get all students
         *
         * @return
         */

        @RequestMapping(value = "/get/student", method = RequestMethod.GET)
        List<StudentSt> getAll() {
            return service.findAllStudent();
        }



        @RequestMapping(value = "/get/student/name/{name}", method = RequestMethod.GET)
        List<StudentSt> findByName(@PathVariable("name") String name) {
            return service.findStudentStByName(name);
        }

        /**
         * get student by  codeStudent
         *
         * @param code
         * @return
         */

        @RequestMapping(value = "/get/student/code/{code}", method = RequestMethod.GET)
        StudentSt findByCodeStudent(@PathVariable("code") String code) {
            return service.findStudentStByCode(code);
        }



}
