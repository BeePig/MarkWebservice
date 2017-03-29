package com.example.service;

import com.example.model.Subject;

import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */
public interface SubjectDAO
{
    //--------------------------------------------GET-----------------------------------------------------------------//
    List<Subject> findAll();

    Subject findByCodeSubject(String code);

    Subject findByNameSubject(String name);

    //--------------------------------------------POST----------------------------------------------------------------//
    Subject save(Subject subject);

    //--------------------------------------------DELETE---------------------------------------------------------------//
    Subject deleteByCodeSubject(String code);

    List<Subject> deleteAll();

    //--------------------------------------------UPDATE----------------------------------------------------------------//
     Subject update(Subject subject);
}
