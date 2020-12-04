package com.dkit.Sd2a.ethan.sia;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class StudentDB
{
    //private ArrayList<Student>studentList,

    //method - getStudentByID(string ID)
    //       - addStudent(Student s)
    //       - findStudentByID(String ID)
    //       - student.txt


    private ArrayList<Student> studentList;

    public StudentDB()
    {
        this.studentList = new ArrayList<>();
    }

    public Student findStudentById(String id)
    {
        for(Student s : studentList )
        {
            if(s.getId().equals(id))
                return s;
        }
        return null;    // not found
    }

    public void addStudent( Student s)
    {
        studentList.add( s );
    }

    //public void addStudentById( String id)
    //{
    //     //
    // }

    public void removeStudentById( String id )
    {
        Student student = findStudentById( id );
        if( student != null)
            studentList.remove(student);

    }


    public void addAssetTagInLoan(String studentId,String assetTag)
    {
        for(Student s: studentList)
        {
            if(s.getId() == studentId)
            {
                s.setComputersTag(assetTag);
            }
        }
    }

    public void loadStudentsFromFile()
    {
        // open 'students.txt' file
        // read records and instantiate new Student objects
        // add each new student object to s
    }


}
