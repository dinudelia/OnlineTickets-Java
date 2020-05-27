package model;

import java.util.List;

public class Event {

    private int idEvent;
    private String nameEvent;
    private int nrTickets;
    private int price;
    Location location;
    private List<Ticket> ticketsEvent;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Event(int idEvent, String nameEvent, int nrTickets, int price, Location location) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
        this.nrTickets = nrTickets;
        this.price = price;
        this.location = location;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public int getNrTickets() {
        return nrTickets;
    }

    public void setNrTickets(int nrTickets) {
        this.nrTickets = nrTickets;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Ticket> getTicketsEvent() {
        return ticketsEvent;
    }

    public void setTicketsEvent(List<Ticket> ticketsEvent) {
        this.ticketsEvent = ticketsEvent;
    }

  }
