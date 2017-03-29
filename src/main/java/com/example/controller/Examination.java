package com.example.controller;

import com.example.model.Students;
import com.example.repository.StudentRepository;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by beepi on 15/05/2016.
 */


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: this class use for check all database of entering
//        check client have or not have token
//        check username and password of client
//        check authorization
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@Component
public class Examination {

    public static final String HEADER_TOKEN = "Bee_Token";
    public static final String TITLE_TOKEN_LOGIN = "login";
    public static final String TITLE_TOKEN_REQUEST = "request";
    public static final String TOKEN = "token";
    public static final String HEADER_ROLE = "role";
    public ROLE role ;

    HashMap<String,Integer> urlStudent=new HashMap<>();

    public static int state = 0;
    public static enum ROLE {
        ADMIN ,
        STUDENT;
    }
    @Autowired
    private StudentRepository studentService;
    @Autowired
    private AdminService adminService;
    /**
     * this funtion check account of client is exist or not
     * @param username,password
     * @return true if account is exist and false if not
     */

    public boolean checkAccount(String username, String password){
        Students student = studentService.findByCodeStudentAndPassword(username,password);

        if(student!=null){
            return true;
        }
        return false;
    }

    /**
     * usage: check for exist of customer 's token
     * @param httpRequest
     * @return true if have and fals if not have
     */
    public  boolean checkToken(HttpServletRequest httpRequest) {
        if (httpRequest.getHeader(HEADER_TOKEN) != null) {
            if (httpRequest.getHeader(HEADER_TOKEN).equals(TITLE_TOKEN_LOGIN)&& httpRequest.getMethod().equals("POST")) {
                state = 1;
                return true;
            }
            else if (httpRequest.getHeader(HEADER_TOKEN).equals(TITLE_TOKEN_REQUEST) && httpRequest.getHeader(HEADER_ROLE)!= null) {
                if(httpRequest.getHeader(HEADER_ROLE).equals("admin"))
                    role = ROLE.ADMIN;
                else if(httpRequest.getHeader(HEADER_ROLE).equals("student"))
                    role = ROLE.STUDENT;
                else
                   return false;
                state = 2;
                return true;
            } else
                return false;
        }

        return false;
    }



}
