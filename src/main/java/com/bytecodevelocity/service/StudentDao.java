package com.bytecodevelocity.service;

import com.bytecodevelocity.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional//since the class is comunicating with the database
public class StudentDao {

    @PersistenceContext
    EntityManager em;

    public void insertStudent(Student stu){
        em.persist(stu);
    }

}
