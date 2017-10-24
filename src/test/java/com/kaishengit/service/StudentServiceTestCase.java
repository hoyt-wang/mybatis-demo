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
    public void createStudentTest() throws Exception{
        Student student = new Student();
        int id = 9;
        student.setId(id);
        student.setName("ray");
        student.setEmail("ray001@gmail.com");
        String birthDay = "1998-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birthDay);
;       student.setDob(date);
        int updateRows = studentService.createStudent(student);
        System.out.println("UpdateRows-->" + updateRows);
      /*  Student newStudent = studentService.findStudentById(id);
        Assert.assertNotNull(newStudent);*/
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

    @Test
    public void page() {
        List<Student> students = studentService.page(0,3);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
