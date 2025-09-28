package com.ticketBooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Train;
import com.ticketBooking.Entites.Users;
import com.ticketBooking.utils.UserUtils;

import java.io.File;
import java.sql.Time;
import java.util.*;

public class App {


    public static void main(String[] args) throws Exception {

        System.out.println("Welcome Book my Train App");

        Users user = new Users("Charan", "charan@gmail.com", "123");

        UserUtils.saveUser(user);


        List<String> stops = new ArrayList<>(Arrays.asList("Delhi",
                "Ghaziabad",
                "Kanpur",
                "Lucknow"));

        Map<String, Time> routeMap = Map.of(
                "Delhi", Time.valueOf("08:00:00"),
                "Ghaziabad", Time.valueOf("09:30:00"),
                "Kanpur", Time.valueOf("11:00:00"),
                "Lucknow", Time.valueOf("12:30:00")
        );

        Train newTrain = new Train("Shatabdi Express",stops,routeMap);

        UserUtils.addTrain(newTrain);
    }
}
