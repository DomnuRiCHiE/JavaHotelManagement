package Controller.Restaurant;

import Controller.Interfaces.IItemController;
import Controller.MainController;
import Domain.Restaurant.Item;
import Repository.Restaurant.ItemRepository;

public class ItemController extends MainController<Item> implements IItemController {
    private static ItemController instance;

    private ItemController() {
        super(ItemRepository.getInstance());
    }

    public static ItemController getInstance() {
        if(instance == null) {
            instance = new ItemController();
        }
        return instance;
    }
}
