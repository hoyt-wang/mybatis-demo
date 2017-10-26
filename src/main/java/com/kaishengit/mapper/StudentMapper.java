package com.kaishengit.mapper;

import com.kaishengit.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/22.
 */
public interface StudentMapper {

    @Select("select * from t_student")
    List<Student> findAllStudents();
    @Select("select * from t_student where id = #{id}")
    Student findStudentById(int id);
    @Insert("insert into t_student(id,NAME,EMAIL,DOB) VALUES(#{id },#{name},#{email},#{dob})")
    int insertStudent(Student student);
    @Delete("delete from t_student where id = #{id}")
    void deleteStudentById(int id);
    @Update("UPDATE t_student set name = #{name}, email = #{email}, dob = #{dob} WHERE id = #{id}")
    void updateStudent(Student student);
    @Select("select id, name, email from t_student limit #{offset}, #{size}")
    List<Student> page(@Param("offset") int offset,@Param("size") int size);
}

