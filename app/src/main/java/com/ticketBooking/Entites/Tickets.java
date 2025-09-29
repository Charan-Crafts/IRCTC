package com.ticketBooking.Entites;

import java.util.Date;

public class Tickets {

    private int ticketId;

    private String source;

    private String destination;

    private Train trainDetails;

    private Date date;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public Train getTrainDetails() {
        return trainDetails;
    }

    public void setTrainDetails(Train trainDetails) {
        this.trainDetails = trainDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tickets(){

    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", trainDetails=" + trainDetails +
                ", date=" + date +
                '}';
    }

    public Tickets(String source , String destination, Train train){
        int UUID = (int)(Math.random()*10000);
        this.ticketId = UUID;
        this.source=source;
        this.destination=destination;
        this.trainDetails=train;
    }

}
