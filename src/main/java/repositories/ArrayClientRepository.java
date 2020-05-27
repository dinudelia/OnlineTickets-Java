package repositories;

import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ArrayClientRepository implements IClientRepository {

    List<Client> clientsList = new ArrayList<Client>();

    @Override
    public void addClient(Client client) {
        clientsList.add(client);
    }

    @Override
    public List<Client> getClients() {
        return clientsList;
    }

}
