package com.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by beepi on 08/05/2016.
 */

@Entity
@Table(name = "class_room")
public class ClassRoom {

    @Id
    @Column(name = "code_class")
    private String codeClass;
    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "code_subject")
    private Subject subject;
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "classRoom")
    List<Mark> marks;

}
