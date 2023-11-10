package Controller.People;

import Controller.MainController;
import Domain.People.Client;
import Repository.People.ClientRepository;

public class ClientController extends MainController<Client> {
    private static ClientController instance;

    private ClientController() {
        super(ClientRepository.getInstance());
    }

    public static ClientController getInstance() {
        if(instance == null) {
            instance = new ClientController();
        }
        return instance;
    }
}
