package com.dkit.Sd2a.ethan.sia;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Book
{

    private String bookingID;
    private String bookDateAndTime;
    private String returnDateAndTime;
    private String type;
    private String studentId;
    private String assetTag;
    private static int counter =0000000;
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Book(String studentID,String assetTag)
    {
        counter++;
        this.bookingID ="B" +counter;
        this.bookDateAndTime = formatter.format(calendar.getTime());
        this.returnDateAndTime ="";
        this.studentId = studentID;
        this.assetTag = assetTag;


    }

    public Book(String bookID,String bookDateAndTime,String returnDateAndTime,String type,String studentID,String assetTag)
    {
        counter++;
        this.bookingID ="B" +counter;
        this.bookDateAndTime = formatter.format(calendar.getTime());
        this.returnDateAndTime ="";
        this.type = type;
        this.studentId = studentID;
        this.assetTag = assetTag;


    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookDateAndTime() {
        return bookDateAndTime;
    }

    public void setBookDateAndTime(String bookDateAndTime) {
        this.bookDateAndTime = bookDateAndTime;
    }

    public String getReturnDateAndTime() {
        return returnDateAndTime;
    }

    public void setReturnDateAndTime(String returnDateAndTime) {
        this.returnDateAndTime = returnDateAndTime;
    }

    public
    String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }




    @Override
    public String toString() {
        return "Book{" +
                "bookingID='" + bookingID + '\'' +
                ", bookDateAndTime='" + bookDateAndTime + '\'' +
                ", returnDateAndTime='" + returnDateAndTime + '\'' +
                ", Type=" + type +
                ", studentId=" + studentId +
                ", assetTag=" + assetTag +
                '}';
    }
}
