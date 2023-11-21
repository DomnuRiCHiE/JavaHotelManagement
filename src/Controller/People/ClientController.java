package Controller.People;

import Controller.MainController;
import Domain.People.Client;
import Repository.People.ClientRepository;

public class ClientController extends MainController<Client> {
    public ClientController(ClientRepository clientRepository) {
        super(clientRepository);
    }

//    public Client searchByName(String name) {
//        try {
//            return clientRepositoryInterface.searchByName(name);
//        }
//        catch (Exception e) {
//            return new Client();
//        }
//    }

    public String getClientInfoList(Client client) {
        return client.toString();
    }
}
