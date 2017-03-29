package com.example.repository;

import com.example.model.ClassRoom;
import com.example.model.Mark;
import com.example.model.Students;
import com.example.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by beepi on 09/05/2016.
 */

@Transactional
public interface MarkRepository extends CrudRepository<Mark, Long> {


    //-----------------------------------------SELECT---------------------------------------------------------------//

    List<Mark> findByStudent(Students student);

    List<Mark> findAll();

    List<Mark> findByClassRoom(ClassRoom classRoom);

    Mark findByStudentAndSubjectAndClassRoom(Students student, Subject subject, ClassRoom classRoom);

    Mark findOne(Long id);


    //------------------------------------------CREATE--------------------------------------------------------------//

    Mark save(Mark mark);

    //------------------------------------------DELETE--------------------------------------------------------------//
    void deleteByClassRoom(ClassRoom classRoom);

    void deleteByStudent(Students students);

    void deleteAll();

    void deleteByStudentAndSubjectAndClassRoom(Students student, Subject subject, ClassRoom classRoom);

//------------------------------------------UPDATE---------------------------------------------------------------//

}