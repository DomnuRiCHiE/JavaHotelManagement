package Repository.Interfaces;

public interface NameIdentifiedObjectsRepository<Object> {
    Boolean nameInRepo(String name);
    Object searchByName(String name);
}
