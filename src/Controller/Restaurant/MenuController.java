package Controller.Restaurant;

import Controller.MainController;
import Domain.Restaurant.Menu;
import Domain.Restaurant.Item;
import Repository.Restaurant.MenuRepository;

public class MenuController extends MainController<Menu<Item>> {
    public MenuController(MenuRepository<Item> menuRepository) {
        super(menuRepository);
    }
}
