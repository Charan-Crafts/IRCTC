package com.ticketBooking.Entites;

import com.google.common.base.Ticker;
import com.ticketBooking.utils.UserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Users {

    private String userName;

    private String  userId;

    private String password;

    private String hashedPassword;

    private List<Tickets> bookedTickets;

    private String userEmail;

    public Users(){}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Tickets> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Tickets> bookedTicket) {
        this.bookedTickets=bookedTicket;
    }

    public String getEmail(){
        return this.userEmail;
    }

    public void setEmail(String email){
        this.userEmail = email;
    }

    public Users(String userName, String userEmail,String password){
        this.userName = userName;
        UUID uuid = UUID.randomUUID();
        this.userEmail=userEmail;
        this.userId = uuid.toString().replace("-","");
        this.hashedPassword= UserUtils.generatehashPassword(password);
        this.password=password;
        this.bookedTickets =new ArrayList<>();
    }

    public void displayUser(){
        System.out.println("User ID :"+getUserId());
        System.out.println("User Name :"+getUserName());
        System.out.println("Password :"+getPassword());
        System.out.println("HashedPassword :"+getHashedPassword());
        System.out.println("Tickets Booked :"+getBookedTickets());
    }


}
