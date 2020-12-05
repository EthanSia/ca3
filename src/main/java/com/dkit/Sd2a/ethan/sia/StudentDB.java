package com.dkit.Sd2a.ethan.sia;

import java.io.*;
import java.lang.reflect.Array;
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
                s.addComputersTag(assetTag);
            }
        }
    }

    protected void loadStudentFromFile()
    {
        try(Scanner studentFile = new Scanner(new BufferedReader(new FileReader("booking.txt"))))
        {

            String input;
            while (studentFile.hasNextLine())
            {
                input = studentFile.nextLine();
                String [] data = input.split(",");
                String name = data[0];
                String id = data[1];
                String email = data[2];
                String telephone = data[3];
                ArrayList<String> computersTag = new ArrayList<>();
                computersTag.add(data[4]);


                Student readInStudent =new Student(name,id,email, telephone,  computersTag);
                this.studentList.add(readInStudent);


            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not load student.If this is " +
                    "the first time running the app this might fine");
        }
    }


}
