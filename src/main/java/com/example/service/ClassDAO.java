package com.example.service;

import com.example.model.ClassRoom;

import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */
public interface ClassDAO {
    //-------------------------------------------GET-------------------------------------------------------------------//\
    List<ClassRoom> findAll();

    ClassRoom findByCodeClass(String code);

    //-------------------------------------------POST------------------------------------------------------------------//
    ClassRoom save(ClassRoom classRoom);

    //-------------------------------------------DELETE----------------------------------------------------------------//
    ClassRoom deleteByCodeClass(String code);

    List<ClassRoom> deleteAll();
    //-------------------------------------------UPDATE---------------------------------------------------------------//

    ClassRoom update(ClassRoom classRoom);
}
