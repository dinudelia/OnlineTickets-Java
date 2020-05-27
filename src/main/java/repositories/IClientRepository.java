package repositories;

import model.Client;

import java.util.List;

public interface IClientRepository {

    void addClient(Client client);
    List<Client> getClients();
    static IClientRepository build(Type type) {
        switch (type) {
            case DB: return new DBClientRepository();
            case FILE: return new FileClientRepository();
            case ARRAY:return new ArrayClientRepository();
        }
        throw new RuntimeException("No such type");
    }

    enum Type {
        DB, FILE, ARRAY
    }
}
