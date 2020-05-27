package service;

import model.Client;
import model.User;
import repositories.IClientRepository;

public class CreateAccountService {
    public void createAccount(Client c){
        IClientRepository clientRepository1 = IClientRepository.build(IClientRepository.Type.DB);
        IClientRepository clientRepository2 = IClientRepository.build(IClientRepository.Type.FILE);
        IClientRepository clientRepository3 = IClientRepository.build(IClientRepository.Type.ARRAY);
        clientRepository1.addClient(c);
        clientRepository2.addClient(c);
        clientRepository3.addClient(c);
    }

    public static CreateAccountService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {
        private static final CreateAccountService INSTANCE = new CreateAccountService();
    }
}
