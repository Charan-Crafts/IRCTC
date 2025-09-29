package com.ticketBooking;

import com.ticketBooking.Entites.Tickets;
import com.ticketBooking.Entites.Train;
import com.ticketBooking.Entites.Users;
import com.ticketBooking.Services.TrainServices;
import com.ticketBooking.Services.UserServices;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public  class App{

    public static void main(String[] args) throws Exception{
        System.out.println("------------IRCTC APP ------------------- ");

        Scanner scanner = new Scanner(System.in);

        int userChoice = 0 ;

//        while(userChoice!=7){
//            System.out.println("Press 1 for the Login and Signup ");
//            System.out.println("Press 2 for Fetch the Trains details");
//            System.out.println("Press 3 book ticket ");
//            System.out.println("Press 7 for Exit");
//
//            userChoice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (userChoice){
//
//                case 1 :
//                    System.out.println("Enter the User Name : ");
//                    String userName = scanner.nextLine();
//                    System.out.println("Enter the Email : ");
//                    String email = scanner.nextLine();
//                    try{
//                        Users newUser = new Users(userName,email);
//                        UserServices.addUser(newUser);
////                        System.out.println("");
//                    }catch (Exception e){
//                        System.out.println(e);
//                    }
//                    break;
//                case 2 :
//                    System.out.println("Enter the source : ");
//
//                    String source = scanner.nextLine();
//
//                    System.out.println("Enter the destination : ");
//
//                    String destination = scanner.nextLine();
//
//                    TrainServices.findTrain(source,destination);
//
//                    break;
//                case 7 :
//                    return;
//
//
//            }
//
//        }

        UserServices.bookTicket("Guntakal","KSR",84086,"charan@gmail.com");



//        System.out.println(newTicket);
    }
}