package com.dkit.Sd2a.ethan.sia;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookingDB
{
    //private Arraylist<booking>bookings;

    //Constructor - BookingDB(){bookings = new Arraylist<>();}

    //method - addBookings((string id),(string cid))

    private ArrayList<Book> bookingList;
    private static Scanner kb = new Scanner(System.in);

    public BookingDB()
    {
        this.bookingList = new ArrayList<>();
    }

    protected void loadBookingFromFile()
    {
        try(Scanner bookingsFile = new Scanner(new BufferedReader(new FileReader("booking.txt"))))
        {

            String input;
            while (bookingsFile.hasNextLine())
            {
                input = bookingsFile.nextLine();
                String [] data = input.split(",");
                String bookingID = data[0];
                LocalDateTime bookDateAndTime = LocalDateTime.parse(data[1]);
                LocalDateTime returnDateAndTime = LocalDateTime.parse(data[2]);
                ArrayList<String> type = new ArrayList<>();
                for (int i = 3; i < data.length; i++)  //continue to end of data line
                {
                    type.add((data[i]));
                }
                String studentId = data[4];
                ArrayList<String> computersTag = new ArrayList<>();
                for (int i = 5; i < data.length; i++)  //continue to end of data line
                {
                    computersTag.add((data[i]));
                }

                Book readInBooking =new Book(bookingID,bookDateAndTime,returnDateAndTime,type,studentId,computersTag );
                this.bookingList.add(readInBooking);


            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not load booking.If this is " +
                    "the first time running the app this might fine");
        }
    }

    public void saveBookingToFile()
    {
        try(BufferedWriter bookingFile = new BufferedWriter(new FileWriter("booking.txt") ))
        {
            for(Book b : bookingList)
            {
                bookingFile.write(b.getBookingID() +","+b.getBookDateAndTime()+","+b.getReturnDateAndTime()+","+b.getType()+","+b.getStudentId()+","+b.getComputersTag());
                bookingFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.PURPLE + "Could not save students." +Colours.RESET);
        }
    }

    public Book findBookById(String id)
    {
        for(Book b: bookingList )
        {
            if(b.getBookingID().equals(id))
                return b;
        }
        return null;    // not found
    }

    public ArrayList<Book> getBookingList()
    {
        return bookingList;
    }

    public void addBooking(ComputerDB cdb,StudentDB sdb)
    {
        ArrayList<String>tag = new ArrayList<>();
        ArrayList<String>type = new ArrayList<>();
        String studentID;
        String assetTag;
        String ans ="y";

        System.out.println("Please enter the student id");
        studentID = kb.next();
        if(sdb.searchStudentById(studentID) != null)
        {
            while(ans.equals("y"))
            {
                System.out.println("Please enter the computer assetTag");
                assetTag = kb.next();
                type.add(getComputerType(assetTag,cdb));
                sdb.addAssetTagInLoan(studentID,assetTag);
                tag.add(assetTag);
                System.out.println("Do you want to add another computer tag for this booking");
                ans = kb.next();
            }


            bookingList.add( new Book(type,studentID,tag));
        }
        else
        {
            System.out.println("This student is not exist in the system");
        }
    }

    public void removeBookById( )
    {
        String id;

        System.out.println("Please enter the book id you wish to delete ");
        id = kb.next();

        Book b = findBookById(id);
        if( b != null)
           bookingList.remove(b);

    }

    public void returnComputer(StudentDB sdb)
    {
        System.out.println("Please enter the student id");
        String studentId = kb.next();

        System.out.println("Please enter the computer id");
        String computerId = kb.next();



        for(Book b: bookingList )
        {
            if(b.getStudentId().equals(studentId)&&b.getComputersTag().contains(computerId))
            {
                b.setReturnDateAndTime(LocalDateTime.now());
                if(sdb.searchStudentById(studentId).equals(studentId))
                {
                    sdb.removeAssetTagInLoan(computerId);
                }

            }
            else
            {
                System.out.println("The student id or computer id is not found");
            }
        }




    }

    public String getComputerType( String computerId,ComputerDB cdb)
    {

        Computer c = cdb.findComputerById(computerId);
        String type = null;

        if(c!=null)
        {
            if (c instanceof Raspberry) {
                Raspberry r =(Raspberry) c;
               return type = r.getType();

            } else if (c instanceof Laptop) {
                Laptop l =(Laptop) c;
                return  type = l.getType();

            } else if (c instanceof Desktop) {
                Desktop d =(Desktop) c;
                return  type =d.getType();

            }
        }
        return null;
    }
    public void sortBookingByDateTime ()
    {
        Collections.sort(bookingList);
    }

    public void displayAllBookings()
    {
        for(Book b: bookingList )
        {
            System.out.println(b.toString());
        }
    }









}
