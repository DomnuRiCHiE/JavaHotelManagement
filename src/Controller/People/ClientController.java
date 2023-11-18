package Controller.People;

import Controller.Interfaces.IClientController;
import Controller.MainController;
import Domain.People.Client;
import Repository.Interfaces.IClientRepository;
import Repository.People.ClientRepository;

public class ClientController extends MainController<Client> implements IClientController {
    private static ClientController instance;
    private final IClientRepository clientRepositoryInterface;


    private ClientController(ClientRepository clientRepository) {
        super(clientRepository);
        clientRepositoryInterface = clientRepository;
    }

    public static ClientController getInstance() {
        if(instance == null) {
            instance = new ClientController(ClientRepository.getInstance());
        }
        return instance;
    }

    public Client searchByName(String name) {
        try {
            return clientRepositoryInterface.searchByName(name);
        }
        catch (Exception e) {
            return new Client();
        }
    }
}
