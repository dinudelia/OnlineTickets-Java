package model;

import java.util.List;

public class Order {

    private String idOrder;
    private List<Ticket> ticketsOrder;

    public Order(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public List<Ticket> getTicketsOrder() {
        return ticketsOrder;
    }

    public void setTicketsOrder(List<Ticket> ticketsOrder) {
        this.ticketsOrder = ticketsOrder;
    }
}
