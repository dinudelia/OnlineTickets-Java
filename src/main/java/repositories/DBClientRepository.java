package repositories;

import managers.DBConnectionManager;
import managers.DBOperations;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DBClientRepository implements IClientRepository  {

    @Override
    public void addClient(Client client) {
        DBOperations.addClient(client);
    }

    @Override
    public List<Client> getClients() {
        return DBOperations.allClients();
    }
}
