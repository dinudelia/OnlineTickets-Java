package model;

import java.util.ArrayList;
import java.util.List;

public class Client extends User{

    private List<Order> orders= new ArrayList<Order>();
    private int seniority;

    public Client(Integer idUser,String username, String password, String firstName, String lastName, int seniority) {
        super(idUser, username, password, firstName, lastName);
        this.seniority = seniority;
    }
    public int getSeniority(){
        return seniority;
    }
    public void setSeniority(int seniority){
        this.seniority = seniority;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
