package com.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by beepi on 26/04/2016.
 */
@Entity
@Table(name = "student")
public class Students {

    @Id
    @Column(name = "CODE_STUDENT")
    private String codeStudent;
    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "NAME")
    private String name;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "SEX")
    private String sex;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "ADDRESS")
    private String address;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    List<Mark> marks;

}
