package Repository.Interfaces;
import Domain.People.Client;

public interface IClientRepository extends NameIdentifiedObjectsRepository<Client>{
    Client searchByName(String name);
}
