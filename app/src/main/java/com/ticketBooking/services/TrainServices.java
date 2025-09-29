package com.ticketBooking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Train;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

public class TrainServices {

    private static final String TRAIN_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\train_details.json";

    public void addTrain(String TrainName, List<String> stops , Map<String, Time>routeMap){

        Train newTrain = new Train(TrainName,stops,routeMap);


    }


    public void findTrains(String from ,String to) throws IOException {

        File file = new File(TRAIN_DETAILS_PATH);

        List<Train> trainList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();



        if(file.exists() && file.length()!=0){

            trainList = mapper.readValue(file, new TypeReference<List<Train>>() {
            });
        }


        for(Train train :trainList){

            if(train.getStops().contains(from) && train.getStops().contains(to)){

                System.out.println("Train Name : "+train.getTrainName());
                System.out.println("Train No : "+train.getTrainName());

                return;
            }
        }

        System.out.println("No route found..");


    }
}
