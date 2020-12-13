package com.dkit.Sd2a.ethan.sia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */


    @Test
    public void printStatistic()
    {
        BookingDB bookingList = new BookingDB();
        StudentDB studentList = new StudentDB();
        ComputerDB computerList = new ComputerDB();
        studentList.loadStudentFromFile();
        computerList.loadComputerFromFile();
        bookingList.loadBookingFromFile();
        System.out.println(bookingList.getBookingList());
        String expect = "There have "+1+" Desktop, "+0+" Laptop and  "+0+" Raspberry have been booked by today";
        assertEquals(expect,bookingList.printStatistic(computerList));
    }


}
