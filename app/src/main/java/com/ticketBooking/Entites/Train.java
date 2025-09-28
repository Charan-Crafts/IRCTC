package com.ticketBooking.Entites;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {

    private String trainNo;

    private String trainName;

    private List<List<Integer>> availableSeats;

    private List<String> stops;

    private Map<String, Time> routeMap;

    public  Train(){

    }
}
