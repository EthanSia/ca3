package com.dkit.Sd2a.ethan.sia;

import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class StudentDB
{
    //private ArrayList<Student>studentList,

    //method - getStudentByID(string ID)
    //       - addStudent(Student s)
    //       - findStudentByID(String ID)
    //       - student.txt.txt


    private ArrayList<Student> studentList;
    private static Scanner kb = new Scanner(System.in);

    public StudentDB()
    {
        this.studentList = new ArrayList<>();
    }

    public Student findStudentById()
    {
        String id;

        System.out.println("Please enter the student id you wish to find ");
        id = kb.next();

        for(Student s : studentList )
        {
            if(s.getId().equals(id))
                System.out.println(s.toString());
        }
        return null;    // not found
    }

    public Student searchStudentById(String id)
    {

        for(Student s : studentList )
        {
            if(s.getId().equals(id))
                return s;
        }
        return null;    // not found
    }

    public void addStudent( )
    {
        String id ="";
        String name;
        String email;
        String telephone;
        boolean checkDuplicate = true;

        while(checkDuplicate == true)
        {
            System.out.println("Please enter the student id ");
            id = kb.next();

            for(Student s : studentList )
            {
                if(s.getId().equals(id))
                {
                    System.out.println("Student id is duplicate!!.Please enter again");
                    checkDuplicate =true;
                }
                else {
                    checkDuplicate =false;
                }

            }
        }

        System.out.println("Please enter the student name");
        name = kb.next();
        System.out.println("Please enter the student email");
        email = kb.next();
        System.out.println("Please enter the student telephone");
        telephone = kb.next();

        studentList.add(new Student(name,id,email,telephone));
    }




    public void removeStudentById( )
    {
        String id;

        System.out.println("Please enter the student id you wish to delete ");
        id = kb.next();

        Student student = searchStudentById(id);
        if( student != null)
            studentList.remove(student);

    }

    public void addAssetTagInLoan(String studentId,ArrayList<String> assetTag)
    {

        for(Student s: studentList)
        {
            if(s.getId().equals(studentId) )
            {
                s.setComputersTag(assetTag);
            }
        }
    }

    public Student searchStudentCompTagById(String assetTag)
    {

        for(Student s : studentList )
        {
            if(s.getComputersTag().contains(assetTag))
                return s;
        }
        return null;    // not found
    }

    public void removeAssetTagInLoan(String compTag)
    {
        Student s = searchStudentCompTagById(compTag);
        Iterator<String> sTag = s.getComputersTag().iterator();
        ArrayList<String>removeTag = new ArrayList<>();
        while(sTag.hasNext())
        {
            String tag = sTag.next();
            if(tag.equals(compTag) )
            {
                tag =null;

            }
            else
            {
                removeTag.add(tag);
            }

        }

        s.setComputersTag(removeTag);


    }

    public void sortStudentDBById ()
    {
        Collections.sort(studentList);
    }
    public void displayAllStudent ()
    {
        for(Student s: studentList)
        {
            System.out.println(s.toString());
        }

    }

    public void editName ()
    {
        System.out.println("Please enter the student id");
        String id =kb.next();

        for(Student s: studentList)
        {
            if(s.getId().equals(id))
            {
                System.out.println("Please enter the name of that student");
                String name = kb.next();
                s.setName(name);
            }

        }

    }

    public void editEmail()
    {
        System.out.println("Please enter the student id");
        String id =kb.next();
        for(Student s: studentList)
        {
            if(s.getId().equals(id))
            {
                System.out.println("Please enter the new email of that student");
                String email = kb.next();
                s.setEmail(email);
            }
            else
            {
                System.out.println("System can't find this person");
            }

        }

    }

    public void editTelephone()
    {
        System.out.println("Please enter the student id");
        String id =kb.next();
        for(Student s: studentList)
        {
            if(s.getId().equals(id))
            {
                System.out.println("Please enter the new telephone of that student");
                String telephone = kb.next();
                s.setTelephone(telephone);
            }

        }

    }

    public  void editStudent(StudentDB sdb)
    {
        Scanner kb = new Scanner(System.in);
        boolean loop = true;
        EditMenu editMenuOption;
        int option;
        while(loop)
        {
            try
            {
                printEditMenu();
                option = kb.nextInt();
                kb.nextLine();
                editMenuOption = EditMenu.values()[option];
                switch(editMenuOption)
                {
                    case QUIT_EDIT:
                        loop = false;
                        break;
                    case EDIT_STUDENT_NAME:
                        sdb.editName();
                        break;
                    case EDIT_STUDENT_EMAIL:
                        sdb.editEmail();
                        break;
                    case EDIT_STUDENT_TELEPHONE:
                        sdb.editTelephone();
                        break;

                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
            }
        }
    }

    private static void printEditMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < EditMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + EditMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }

    protected void loadStudentFromFile()
    {
        try(Scanner studentFile = new Scanner(new BufferedReader(new FileReader("student.txt"))))
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
                ArrayList<String>computersTag =  new ArrayList<>() ;
                for (int i = 4; i < data.length; i++)  //continue to end of data line
                {
                    computersTag.add((data[i]));
                }
                Student readInStudent = new Student(name,id,email,telephone,computersTag);
                this.studentList.add(readInStudent);


            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not load student.txt.If this is " +
                    "the first time running the app this might fine");
        }
    }

    public void saveStudentToFile()
    {
        try(BufferedWriter studentFile = new BufferedWriter(new FileWriter("student.txt") ))
        {
            for(Student s : studentList)
            {
                studentFile.write(s.getName() +","+s.getId()+","+s.getEmail()+","+s.getTelephone()+","+s.getComputersTag());
                studentFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.PURPLE + "Could not save students." +Colours.RESET);
        }
    }

}
