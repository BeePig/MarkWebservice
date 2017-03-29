package com.example.repository;

import com.example.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */

@Transactional
public interface SubjectRepository extends CrudRepository<Subject,Long>{

    //--------------------------------------------GET-----------------------------------------------------------------//
    List<Subject> findAll();

    Subject findByCodeSubject(String code);

    Subject findByNameSubject(String name);

    //--------------------------------------------POST----------------------------------------------------------------//
    Subject save(Subject subject);

    //--------------------------------------------DELETE---------------------------------------------------------------//
    void deleteByCodeSubject(String code);

    void deleteAll();


}
