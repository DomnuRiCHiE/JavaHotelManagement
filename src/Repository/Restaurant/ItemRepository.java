package Repository.Restaurant;

import Domain.Restaurant.Item;
import Repository.Interfaces.IItemRepository;
import Repository.MainRepository;

public class ItemRepository extends MainRepository<Item> implements IItemRepository {
    private static ItemRepository instance;

    private ItemRepository() {
        super();
    }

    public static ItemRepository getInstance() {
        if(instance == null) {
            instance = new ItemRepository();
        }
        return instance;
    }
}
