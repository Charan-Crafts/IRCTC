package com.ticketBooking.Entites;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Train {

    private int trainNo;

    private String trainName;

    private List<List<Integer>> availableSeats =new ArrayList<>();

    private List<String> stops;

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<List<Integer>> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<List<Integer>> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setStops(List<String> stops) {
        this.stops = stops;
    }

    public Map<String, Time> getRouteMap() {
        return routeMap;
    }

    public void setRouteMap(Map<String, Time> routeMap) {
        this.routeMap = routeMap;
    }

    private Map<String, Time> routeMap;

    //
    public  Train(){}

    public  Train(String trainName ,List<String> stops,Map<String,Time> routeMap){

        for(int i=0;i<4;i++){
            availableSeats.add(new ArrayList<>(Arrays.asList(0,0,0,0,0)));
        }
        this.trainNo = (int)(Math.random()*100000);
        this.trainName=trainName;
        this.stops=stops;
        this.routeMap=routeMap;
    }
}
