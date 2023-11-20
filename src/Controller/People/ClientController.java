package Controller.People;

import Controller.Interfaces.IClientController;
import Controller.MainController;
import Domain.People.Client;
import Repository.Interfaces.IClientRepository;
import Repository.People.ClientRepository;
import java.util.ArrayList;

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

    public void add(Client object) {
        super.add(object);
    }

    public void delete(Client object) {
        super.delete(object);
    }

    public void update(Client object1, Client object2) {
        super.update(object1, object2);
    }

    public ArrayList<Client> getAll() {
        return super.getAll();
    }

    public Client searchByName(String name) {
        try {
            return clientRepositoryInterface.searchByName(name);
        }
        catch (Exception e) {
            return new Client();
        }
    }

    public String getClientInfoList(Client client) {
        return client.toString();
    }
}
