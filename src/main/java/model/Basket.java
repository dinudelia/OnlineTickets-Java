package model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private String idBasket;
    private List<Ticket> ticketsBasket = new ArrayList<Ticket>();
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Basket(String idBasket) {
        this.idBasket = idBasket;

    }

    public String getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(String idBasket) {
        this.idBasket = idBasket;
    }

    public List<Ticket> getTicketsBasket() {
        return ticketsBasket;
    }

    public void setTicketsBasket(List<Ticket> ticketsBasket) {
        this.ticketsBasket = ticketsBasket;
    }

    public void addTicket(Ticket t){

        ticketsBasket.add(t);
    }

    public void removeTicket(Ticket t){
        ticketsBasket.remove(t);
    }
}
