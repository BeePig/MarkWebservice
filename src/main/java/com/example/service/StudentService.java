package com.example.service;

import com.example.controller.Examination;
import com.example.model.StudentSt;
import com.example.model.Students;
import com.example.repository.AdminRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beepi on 08/05/2016.
 */
@Service
public class StudentService implements StudentServiceDAO {

    private Examination examination = new Examination();
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminService;
    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Students findOne(Long id) {
        return studentRepository.findOne(id);
    }


    @Override
    public List<Students> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Students findByCodeStudent(String code) {
        return studentRepository.findByCodeStudent(code);
    }

    @Override
    public Students findByCodeStudent_Password(String codeStudent, String password) {
        return studentRepository.findByCodeStudentAndPassword(codeStudent,password);
    }

    @Override
    public List<StudentSt> findAllStudent() {
        List <Students> list = studentRepository.findAll();
        List<StudentSt> listStudent = new ArrayList<>();
        for (Students student : list){
            StudentSt st=new StudentSt();
            st.setCodeStudent(student.getCodeStudent());
            st.setDateOfBirth(student.getDateOfBirth());
            st.setName(student.getName());
            st.setSex(student.getSex());
            st.setAddress(student.getAddress());
            listStudent.add(st);
        }
        return listStudent;
    }

    @Override
    public StudentSt findStudentStByCode(String code) {
        Students student = (Students) studentRepository.findByCodeStudent(code);
        if(student!=null){
            StudentSt st = new StudentSt();
            st.setAddress(student.getAddress());
            st.setSex(student.getSex());
            st.setName(student.getName());
            st.setDateOfBirth(student.getDateOfBirth());
            st.setCodeStudent(student.getCodeStudent());
            return st;
        }
        return null;
    }

    @Override
    public List <StudentSt> findStudentStByName(String name) {
        List<Students> student =  studentRepository.findByName(name);
        if(student!=null){
            List<StudentSt> st = new ArrayList<>();
            for(StudentSt i: st){
                StudentSt studentSt = new StudentSt();
                studentSt.setAddress(i.getAddress());
                studentSt.setSex(i.getSex());
                studentSt.setName(i.getName());
                studentSt.setDateOfBirth(i.getDateOfBirth());
                studentSt.setCodeStudent(i.getCodeStudent());
                st.add(studentSt);
            }

            return st;
        }
        return null;
    }

    @Override
    public Students save(Students student) {
        if(adminService.findByUsername(student.getCodeStudent())== null|| studentRepository.findByCodeStudent(student.getCodeStudent())==null)

            return studentRepository.save(student);
        else  return null;

    }

    @Override
    public Students delete(String code) {
        Students students = studentRepository.findByCodeStudent(code);
        if(students!=null){
            studentRepository.deleteByCodeStudent(code);
            return students;
        }
        return null;
    }

    @Override
    public List<Students> deleteAll() {
        List<Students> studentses = studentRepository.findAll();
        if(studentses!=null){
            studentRepository.deleteAll();
            return studentses;
        }
        return null;
    }

    @Override
    public Students updateByCodeStudent(Students student) {
        Students students = studentRepository.findByCodeStudent(student.getCodeStudent());
       if(students!=null){
           studentRepository.deleteByCodeStudent(student.getCodeStudent());
           studentRepository.save(student);
           return student;

       }
        return null;
    }

    /**
     * usage: check exist of account, contain admin and student
     * @param username
     * @return true if account has registered and false if not
     */
//    public boolean checkExistAccount(String username){
//        if(adminService.findByUsername(username) == null || studentRepository.findByCodeStudent(username)==null){
//            return true;
//        }
//        return false;
//    }

}
