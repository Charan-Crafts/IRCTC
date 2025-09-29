package com.ticketBooking;

import com.ticketBooking.Entites.Users;
import com.ticketBooking.Services.UserServices;

public  class App{

    public static void main(String[] args) throws Exception{
        System.out.println("------------IRCTC APP ------------------- ");

        Users newUser = new Users("Charan","charan@gmail.com");

        try{
            UserServices.addUser(newUser);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}