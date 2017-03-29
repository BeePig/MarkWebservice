package com.example.service;

import com.example.model.Mark;

import java.util.List;

/**
 * Created by beepi on 09/05/2016.
 */
public interface MarkServiceDAO {
    //-----------------------------------------SELECT---------------------------------------------------------------//
    List<Mark> findAll();

    List<Mark> findByStudent(String code);

    List<Mark> findByCodeClass(String code);

    Mark findByStudentAndSubjectAndCodeClass(String codeStudent,String codeSubject,String codeClass);

    //-----------------------------------------POST-----------------------------------------------------------------//
    Mark create(Mark mark);

    //------------------------------------------DELETE--------------------------------------------------------------//
   List <Mark> deleteByCodeClass(String code);

    List <Mark> deleteByStudent(String codeStudent);

    List<Mark> deleteAll();
    Mark deleteByStudentAndSubjectAndCodeClass(String codeStudent,String codeSubject,String codeClass);

    //--------------------------------------------UPDATE--------------------------------------------------------------//

    Mark update(Long id,Mark mark);
}
