package com.ticketBooking.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Train;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrainServices {


    // Add the train into the train.json file

    private static final String TRAIN_DETAILS = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\train_details.json";


    public static void addTrainDB(Train train) throws IOException {

        File file = new File(TRAIN_DETAILS);

        ObjectMapper mapper = new ObjectMapper();

        List<Train> trainList = new ArrayList<>();

        if (file.exists() && file.length() != 0) {

            trainList = mapper.readValue(file, new TypeReference<List<Train>>() {
            });
        }

        // Check wheather the train is exists with the name or not

        for (Train trainDetails : trainList) {

            if (trainDetails.getTrainName().equalsIgnoreCase(train.getTrainName())) {
                System.out.println("Train is already Exists with this name ");
                return;
            }
        }

        trainList.add(train);

        // Save this is train details db

        mapper.writerWithDefaultPrettyPrinter().writeValue(file, trainList);

        System.out.println("Train is added");
    }


    // How to fetch the train between two stations

    // Step 1 : take the 2 stations name
//    step2 : fetch the train details from the db
//    step 3 : iterate through the of trains and check where the stations in between stops

    public static void findTrain(String from, String to) throws  IOException{

        File file = new File(TRAIN_DETAILS);

        ObjectMapper mapper = new ObjectMapper();

        List<Train> trainDetails = new ArrayList<>();

        if(file.exists() && file.length()!=0){

            trainDetails = mapper.readValue(file, new TypeReference<List<Train>>() {
            });
        }

        for(Train trains : trainDetails){

            if(trains.getIntermediateStations().contains(from) && trains.getIntermediateStations().contains(to)){

                System.out.println("Train Number : "+trains.getTrainNumber());

                System.out.println("Train Name : "+trains.getTrainName());

                return;
            }
        }

        System.out.println("No Trains found");

    }
}
