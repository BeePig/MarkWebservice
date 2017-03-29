package com.example.service;

import com.example.model.ClassRoom;
import com.example.model.Mark;
import com.example.model.Students;
import com.example.model.Subject;
import com.example.repository.ClassRepository;
import com.example.repository.MarkRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beepi on 09/05/2016.
 */

@Service
public class MarkService implements MarkServiceDAO {
    @Autowired
    private MarkRepository markRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }


    @Override
    public List<Mark> findByStudent(String code) {
        Students students = studentRepository.findByCodeStudent(code);
        if (students != null) {
            return markRepository.findByStudent(students);
        }
        return null;
    }

    @Override
    public List<Mark> findByCodeClass(String code) {
        ClassRoom classRoom = classRepository.findByCodeClass(code);
        if(classRoom!=null){
            return markRepository.findByClassRoom(classRoom);
        }
        return null;
    }

    @Override
    public Mark findByStudentAndSubjectAndCodeClass(String codeStudent, String codeSubject, String codeClass) {
        Students student = studentRepository.findByCodeStudent(codeStudent);
        ClassRoom classRoom = classRepository.findByCodeClass(codeClass);
        Subject subject = subjectRepository.findByCodeSubject(codeSubject);
        if (student != null & classRoom != null && subject != null) {
            return markRepository.findByStudentAndSubjectAndClassRoom(student,subject,classRoom);
        }
        return null;
    }

    @Override
    public Mark create(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public List<Mark> deleteByCodeClass(String code) {
        ClassRoom classRoom = classRepository.findByCodeClass(code);
        if(classRoom!=null){
            List<Mark> list = markRepository.findByClassRoom(classRoom);
            markRepository.deleteByClassRoom(classRoom);
            return list;
        }
        return null;

    }

    @Override
    public List<Mark> deleteByStudent(String codeStudent) {
        Students student = studentRepository.findByCodeStudent(codeStudent);
        if (student != null) {
            List<Mark> list = markRepository.findByStudent(student);
            markRepository.deleteByStudent(student);
            return list;
        }
        return null;
    }

    @Override
    public List<Mark> deleteAll() {
        List<Mark> list = markRepository.findAll();
        markRepository.deleteAll();
        return list;
    }

    @Override
    public Mark deleteByStudentAndSubjectAndCodeClass(String codeStudent, String codeSubject, String codeClass) {
        Students student = studentRepository.findByCodeStudent(codeStudent);
        ClassRoom classRoom = classRepository.findByCodeClass(codeClass);
        Subject subject = subjectRepository.findByCodeSubject(codeSubject);
        if (student != null & classRoom != null && subject != null) {
            Mark mark = markRepository.findByStudentAndSubjectAndClassRoom(student,subject,classRoom);
            markRepository.deleteByStudentAndSubjectAndClassRoom(student,subject,classRoom);
            return mark;
        }
        return null;
    }

    @Override
    public Mark update(Long id,Mark mark) {
        Mark old = markRepository.findOne(id);
        if(old != null){
            mark.setId(id);
            markRepository.delete(id);
            markRepository.save(mark);
            return mark;
        }
        return null;
    }

}
