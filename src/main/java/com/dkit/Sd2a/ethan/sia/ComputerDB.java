package com.dkit.Sd2a.ethan.sia;

import java.io.*;
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

    public  void displayComputer ()
    {
         for(Computer c :computerList)
         {
             System.out.println(c.toString());
         }
    }

    protected void loadComputerFromFile()
    {
        try(Scanner computerFile = new Scanner(new BufferedReader(new FileReader("computer.txt"))))
        {

            String input;
            while (computerFile.hasNextLine())
            {
                input = computerFile.nextLine();
                String [] data = input.split(",");
                String type = data[0];
                String manufacturer  = data[1];
                String processes = data[2];
                String ramSize = data[3];
                String diskSize = data[4];
                String weight= data[5];
                String assetTag = data[6];
                String purchaseDate = data[7];


                if(data[0].equals("Raspberry"))
                {
                    int GPIOPins = Integer.parseInt(data[8]);
                    String sdCard = data[data.length-1];

                   Computer readInComputer =new Raspberry(type,manufacturer,processes,ramSize,diskSize,weight,assetTag,purchaseDate,GPIOPins,sdCard);
                   this.computerList.add(readInComputer);
                }


                else if(data[0].equals("Desktop"))
                {
                    String monitor= data[8];

                    Computer readInComputer =new Desktop(type,manufacturer,processes,ramSize,diskSize,weight,assetTag,purchaseDate,monitor);
                    this.computerList.add(readInComputer);
                }

                else
                {
                    String screenSizeInches= data[8];
                    String batteryLife = data[data.length-1];

                    Computer readInComputer =new Laptop(type,manufacturer,processes,ramSize,diskSize,weight,assetTag,purchaseDate,screenSizeInches,batteryLife);
                    this.computerList.add(readInComputer);
                }




            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not load booking.If this is " +
                    "the first time running the app this might fine");
        }
    }




}
