package com.kaishengit.mapper;

import com.kaishengit.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/10/22.
 */
public interface StudentMapper {

    List<Student> findAllStudents();
    Student findStudentById(int id);
    void insertStudent(Student student);
    void deleteStudentById(int id);
    void updateStudent(Student student);
}

