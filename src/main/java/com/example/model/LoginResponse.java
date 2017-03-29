package com.example.model;


    public class LoginResponse {
        public String token;
        public String role;
        public LoginResponse(final String token,final String role) {
            this.token = token;
            this.role = role;
        }
    }