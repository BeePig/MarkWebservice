package com.example.service;

import com.example.controller.Examination;
import com.example.model.Admin;
import com.example.repository.AdminRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by beepi on 15/05/2016.
 */

@Service
public class AdminService implements AdminDAO {
    private Examination examination = new Examination();
    @Autowired
    private AdminRepository repository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminService;

    @Override
    public Admin findByUsernameAndPassword(String admin, String password) {
        return repository.findByUsernameAndPassword(admin, password);
    }

    @Override
    public Admin findByUsername(String admin) {
        return repository.findByUsername(admin);
    }

    @Override
    public Admin save(Admin admin) {
        if (adminService.findByUsername(admin.getUsername()) == null || studentRepository.findByCodeStudent(admin.getUsername()) == null)
            return repository.save(admin);
        else return null;
    }
}
