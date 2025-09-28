package com.ticketBooking.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Train;
import com.ticketBooking.Entites.Users;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.IOException;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    private static final String USER_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\users.json";

    private static final String TRAIN_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\train_details.json";

    public static String generatehashPassword(String originPassword) {

        String hashPassword = BCrypt.hashpw(originPassword, BCrypt.gensalt(5));


        return hashPassword;
    }


    public static boolean comparePassword(Users user, String password) {

        boolean isMatch = BCrypt.checkpw(password, user.getHashedPassword());

        return isMatch;

    }

    public static void saveUser(Users user) throws IOException {

        List<Users> userList = new ArrayList<>();

        //Create the file object

        File file = new File(USER_DETAILS_PATH);

        //Creating the ObjectMapper instance

        ObjectMapper mapper = new ObjectMapper();

        //check wheather the file is empty or not

        if (file.exists() && file.length() != 0) {

            //Add the existing users into the userList

            userList = mapper.readValue(file, new TypeReference<List<Users>>() {
            });
        }

        //Check the user is already exists are not

        boolean isExists = userList.stream().anyMatch(e -> e.getEmail().equalsIgnoreCase(user.getEmail()));

        if (isExists) {
            System.out.println("User is already Exists with this Email");
            return;
        }
        //Now add the current user into the list

        userList.add(user);

        //Now add the list into the users.json

        mapper.writerWithDefaultPrettyPrinter().writeValue(file, userList);

        System.out.println("User is added into the DB !");

    }


    public static void addTrain(Train train) throws IOException {

        File file = new File(TRAIN_DETAILS_PATH);

        ObjectMapper mapper = new ObjectMapper();

        List<Train> trainList = new ArrayList<>();

        try {
            if (file.exists() && file.length() != 0) {

                trainList = mapper.readValue(file, new TypeReference<List<Train>>() {
                });

            }

            //Check wheather the train exists with the name

            boolean isExists = trainList.stream().anyMatch(e -> e.getTrainName().equalsIgnoreCase(train.getTrainName()));

            if (isExists) {
                System.out.println("Train is already exists in the Sheat");
                return;
            }

            trainList.add(train);

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, trainList);

            System.out.println("Train is added to the sheat .. !");
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
