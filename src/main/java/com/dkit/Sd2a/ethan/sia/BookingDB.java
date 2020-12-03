package com.dkit.Sd2a.ethan.sia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
            if(b.getBookingID().equals(id))
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




}
