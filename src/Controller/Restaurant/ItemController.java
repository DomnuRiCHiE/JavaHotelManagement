package Controller.Restaurant;

import Controller.Interfaces.IItemController;
import Controller.MainController;
import Domain.Restaurant.Item;
import Repository.Interfaces.IItemRepository;
import Repository.Restaurant.ItemRepository;
import java.util.ArrayList;

public class ItemController extends MainController<Item> implements IItemController {
    private static ItemController instance;
    private final IItemRepository itemRepositoryInterface;

    private ItemController(ItemRepository itemRepository) {
        super(itemRepository);
        itemRepositoryInterface = itemRepository;
    }

    public static ItemController getInstance() {
        if(instance == null) {
            instance = new ItemController(ItemRepository.getInstance());
        }
        return instance;
    }

    public void add(Item object) {
        super.add(object);
    }

    public void delete(Item object) {
        super.delete(object);
    }

    public void update(Item object1, Item object2) {
        super.update(object1, object2);
    }

    public ArrayList<Item> getAll() {
        return super.getAll();
    }
}
