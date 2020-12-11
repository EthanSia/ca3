package com.dkit.Sd2a.ethan.sia;

import java.util.*;

/**
 * ca3
 *
 */
public class App {
    public static void main( String[] args )
    {
      App app = new App();
      app.start();


    }

    public static void start()
    {
        StudentDB students = new StudentDB();
        students.loadStudentFromFile();
        ComputerDB computers = new ComputerDB();
        computers.loadComputerFromFile();
        BookingDB bookings = new BookingDB();
        bookings.loadBookingFromFile();
        doMainMenuLoop(students,computers,bookings);

    }

    private static void doMainMenuLoop(StudentDB students,ComputerDB computers,BookingDB booking)
    {

        Scanner kb = new Scanner(System.in);
        boolean loop = true;
        MainMenu menuOption;
        int option;
        while(loop)
        {
            printMainMenu();
            try
            {
                option = kb.nextInt();
                kb.nextLine();
                menuOption = MainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_APPLICATION:
                        loop = false;
                        break;
                    case ADD_STUDENT:
                        students.addStudent();
                        break;
                    case DELETE_STUDENT:
                        students.removeStudentById();
                        break;
                    case EDIT_STUDENT:
                        students.editStudent(students);
                        break;
                    case FIND_STUDENT:
                        students.findStudentById();
                        break;
                    case DISPLAY_STUDENT:
                        students.displayAllStudent();
                        break;
                    case ADD_BOOKING:
                         booking.addBooking(computers,students);
                        break;
                    case DELETE_BOOKING:
                        booking.removeBookById();
                        break;
                    case  PRINT_BOOKING:
                        booking.displayAllBookings();
                        break;
                    case  PRINT_BOOKING_IN_DATE_TIME:
                        booking.sortBookingByDateTime();
                        booking.displayAllBookings();
                        break;
                    case  RETURN_COMPUTER:
                        booking.returnComputer(students);
                        break;

                    case DISPLAY_AVERAGE_LENGTH_OF_ALL_BOOKING:

                        break;
                    case PRINT_STATISTIC:

                        break;
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
            }
        }
    }

    private static void printMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < MainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + MainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }


}