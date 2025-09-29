package com.ticketBooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Train;
import com.ticketBooking.Entites.Users;
import com.ticketBooking.services.TrainServices;
import com.ticketBooking.utils.UserUtils;

import java.io.File;
import java.sql.Time;
import java.util.*;

public class App {


    public static void main(String[] args) throws Exception {

        System.out.println("Welcome Book my Train App");

        TrainServices trainServices = new TrainServices();

        trainServices.findTrains("Delhi","Kanpur");

        trainServices.bookTicket(86769,"Delhi","Kanpur","charan@gmail.com");
    }
}
