package Controller.Restaurant;

import Controller.Interfaces.IItemController;
import Controller.MainController;
import Domain.Restaurant.Item;
import Repository.Interfaces.IItemRepository;
import Repository.Restaurant.ItemRepository;

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
}
