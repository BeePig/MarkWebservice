package com.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by beepi on 08/05/2016.
 */

@Entity
@Table(name = "subject")
public class Subject {


    @Id
    @Column(name = "code_subject")
    private String codeSubject;

    public String getCodeSubject() {
        return codeSubject;
    }

    public void setCodeSubject(String codeSubject) {
        this.codeSubject = codeSubject;
    }


    @Column(name = "name")
    private String nameSubject;
    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<Mark> marks;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "subject")
    private List<ClassRoom>classRooms;

}
