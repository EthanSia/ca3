package com.dkit.Sd2a.ethan.sia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingDB
{
    //private Arraylist<booking>bookings;

    //Constructor - BookingDB(){bookings = new Arraylist<>();}

    //method - addBookings((string id),(string cid))

    private ArrayList<Book> bookingList;

    public BookingDB()
    {
        this.bookingList = new ArrayList<>();
    }

    public Book findBookById(String id)
    {
        for(Book b: bookingList )
        {
            if(b.getStudentId().equals(id))
                return b;
        }
        return null;    // not found
    }

    public ArrayList<Book> getBookingList()
    {
        return bookingList;
    }

    public void addBooking(Book b)
    {
        bookingList.add( b );
    }

    public void returnComputer(String studentId,String computerId)
    {

        LocalDateTime returnDateObj = LocalDateTime.now();
        DateTimeFormatter returnDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        for(Book b: bookingList )
        {
            if(b.getStudentId().equals(studentId)&&b.getAssetTag().equals(computerId))
            {
                b.setReturnDateAndTime(returnDateObj.format(returnDateFormat));
            }
        }


    }

    public void getComputerType(String studentId, String computerId,ComputerDB cdb)
    {

        Computer c = cdb.findComputerById(computerId);
        String type = null;
        if(c!=null)
        {
            if (c instanceof Raspberry) {
                Raspberry r =(Raspberry) c;
                type = r.getType();
            } else if (c instanceof Laptop) {
                Laptop l =(Laptop) c;
                type = l.getType();
            } else if (c instanceof Desktop) {
                Desktop d =(Desktop) c;
                type =d.getType();
            }
        }

        for(Book b: bookingList )
        {
            if(b.getStudentId().equals(studentId)&&b.getAssetTag().equals(computerId))
            {

              b.setType(type);

            }
        }


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
                String bookDateAndTime = data[1];
                String returnDateAndTime = data[2];
                String type = data[3];
                String studentId = data[4];
                String assetTag = data[5];

                Book readInPlayer =new Book(bookingID,bookDateAndTime,returnDateAndTime,type,studentId,assetTag);
                this.bookingList.add(readInPlayer);


            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not load players.If this is " +
                    "the first time running the app this might fine");
        }
    }







}
