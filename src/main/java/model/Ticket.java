package model;

public class Ticket {

    private Integer idTicket;
    private static int nrTickets;

    static
    {
        nrTickets = 0;
    }

    public static int getNrTickets() {
        return nrTickets;
    }

    public static void setNrTickets(int nrTickets) {
        Ticket.nrTickets = nrTickets;
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
        nrTickets++;
    }
}
