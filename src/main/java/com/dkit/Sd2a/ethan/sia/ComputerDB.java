package com.dkit.Sd2a.ethan.sia;

import java.util.ArrayList;

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

    public Computer findComputerType(String assetTag)
    {
        for(Computer c: computerList )
        {
            if(c.getAssetTag().equals(assetTag))
            {
                if(c!=null)

                    if(c instanceof Raspberry)

                        c.getType();


                    else if(c instanceof Laptop)
                    {
                        c.getType();
                    }
                    else if(c instanceof Desktop)
                    {
                        c.getType();
                    }


            }
        }
        return null;    // not found
    }
}
