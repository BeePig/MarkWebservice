package com.example.service;

import com.example.model.ClassRoom;
import com.example.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */

@Service
public class ClassService implements ClassDAO {
    @Autowired
    private ClassRepository repository;
    @Override
    public List<ClassRoom> findAll() {
        return repository.findAll();
    }

    @Override
    public ClassRoom findByCodeClass(String code) {
        return repository.findByCodeClass(code);
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return repository.save(classRoom);
    }

    @Override
    public ClassRoom deleteByCodeClass(String code) {
        ClassRoom classRoom = repository.findByCodeClass(code);
        if(classRoom!=null){
            repository.deleteByCodeClass(code);
            return classRoom;
        }
        return null;
    }

    @Override
    public List<ClassRoom> deleteAll() {
        List<ClassRoom> classRooms = repository.findAll();
        if(classRooms!=null){
            repository.deleteAll();
            return classRooms;
        }
        return null;
    }

    @Override
    public ClassRoom update(ClassRoom classRoom) {
        ClassRoom clr = repository.findByCodeClass(classRoom.getCodeClass());
        if(clr!=null){
            repository.save(classRoom);
            return classRoom;
        }
        return null;
    }
}
