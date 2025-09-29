package com.ticketBooking.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Users;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {

    private static  final String USER_DETAILS_PATH = "D:\\Java Boot Camp\\IRCTC\\app\\src\\main\\java\\com\\ticketBooking\\LocalDB\\user_details.json";

//    Steps to add the user into the json JFileChooser
//    1. create the file instance
//    2.create the object mapper instance
//    3.get all the user details in the list
//    4.now add the new user into the list
//    5.now store the update list into the file

//    We required user Instance

    public static void addUser(Users user) throws IOException {

        File file = new File(USER_DETAILS_PATH);

        ObjectMapper mapper = new ObjectMapper();

        // Create a list that will store all the user details from the json file

        List<Users> userList = new ArrayList<>();


        //File is exists and file is having some content

        if(file.exists() && file.length()!=0){

            // Now store that particular content into the user List
            userList = mapper.readValue(file, new TypeReference<List<Users>>() {
            });

        }

        // Now add the current user into the List

        //Check wheather the user is already exists with the email or not if exists say user is already created

        for(Users userDetails : userList){
            if(userDetails.getUserEmail().equalsIgnoreCase(user.getUserEmail())){
                System.out.println("User is already Exists");
                return;
            }
        }
        userList.add(user);

        // Now store in the Json file

        mapper.writerWithDefaultPrettyPrinter().writeValue(file,userList);

        System.out.println("User is added into the DB");
        return;

    }

}
