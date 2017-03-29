package com.example.repository;

import com.example.model.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by beepi on 08/05/2016.
 */
@Transactional
//@PreAuthorize("hasRole('ROLE_USER')")
public interface StudentRepository  extends CrudRepository<Students,Long> {

    //-----------------------------------------SELECT---------------------------------------------------------------//
   // @PreAuthorize("hasRole('ROLE_ADMIN')")

    List<Students> findAll();

    Students findOne(Long id);


    List<Students> findByName(String name);
    Students findByCodeStudent(String code);
    Students findByCodeStudentAndPassword(String codeStudent, String password);


    //------------------------------------------CREATE--------------------------------------------------------------//
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    Students save(Students student);

    //------------------------------------------DELETE--------------------------------------------------------------//
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteByCodeStudent(String code);


    void deleteAll();

    //------------------------------------------UPDATE---------------------------------------------------------------//



}
