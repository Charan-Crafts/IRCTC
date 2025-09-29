package com.ticketBooking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {

    private static final String USER_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\users.json";

    private static final String TRAIN_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\train_details.json";

    public static  Users findUser(String email) throws IOException {

        Users userInstance = null;

        File file = new File(USER_DETAILS_PATH);

        ObjectMapper mapper = new ObjectMapper();

        List<Users> userList = new ArrayList<>();

        if(file.exists() && file.length()!=0){

            userList=mapper.readValue(file, new TypeReference<List<Users>>() {
            });
        }

        for(Users user: userList){

            if(user.getEmail().equalsIgnoreCase(email)){
                userInstance=user;
                return userInstance;
            }
        }

        return userInstance;
    }
}
