package com.example.controller;

import com.example.model.Mark;
import com.example.service.MarkServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by beepi on 16/05/2016.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: control mark url
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@RestController
public class MarkController {

    @Autowired
    private MarkServiceDAO service;

    //------------------------------------------------------GET--------------------------------------------------------//

    /**
     * get all mark of all student
     * @param
     * @return
     */
    @RequestMapping(value = "/admin/get/mark",method = RequestMethod.GET)
    public List<Mark> findAll() {
        return service.findAll();
    }
    /**
     * get all mark of student by {@link com.example.model.Students}
     * @param codeStudent
     * @return
     */

    @RequestMapping(value = "/get/mark/codeStudent/{code}",method = RequestMethod.GET)
    public List<Mark> findByStudent_CodeStudent(@PathVariable("code") String codeStudent) {
        return service.findByStudent(codeStudent);
    }

    /**
     *
     * @param code
     * @return list of mark in a class
     */
    @RequestMapping(value = "/admin/get/mark/codeClass/{code}",method = RequestMethod.GET)
    public List<Mark> findByCodeClass(@PathVariable("code") String code){
        return service.findByCodeClass(code);
    }

    /**
     *
     * @param codeStudent
     * @param codeSubject
     * @param codeClass
     * @return mark of student who have codeSubject and codeClass
     */
    @RequestMapping(value = "/get/mark/codeStudent/{codeStudent}/codeSubject/{codeSubject}" +
            "/codeClass/{codeClass}",method = RequestMethod.GET)
    public Mark findByStudentAndSubjectAndCodeClass(
            @PathVariable("codeStudent") String codeStudent,
            @PathVariable("codeSubject") String codeSubject,
            @PathVariable("codeClass") String codeClass){
        return service.findByStudentAndSubjectAndCodeClass(codeStudent,codeSubject,codeClass);
    }
    //-------------------------------------------------POST-----------------------------------------------------------//

    /**
     *
     * @param mark
     * @return new mark
     */
    @RequestMapping(value = "/admin/post/mark",method = RequestMethod.POST)
    public Mark create(@RequestBody @Valid Mark mark){
        return service.create(mark);
    }

    //-------------------------------------------------DELETE---------------------------------------------------------//

    /**
     *
     * @return all mark in server 's database
     */
    @RequestMapping(value = "/admin/delete/mark",method = RequestMethod.DELETE)
    public List<Mark>deleteAll(){
        return service.deleteAll();
    }

    /**
     *
     * @param code
     * @return delete all mark of class
     */
    @RequestMapping(value = "/admin/delete/mark/codeClass/{code}",method = RequestMethod.DELETE)
    public List<Mark> deleteByCodeClass(@PathVariable("code") String code){
        return service.deleteByCodeClass(code);
    }

    /**
     *
     * @param code
     * @return all mark of a student
     */
    @RequestMapping(value = "/admin/delete/mark/codeStudent/{code}",method = RequestMethod.DELETE)
    public List<Mark> deleteByCodeStudent(@PathVariable("code")String code){
        return service.deleteByStudent(code);
    }

    /**
     *
     * @param codeStudent
     * @param codeSubject
     * @param codeClass
     * @return mark which have all above params
     */
    @RequestMapping(value = "/admin/delete/mark/codeStudent/{codeStudent}/codeSubject/" +
            "{codeSubject}/codeClass/{codeClass}",method = RequestMethod.DELETE)
    public Mark deleteByCodeStudentAndCodeSubjectAndCodeClass(@PathVariable("codeStudent")String codeStudent,
              @PathVariable("codeSubject")String codeSubject,@PathVariable("codeClass")String codeClass){
        return service.deleteByStudentAndSubjectAndCodeClass(codeStudent,codeSubject,codeClass);
    }

    //-----------------------------------------------UPDATE-----------------------------------------------------------//
    @RequestMapping(value = "/admin/update/mark/id/{id}",method = RequestMethod.PUT)
    public Mark update(@PathVariable("id")Long id,@RequestBody @Valid Mark mark){
        return service.update(id,mark);
    }
}
