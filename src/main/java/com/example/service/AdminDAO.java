package com.example.service;

import com.example.model.Admin;

/**
 * Created by beepi on 15/05/2016.
 */
public interface AdminDAO {
    Admin findByUsernameAndPassword(String admin,String password);
    Admin findByUsername(String admin);
    //------------------------------------------CREATE--------------------------------------------------------------//
    Admin save(Admin admin);
}
