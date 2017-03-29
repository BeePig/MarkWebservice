package com.example.controller;

import com.example.model.ClassRoom;
import com.example.service.ClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: control object classs
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@RestController
public class ClassController {
    @Autowired
    private ClassDAO service;
    //-------------------------------------------GET-------------------------------------------------------------------//\
    @RequestMapping(value = "/get/class", method = RequestMethod.GET)
    List<ClassRoom> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/get/class/code/{code}", method = RequestMethod.GET)
    ClassRoom findByCodeClass(@PathVariable("code") String code){
        return service.findByCodeClass(code);
    }

    //-------------------------------------------POST------------------------------------------------------------------//
    @RequestMapping(value = "/admin/post/class", method = RequestMethod.POST)
    ClassRoom save(@RequestBody @Valid ClassRoom classRoom){
        return service.save(classRoom);
    }

    //-------------------------------------------DELETE----------------------------------------------------------------//
    @RequestMapping(value = "/admin/delete/class/code/{code}", method = RequestMethod.DELETE)
    ClassRoom deleteByCodeClass(@PathVariable("code") String code){

        return service.deleteByCodeClass(code);
    }

    @RequestMapping(value = "/admin/delete/class", method = RequestMethod.DELETE)
    List<ClassRoom> deleteAll(){
        return service.deleteAll();
    }
    //-------------------------------------------UPDATE---------------------------------------------------------------//

    @RequestMapping(value = "/admin/update/class", method = RequestMethod.PUT)
    ClassRoom update(@RequestBody @Valid ClassRoom classRoom){
        return service.update(classRoom);
    }
}
