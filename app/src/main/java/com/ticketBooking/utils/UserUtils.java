package com.ticketBooking.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketBooking.Entites.Users;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.IOException;

public class UserUtils {

    private static final String USER_DETAILS_PATH = "./LocalDB/users.json";

    public static String generatehashPassword(String originPassword){

        String hashPassword = BCrypt.hashpw(originPassword,BCrypt.gensalt(5));


        return hashPassword;
    }


    public static boolean comparePassword(Users user,String password){



        boolean isMatch = BCrypt.checkpw(password,user.getHashedPassword());

        return isMatch;

    }

    public static void saveUser(Users user ) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String getCurrentDir = System.getProperty("user.dir");

        System.out.println(getCurrentDir);

        File file = new File(USER_DETAILS_PATH);

        objectMapper.writeValue(file,user);

        System.out.println("Details stored in the DB");
    }


}
