package Repository.People;

import Domain.People.Client;
import Repository.MainRepository;

public class ClientRepository extends MainRepository<Client> {
    private static ClientRepository instance;

    private ClientRepository() {
        super();
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }
}
