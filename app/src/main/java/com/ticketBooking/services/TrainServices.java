package com.ticketBooking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Tickets;
import com.ticketBooking.Entites.Train;
import com.ticketBooking.Entites.Users;

import javax.swing.plaf.basic.BasicListUI;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

public class TrainServices {

    private static final String USER_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\users.json";

    private static final String TRAIN_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\train_details.json";

    public void addTrain(String TrainName, List<String> stops, Map<String, Time> routeMap) {

        Train newTrain = new Train(TrainName, stops, routeMap);


    }


    public void findTrains(String from, String to) throws IOException {

        File file = new File(TRAIN_DETAILS_PATH);

        List<Train> trainList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();


        if (file.exists() && file.length() != 0) {

            trainList = mapper.readValue(file, new TypeReference<List<Train>>() {
            });
        }


        for (Train train : trainList) {

            if (train.getStops().contains(from) && train.getStops().contains(to)) {

                System.out.println("Train Name : " + train.getTrainName());
                System.out.println("Train No : " + train.getTrainNo());
                return;
            }
        }

        System.out.println("No route found..");


    }

    public static Train getTrainInstance(int trainNumber) throws IOException {

        File file = new File(TRAIN_DETAILS_PATH);

        ObjectMapper mapper = new ObjectMapper();

        List<Train> trainList = new ArrayList<>();

        // Train instance

        Train trainInstance = null;

        if (file.exists() && file.length() != 0) {

            trainList = mapper.readValue(file, new TypeReference<List<Train>>() {
            });
        }
        for (Train trainDetails : trainList) {

            if (trainDetails.getTrainNo() == trainNumber) {
                trainInstance = trainDetails;
            }
        }

        return trainInstance;
    }

    public void bookTicket(int trainNumber, String from, String to, String email) throws IOException {


//        Steps  to book the train ticket : 1. Find the train instance from the train details 2 . Now create the instance of the ticket

        Train trainInstance = getTrainInstance(trainNumber);

        if (trainInstance == null) {
            System.out.println("Train not found");
            return;
        }

        // Create the ticket instance

        Tickets newTicket = new Tickets(from, to, trainInstance);

        // Now add this instance to the User booked tickets

        addTicket(email, newTicket);


    }


    public void addTicket(String userEmail, Tickets ticket) throws IOException{

        Users userInstance = UserServices.findUser(userEmail);



        // Save the ticket details in the db

        File file = new File(USER_DETAILS_PATH);

        ObjectMapper mapper = new ObjectMapper();

        List<Users> userDetails = new ArrayList<>();

        if(file.exists() && file.length()!=0){

            userDetails = mapper.readValue(file, new TypeReference<List<Users>>() {
            });
        }

        for(Users user : userDetails){
            if(user.getEmail().equalsIgnoreCase(userEmail)){
                List<Tickets> usersTicket = user.getBookedTickets();
                usersTicket.addAll(user.getBookedTickets());
                usersTicket.add(ticket);
            }
        }

        System.out.println(userDetails);

        mapper.writerWithDefaultPrettyPrinter().writeValue(file,userDetails);

        System.out.println("Ticket is added");
    }





}
