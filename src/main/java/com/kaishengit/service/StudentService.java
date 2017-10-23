package com.kaishengit.service;

import com.kaishengit.entity.Student;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2017/10/22.
 */
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    public List<Student> findAllStudents () {

        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        } finally {
            sqlSession.close();
        }
    }

    public Student findStudentById (int id) {

        //logger.debug("select student by id : {}", id);
        SqlSession sqlSession  = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void createStudent (Student student) {

        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteStudentById (int id) {

        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudentById(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateStudentById (Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.updateStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
