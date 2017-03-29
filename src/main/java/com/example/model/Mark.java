package com.example.model;

import javax.persistence.*;

/**
 * Created by beepi on 08/05/2016.
 */
@Entity
@Table(name = "mark")
public class Mark {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject")
    private Subject subject;
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Column(name = "conditional_mark")
    private String conditionalMark;
    public String getConditionalMark() {
        return conditionalMark;
    }

    public void setConditionalMark(String conditionalMark) {
        this.conditionalMark = conditionalMark;
    }



    @Column(name = "end_mark")
    private String endMark;
    public String getEndMark() {
        return endMark;
    }

    public void setEndMark(String endMark) {
        this.endMark = endMark;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "code_student")
    private Students student;

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "code_class")
    private ClassRoom classRoom;
    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

}
