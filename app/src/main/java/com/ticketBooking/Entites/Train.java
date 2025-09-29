package com.ticketBooking.Entites;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {

    public  Train(){}

    private int trainNumber;

    private String trainName;

    private List<String> intermediateStations;

    private String source ;

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<String> getIntermediateStations() {
        return intermediateStations;
    }

    public void setIntermediateStations(List<String> intermediateStations) {
        this.intermediateStations = intermediateStations;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Map<String, Time> getRouteMap() {
        return routeMap;
    }

    public void setRouteMap(Map<String, Time> routeMap) {
        this.routeMap = routeMap;
    }

    private String destination;

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", trainName='" + trainName + '\'' +
                ", intermediateStations=" + intermediateStations +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", routeMap=" + routeMap +
                '}';
    }

    private Map<String, Time> routeMap ;


    // Lets create the Train obj it will take train name and stops and source and destination and route map

    public Train(String trainName,String source,String destination,List<String> intermediateStations,Map<String,Time> routeMap){

        int generateUUID = (int)(Math.random()*100000);

        this.trainNumber=generateUUID;

        this.trainName=trainName;

        this.source=source;

        this.destination = destination;

        this.intermediateStations = intermediateStations;

        this.routeMap = routeMap;

    }



}
