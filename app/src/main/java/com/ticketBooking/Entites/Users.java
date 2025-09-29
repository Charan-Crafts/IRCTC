package com.ticketBooking.Entites;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {

    public  Users(){}
    private String userName;

    private String userId;

    private String userEmail;

    private List<Tickets> myTickets;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Tickets> getMyTickets() {
        return myTickets;
    }

    public void setMyTickets(List<Tickets> myTickets) {
        this.myTickets = myTickets;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", myTickets=" + myTickets +
                '}';
    }


    //Creating the user

//    Steps 1 : provide the user basic details like User name ,email

    public Users(String userName,String userEmail){


        //Lets generate the UUID for the users

        String UUID = java.util.UUID.randomUUID().toString().replace("-","");

        this.userId = UUID;

        this.userName = userName;

        this.userEmail = userEmail;

        this.myTickets = new ArrayList<>();


    }
}
