package repositories;

import files.LoadFiles;
import files.SaveFiles;
import model.Client;

import java.util.List;

public class FileClientRepository implements IClientRepository {

    private final String file = "ClientS";

    @Override
    public void addClient(Client client) {
        SaveFiles saveFiles = new SaveFiles();
        saveFiles.saveClient(client);
        saveFiles.saveUser(client);
    }

    @Override
    public List<Client> getClients() {
        LoadFiles loadFiles = new LoadFiles();
        return loadFiles.loadClients();
    }
}
