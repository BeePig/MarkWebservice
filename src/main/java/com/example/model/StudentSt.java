package com.example.model;

/**
 * Created by beepi on 15/05/2016.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// usage: this is object for student
//        the student will get information of this object for each student 's information
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class StudentSt {

    private String codeStudent;

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }


    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String sex;
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    private String dateOfBirth;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    private String address;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
