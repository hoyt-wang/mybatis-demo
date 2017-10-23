package com.kaishengit.service;

import com.kaishengit.entity.Student;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/22.
 */
public class StudentServiceTestCase {

    private static StudentService studentService = new StudentService();

   /* @BeforeClass
    public static void setup()
    {
        studentService = new StudentService();
    }
    @AfterClass
    public static void teardown()
    {
        studentService = null;
    }
    */

    @Test
    public void findAllStudentsTest () {
        List<Student> students = studentService.findAllStudents();
        Assert.assertNotNull(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void findStudentByIdTest() {

        Student student = studentService.findStudentById(1);
        Assert.assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void createStudentTest() {
        Student student = new Student();
        int id = 7;
        student.setId(id);
        student.setName("james");
        student.setEmail("lerbron@gmail.com");
        Date date = new Date();
;       student.setDob(date);
        studentService.createStudent(student);
        Student newStudent = studentService.findStudentById(id);
        Assert.assertNotNull(newStudent);
    }

    @Test
    public void deleteStudentTest() {
        Student student = new Student();
        studentService.deleteStudentById(4);

    }

    @Test
    public void updateStudentByIdTest() {

        Student student = studentService.findStudentById(6);
        student.setName("ray");
        student.setEmail("ray@yahoo.com");
        String birthDay = "1988-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(birthDay);
            student.setDob(date);
            studentService.updateStudentById(student);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
