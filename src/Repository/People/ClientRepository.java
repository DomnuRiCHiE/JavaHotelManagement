package Repository.People;

import Domain.People.Client;
import Repository.Interfaces.IClientRepository;
import Repository.MainRepository;

import java.util.Objects;

public class ClientRepository extends MainRepository<Client> implements IClientRepository {
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

    @Override
    public Boolean nameInRepo(String name) {
        for(Client client: arrayList) {
            if(name.equals(client.getName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Client searchByName(String name) {
        for (Client client: arrayList) {
            if(Objects.equals(name, client.getName()))
                return client.copy();
        }
        return null;
    }
}
