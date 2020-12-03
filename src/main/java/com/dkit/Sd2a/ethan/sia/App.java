package com.dkit.Sd2a.ethan.sia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ca3
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      App app = new App();
      app.start();
    }

    public static void start()
    {

        Desktop d1 = new Desktop("Desktop","Asus","intel i9","8GB","1TB","3.5kg","D123456","2011-11-20","1 monitor");
        Laptop l1 = new Laptop("Laptop","Asus","intel i9","8GB","1TB","3.5kg","D123457","2011-11-21","12.5 inches","35 hours");
        Raspberry r1 = new Raspberry("Raspberry","Raspberry PI","Model 4B","4GB","1TB","3.5kg","D123458","2011-11-21",15789,"32GB");


        ArrayList<Computer>computers = new ArrayList<>();
        computers.add(d1);
        computers.add(l1);
        computers.add(r1);


        StudentDB studentList = new StudentDB();
        Student s1 = new Student("Anne","D00225147","email@dkit.ie","0834879854");
        Student s2 =new Student("Anna","D00225879","D00225879@student.dkit.ie","0874589856");
        studentList.addStudent(s1);
        studentList.addStudent(s2);

        BookingDB bookingList = new BookingDB();
        Book b1 = new Book("D00225879","D123457");
        bookingList.addBooking(b1);
        bookingList.addBooking(new Book ("D00225147","D123458"));
        bookingList.addBooking(new Book ("D00225147","D123456"));


        System.out.println(b1);
        System.out.println(s2);


    }
}
