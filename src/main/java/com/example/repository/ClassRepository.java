package com.example.repository;

import com.example.model.ClassRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */

@Transactional
public interface ClassRepository extends CrudRepository<ClassRoom, String> {
    //-------------------------------------------GET-------------------------------------------------------------------//\
    List<ClassRoom> findAll();

    ClassRoom findByCodeClass(String code);

    //-------------------------------------------POST------------------------------------------------------------------//
    ClassRoom save(ClassRoom classRoom);

    //-------------------------------------------DELETE----------------------------------------------------------------//
    void deleteByCodeClass(String code);

    void deleteAll();
}
