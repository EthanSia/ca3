package com.dkit.Sd2a.ethan.sia;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Book
{
    private String bookingID;
    private String bookDateAndTime;
    private String returnDateAndTime;
    private Map<String,Student> students;
    private Map<String,Computer> comp;
    private static int counter =0000000;
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Book()
    {
        counter++;
        this.bookingID ="B" +counter;
        this.bookDateAndTime = formatter.format(calendar.getTime());
        this.returnDateAndTime = returnDateAndTime;
        students = new HashMap<>();
        comp = new HashMap<>();


    }

    public void addStudent( Student student )
    {
        students.put(student.getId(),student);  // use asset tag as Key, and Comp object as value
    }

    public void addComp( Computer compTag )
    {
        comp.put(compTag.getAssetTag(),compTag);  // use asset tag as Key, and Comp object as value
    }

    public Student getStudentById(String id)
    {
        return students.get(id);    // return student object or null if not found
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookingID='" + bookingID + '\'' +
                ", bookDateAndTime='" + bookDateAndTime + '\'' +
                ", returnDateAndTime='" + returnDateAndTime + '\'' +
                ", students=" + students +
                ", comp=" + comp +
                '}';
    }
}
