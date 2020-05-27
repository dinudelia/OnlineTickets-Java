package service;

import model.*;
import repositories.IClientRepository;

import java.util.List;

public class LoginService {

    private LoginService() {
    }

    public Client login(String userName,String userPassword){
        IClientRepository clientRepository = IClientRepository.build(IClientRepository.Type.FILE);
        List<Client> clients = clientRepository.getClients();
        for (Client c:clients){
            if (c.getUsername().equals(userName) &&
                    c.getPassword().equals(userPassword)){
                return c;
            }
        }
        return null;
    }

    public static LoginService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {
        private static final LoginService INSTANCE = new LoginService();
    }
}

