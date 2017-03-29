package com.example.service;

import com.example.model.StudentSt;
import com.example.model.Students;

import java.util.List;

/**
 * Created by beepi on 08/05/2016.
 */


public interface StudentServiceDAO {
    /********************************************admin***************************************************************/

    //-----------------------------------------SELECT---------------------------------------------------------------//


    List<Students> findAll();

    Students findOne(Long id);


    List<Students> findByName(String name);
    Students findByCodeStudent(String code);
    Students findByCodeStudent_Password(String codeStudent,String password);

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    Students save(Students student);

    //------------------------------------------DELETE--------------------------------------------------------------//
    Students delete(String code);


    List <Students> deleteAll();

    //------------------------------------------UPDATE---------------------------------------------------------------//
    Students updateByCodeStudent(Students student);



    /************************************************student******************************************************/

    //GET
    List<StudentSt> findAllStudent();
    StudentSt findStudentStByCode(String code);
    List<StudentSt> findStudentStByName(String name);

}
