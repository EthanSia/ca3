package com.dkit.Sd2a.ethan.sia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ComputerDB //instanceof
{
    //ArrayList<Computer>computers;

    // constructor - ComputerDB(){computers=new ArrayList<>();}

    // method - getComputerById()
    //          addComputer(Computer c)


    private ArrayList<Computer> computerList;

    public ComputerDB()
    {
        this.computerList = new ArrayList<>();
    }

    public Computer findComputerById(String assetTag)
    {
        for(Computer c: computerList )
        {
            if(c.getAssetTag().equals(assetTag))
                return c;
        }
        return null;    // not found
    }

    public void addComputer( Computer c)
    {
        computerList.add( c );
    }

    protected void loadComputerFromFile()
    {
        try(Scanner computerFile = new Scanner(new BufferedReader(new FileReader("booking.txt"))))
        {

            String input;
            while (computerFile.hasNextLine())
            {
                input = computerFile.nextLine();
                String [] data = input.split(",");
                String bookingID = data[0];
                String bookDateAndTime = data[1];
                String returnDateAndTime = data[2];
                String type = data[3];
                String studentId = data[4];
                String assetTag = data[5];

                //Computer readInComputer =new Book(bookingID,bookDateAndTime,returnDateAndTime,type,studentId,assetTag);
                //this.computerList.add(readInBooking);


            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not load booking.If this is " +
                    "the first time running the app this might fine");
        }
    }
}
