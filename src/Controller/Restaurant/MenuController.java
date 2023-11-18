package Controller.Restaurant;

import Controller.Interfaces.IMenuController;
import Controller.MainController;
import Domain.Restaurant.Menu;
import Domain.Restaurant.Item;
import Repository.Restaurant.MenuRepository;

public class MenuController extends MainController<Menu<Item>> implements IMenuController {
    private static MenuController instance;

    private MenuController() {
        super(MenuRepository.getInstance());
    }

    public static MenuController getInstance() {
        if(instance == null) {
            instance = new MenuController();
        }
        return instance;
    }
}
