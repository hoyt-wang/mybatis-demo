package com.kaishengit.mapper;

import com.kaishengit.entity.Student;
import org.apache.ibatis.annotations.Param;

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
    List<Student> page(@Param("offset") int offset,@Param("size") int size);
}

