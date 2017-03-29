package com.example.controller;

import com.example.model.Subject;
import com.example.service.SubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: control url is object which is subject
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@RestController
public class SubjectController {
    @Autowired
    private SubjectDAO service;
    //--------------------------------------------GET-----------------------------------------------------------------//
    @RequestMapping(value = "/get/subject", method = RequestMethod.GET)
    List<Subject> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/get/subject/code/{code}", method = RequestMethod.GET)
    Subject findByCodeSubject(@PathVariable("code") String code){
        return service.findByCodeSubject(code);
    }

    @RequestMapping(value = "/get/subject/name/{name}", method = RequestMethod.GET)
    Subject findByNameSubject(@PathVariable("name") String name){
        return service.findByNameSubject(name);
    }

    //--------------------------------------------POST----------------------------------------------------------------//
    @RequestMapping(value = "/admin/post/subject", method = RequestMethod.POST)
    Subject save(@RequestBody @Valid Subject subject){
        return service.save(subject);
    }

    //--------------------------------------------DELETE---------------------------------------------------------------//
    @RequestMapping(value = "/admin/delete/subject/code/{code}", method = RequestMethod.DELETE)
    Subject deleteByCodeSubject(@PathVariable("code") String code){
        return service.deleteByCodeSubject(code);
    }

    @RequestMapping(value = "/admin/delete/subject", method = RequestMethod.DELETE)
    List<Subject> deleteAll(){
        return service.deleteAll();
    }

    //---------------------------------------------PUT-----------------------------------------------------------------//
    @RequestMapping(value = "/admin/put/subject", method = RequestMethod.PUT)
    Subject update(@RequestBody @Valid Subject subject){
        return service.update(subject);
    }
}
