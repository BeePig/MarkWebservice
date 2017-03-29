package com.example.controller;

import com.example.model.LoginResponse;
import com.example.model.Students;
import com.example.model.UserLogin;
import com.example.service.AdminDAO;
import com.example.service.StudentServiceDAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by beepi on 08/05/2016.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: controller url for admin
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@RestController
public class StudentAdController {




    @Autowired
    private StudentServiceDAO service;
    @Autowired
    private AdminDAO adminService;

    //-----------------------------------------GET---------------------------------------------------------------//

    /**
     * get all students
     *
     * @return
     */
    //@Role(1)
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/admin/get/student", method = RequestMethod.GET)
    List<Students> getAll() {
        return service.findAll();
    }

    /**
     * get all student by name
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/admin/get/student/name/{name}", method = RequestMethod.GET)
    List<Students> findByName(@PathVariable("name") String name) {
        return service.findByName(name);
    }

    /**
     * get student by  codeStudent
     *
     * @param code
     * @return
     */

    @RequestMapping(value = "/admin/get/student/code/{code}", method = RequestMethod.GET)
    Students findByCodeStudent(@PathVariable("code") String code) {
        return service.findByCodeStudent(code);
    }


    //------------------------------------------POST--------------------------------------------------------------//

    @RequestMapping(value = "/admin/post/student", method = RequestMethod.POST)
    Students save(@RequestBody @Valid Students student) {
        return service.save(student);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public LoginResponse login(@RequestBody final UserLogin login)
    {
        LoginResponse token;
        if (service.findByCodeStudent_Password(login.name, login.password) != null) {
            token = new LoginResponse(Jwts.builder().setSubject(login.name)
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact(),"student");
        }
       else if(adminService.findByUsernameAndPassword(login.name,login.password)!=null){
            token = new LoginResponse(Jwts.builder().setSubject(login.name)
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact(),"admin");
        }else {
            token = new LoginResponse("Invalid login","unknown");
        }

        return token;
    }

    //------------------------------------------DELETE-------------------------------------------------------------//

    /**
     * delete  student by codeStudent
     *
     * @param code
     */


    @RequestMapping(value = "/admin/delete/student/{code}", method = RequestMethod.DELETE)
    Students delete(@PathVariable("code") String code) {

        return service.delete(code);
    }

    /**
     * delete all student
     */

    @RequestMapping(value = "/admin/delete/student", method = RequestMethod.DELETE)
    List<Students> deleteAll() {
        return service.deleteAll();
    }

    //------------------------------------------PUT---------------------------------------------------------------//

    @RequestMapping(value = "/admin/update/student", method = RequestMethod.PUT)
    Students updateByCode(@RequestBody @Valid Students st){
        return service.updateByCodeStudent(st);
    }


}
