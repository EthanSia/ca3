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

//
//    public static void main(String[] args)
//    {
//        Desktop d1 = new Desktop("Desktop","Asus","intel i9","8GB","1TB","3.5kg","D123456","2011-11-20","1 monitor");
//        Laptop l1 = new Laptop("Laptop","Asus","intel i9","8GB","1TB","3.5kg","D123457","2011-11-21","12.5 inches","35 hours");
//        Raspberry r1 = new Raspberry("Raspberry","Raspberry PI","Model 4B","4GB","1TB","3.5kg","D123458","2011-11-21",15789,"32GB");
//
//
//        ComputerDB computers = new ComputerDB();
//        computers.addComputer(d1);
//        computers.addComputer(l1);
//        computers.addComputer(r1);
//
//
//
//        StudentDB studentList = new StudentDB();
//        Student s1 = new Student("Anne","D00225147","email@dkit.ie","0834879854");
//        Student s2 =new Student("Anna","D00225879","D00225879@student.txt.dkit.ie","0874589856");
//        studentList.loadStudentFromFile();
//
//        BookingDB bookingList = new BookingDB();
//        bookingList.addBooking(computers,studentList);
//        studentList.displayAllStudent();
//        System.out.println(bookingList.findBookById("D00225147"));
//        bookingList.returnComputer(studentList);
//        studentList.displayAllStudent();
////        System.out.println(s1);
////          StudentDB.sortStudentById();
////          Student.displayStudent();
//    }

//    public static void main(String[] args) {
//        System.out.println("Test #1 : General case to remove number 22");
//        int[] input = {42, 322, 22, 11, 22, 33, 16};
//        System.out.println("input : " + Arrays.toString(input) + ", remove 22");
//        int[] output = remove(input,22) ; // removes number 22 from array
//        System.out.println("output : " + Arrays.toString(output));
//
//
//    }
//    public static int[] remove(int[] numbers, int target)
//    {
//        int count = 0;
//        // loop over array to count number of target values.
//        // this required to calculate length of new array
//        for (int number : numbers)
//        {
//            if (number == target)
//            {
//                count++;
//            }
//        }
//        if (count == 0)
//        {
//            return numbers;
//        }
//
//        int[] result = new int[numbers.length - count];
//        int index = 0;
//        for (int value : numbers)
//        {
//            if (value != target)
//            {
//                result[index] = value; index++;
//            }
//        }
//        numbers = null;
//        // make original array eligible for GC
//        return result;
//
//
//    }
}