package com.ticketBooking.Entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tickets {

    private int ticketId;

    private String source ;

    private String destination;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Train> getTrainDetails() {
        return trainDetails;
    }

    public void setTrainDetails(List<Train> trainDetails) {
        this.trainDetails = trainDetails;
    }

    private List<Train> trainDetails = new ArrayList<>();

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", trainDetails=" + trainDetails +
                '}';
    }

    public Tickets(String source,String destination,Train train){

        // generate the ticket id

        int UUID = (int)(Math.random()*10000);

        this.ticketId = UUID;

        this.source = source;

        this.destination = destination;

        this.date=new Date();

        this.trainDetails.add(train);
    }


}
