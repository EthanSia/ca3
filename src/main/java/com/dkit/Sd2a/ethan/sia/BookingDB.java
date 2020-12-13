package com.dkit.Sd2a.ethan.sia;

import java.io.*;
import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
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
                String bookDateAndTime = data[1] ;
                String returnDateAndTime = data[2];
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
        String assetTag =" ";
        String ans ="y";
        boolean checkInLoan = false;


        System.out.println("Please enter the student id");
        studentID = kb.next();
        if(sdb.searchStudentById(studentID) != null)
        {
            while(ans.equals("y"))
            {
                System.out.println("Please enter the computer assetTag");
                assetTag = kb.next();

                for(Student s : sdb.getStudentList())
                {
                    if(sdb.searchStudentByCompId(assetTag)!= null)
                    {
                        checkInLoan = true;

                    }
                }
                    if(checkInLoan == true)
                    {
                        checkInLoan = false;
                        System.out.println("This computer has been booked by somebody");
                        System.out.println("Do you want to get booking again?");
                    }
                    else
                    {
                        type.add(getComputerType(assetTag,cdb));
                        sdb.addAssetTagInLoan(studentID,assetTag);
                        tag.add(assetTag);
                        System.out.println("Do you want to add another computer tag for this booking");
                    }
                    ans = kb.next();


            }


            bookingList.add( new Book(type,studentID,tag));
        }
        else
        {
            System.out.println("This student is not exist in the system");
        }
    }

    public void editBookId ()
    {
        System.out.println("Please enter the book id you wish to find");
        String id =kb.next();

        for(Book b: bookingList)
        {
            if(b.getBookingID().equals(id))
            {
                System.out.println("Please enter the new booking id");
                String newId = kb.next();

                b.setBookingID(newId);
            }

        }

    }

    public void editBookingCheckOutDate()
    {
        System.out.println("Please enter the book id you wish to find");
        String id =kb.next();

        for(Book b: bookingList)
        {
            if(b.getBookingID().equals(id))
            {
                System.out.println("Please enter the new booking date");
                String newDate = kb.next();
                LocalDateTime newBookDate = LocalDateTime.parse(newDate);
                b.setBookDateAndTime(newBookDate);
            }

        }

    }

    public void editBookingReturnDate()
    {
        System.out.println("Please enter the book id you wish to find");
        String id =kb.next();

        for(Book b: bookingList)
        {
            if(b.getBookingID().equals(id))
            {
                System.out.println("Please enter the new booking return date");
                String newDate = kb.next();
                LocalDateTime newBookDate = LocalDateTime.parse(newDate);
                b.setReturnDateAndTime(newBookDate);
            }

        }

    }

    public void editBookingStudentId()
    {
        System.out.println("Please enter the student id you wish to find");
        String id =kb.next();

        for(Book b: bookingList)
        {
            if(b.getStudentId().equals(id))
            {
                System.out.println("Please enter the new studentId");
                String newId = kb.next();
                b.setStudentId(newId);
            }

        }

    }

    public void editBookingCompType()
    {
        System.out.println("Please enter the student id you wish to find");
        String id =kb.next();

        for(Book b: bookingList)
        {
            if(b.getStudentId().equals(id))
            {
                System.out.println("Please enter the type of computer");
                String type = kb.next();
               b.setType(type);
            }

        }

    }

    public void editBookingCompTag()
    {
        System.out.println("Please enter the student id you wish to find");
        String id =kb.next();

        for(Book b: bookingList)
        {
            if(b.getStudentId().equals(id))
            {
                System.out.println("Please enter the tag of computer");
                String tag = kb.next();
                b.setComputersTag(tag);
            }

        }

    }


    public  void editBooking(BookingDB bdb)
    {
        Scanner kb = new Scanner(System.in);
        boolean loop = true;
        EditBookingMenu editMenuOption;
        int option;
        while(loop)
        {
            try
            {
                printEditBookingMenu();
                option = kb.nextInt();
                kb.nextLine();
                editMenuOption = EditBookingMenu.values()[option];
                switch(editMenuOption)
                {
                    case QUIT_EDIT:
                        loop = false;
                        break;
                    case EDIT_ID:
                        bdb.editBookId();
                        break;
                    case  EDIT_CHECK_OUT_TIME:
                        bdb.editBookingCheckOutDate();
                        break;
                    case EDIT_RETURN_DATE:
                        bdb.editBookingReturnDate();
                        break;
                    case  EDIT_STUDENT_ID:
                        bdb.editBookingStudentId();
                        break;
                    case EDIT_TYPE:
                        bdb.editBookingCompType();
                        break;
                    case  EDIT_COMPUTER_TAG:
                        bdb.editBookingCompTag();
                        break;

                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
            }
        }
    }

    private static void printEditBookingMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < EditBookingMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + EditBookingMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
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

                for(Student s : sdb.getStudentList())
                {
                    if(s.getId().equals(studentId) && s.getComputersTag().contains(computerId))
                    {
                        s.removeTag(computerId);
                    }

                }

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


    public double displayAverageLength()
    {
        int count = 0;
        int total =0;
        for(Book b: bookingList )
        {

            if(b.getReturnDateAndTime()!=null)
            {

              total+= Integer.parseInt(String.valueOf(ChronoUnit.MINUTES.between(b.getBookDateAndTime(), b.getReturnDateAndTime())));
              count++;
            }

        }

        double average =(double)total/count;
        return average;
    }


    public String printStatistic(ComputerDB cdb)
    {
        int countDesk =0;
        int countLap =0;
        int countRasp =0;
        for(Book b: bookingList )
        {
            if(b.getComputersTag()!= null)
            {
                for(int i =0;i<b.getComputersTag().size();i++)
                {
                    Computer c = cdb.findComputerById(b.getComputersTag().get(i));
                    if(c!=null)
                    {
                        if (c instanceof Raspberry)
                        {
                            Raspberry r =(Raspberry) c;
                            countRasp++;

                        } else if (c instanceof Laptop)
                        {
                            Laptop l =(Laptop) c;
                            countLap++;

                        } else if (c instanceof Desktop)
                        {
                            Desktop d =(Desktop) c;
                            countDesk++;
                        }
                    }
                }
            }

        }
        return "There have "+countDesk+" Desktop, "+countLap+" Laptop and  "+countRasp+" Raspberry have been booked by today";
    }


}
