package com.dkit.Sd2a.ethan.sia;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Book implements Comparable<Book>
{

    private String bookingID;
    private LocalDateTime bookDateAndTime;
    private LocalDateTime returnDateAndTime;
    private  ArrayList<String> type= new ArrayList<>();
    private String studentId;
    private ArrayList<String> computersTag= new ArrayList<>();
    private static int counter =0000000;
    private String bookDateAndTimeString;
    private String returnDateAndTimeString;



    public Book( ArrayList<String> type,String studentID,ArrayList<String> computersTag)
    {
        counter++;
        this.bookingID ="B" +counter;
        this.bookDateAndTime = LocalDateTime.now();
        this.returnDateAndTime = returnDateAndTime;
        this.type =type;
        this.studentId = studentID;
        this.computersTag = computersTag;


    }

    public Book(String bookingID,String bookDateAndTimeString, String returnDateAndTimeString, ArrayList<String> type, String studentId, ArrayList<String> computersTag)
    {
        this.bookingID = bookingID;
        this.bookDateAndTimeString = bookDateAndTimeString;
        this.returnDateAndTimeString = returnDateAndTimeString;
        this.type = type;
        this.studentId = studentId;
        this.computersTag = computersTag;

    }

    public String getBookingID()
    {
        return bookingID;
    }

    public void setBookingID(String bookingID)
    {
        this.bookingID = bookingID;
    }

    public LocalDateTime getBookDateAndTime()
    {
        return bookDateAndTime;
    }

    public void setBookDateAndTime(LocalDateTime bookDateAndTime)
    {
        this.bookDateAndTime = bookDateAndTime;
    }

    public LocalDateTime getReturnDateAndTime()
    {
        return returnDateAndTime;
    }

    public void  setReturnDateAndTime(LocalDateTime returnDateAndTime)
    {
        this.returnDateAndTime = returnDateAndTime;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(String type) {
        this.type.add(type);
    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public ArrayList<String> getComputersTag()
    {
        return computersTag;
    }

    public void setComputersTag(String computersTag)
    {
        this.computersTag .add(computersTag) ;
    }

    public void addComputersTag(String assetTag)
    {
        computersTag.add(assetTag);

    }

    public int compareTo (Book other)
    {
        return this.bookDateAndTime.compareTo(other.bookDateAndTime);  // return -1,+1,0
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookingID='" + bookingID + '\'' +
                ", bookDateAndTime='" + bookDateAndTime + '\'' +
                ", returnDateAndTime='" + returnDateAndTime + '\'' +
                ", Type=" + type +
                ", studentId=" + studentId +
                ", Computer Tag=" + computersTag +
                '}';
    }
}
