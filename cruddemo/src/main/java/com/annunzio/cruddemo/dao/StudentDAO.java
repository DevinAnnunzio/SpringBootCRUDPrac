package com.annunzio.cruddemo.dao;

import com.annunzio.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student someStudent);
    Student findById(Integer studentId);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Integer  studentId);

    int deleteAll();
}
