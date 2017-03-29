package com.example.service;

import com.example.model.Subject;
import com.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beepi on 15/05/2016.
 */
@Service
public class SubjectService implements SubjectDAO {
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findByCodeSubject(String code) {
        return subjectRepository.findByCodeSubject(code);
    }

    @Override
    public Subject findByNameSubject(String name) {
        return subjectRepository.findByNameSubject(name);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject deleteByCodeSubject(String code) {
        Subject subject = subjectRepository.findByCodeSubject(code);
        if(subject != null){
            subjectRepository.deleteByCodeSubject(code);
            return subject;
        }
       return null;
    }

    @Override
    public List<Subject> deleteAll() {
         List<Subject> subjects = subjectRepository.findAll();
        if(subjects!= null){
            subjectRepository.deleteAll();
            return subjects;
        }
       return null;
    }

    @Override
    public Subject update(Subject subject) {
        Subject sb = subjectRepository.findByCodeSubject(subject.getCodeSubject());
        if(sb!=null){
            Subject newSubject = new Subject();
            newSubject.setCodeSubject(subject.getCodeSubject());
            newSubject.setNameSubject(subject.getNameSubject());
            subjectRepository.deleteByCodeSubject(sb.getCodeSubject());
            subjectRepository.save(newSubject);
            return newSubject;
        }
        return null;
    }
}
