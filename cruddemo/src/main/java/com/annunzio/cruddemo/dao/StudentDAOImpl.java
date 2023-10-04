package com.annunzio.cruddemo.dao;

import com.annunzio.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Annotation for repos, supports component scanning, translates JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{
    //Define field for entity manager
    private EntityManager entityManager;
    //Inject entity manager using constructor
    @Autowired
    public StudentDAOImpl(EntityManager em){
        this.entityManager = em;
    }
    //Implement save method
    @Override
    @Transactional
    public void save(Student someStudent) {
        entityManager.persist(someStudent);
    }

    //Don't need transactional since we are only querying.
    //We are not performing any updates to DB
    @Override
    public Student  findById(Integer studentId){
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAll() {
        //FROM Student = the name of the JPA entity.  Not the name of the Database table
        //ALL JPQL is syntax is based on entity name and entity fields
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }
}
