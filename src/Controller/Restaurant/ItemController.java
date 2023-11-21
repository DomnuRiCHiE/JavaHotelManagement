package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.Item;
import Repository.Restaurant.ItemRepository;

public class ItemController extends MainController<Item> {
    public ItemController(ItemRepository itemRepository) {
        super(itemRepository);
    }
}
