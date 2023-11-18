package Controller.Restaurant;

import Controller.Interfaces.IMenuController;
import Controller.MainController;
import Domain.Restaurant.Menu;
import Domain.Restaurant.Item;
import Repository.Interfaces.IMenuRepository;
import Repository.Restaurant.MenuRepository;

public class MenuController extends MainController<Menu<Item>> implements IMenuController {
    private static MenuController instance;
    private final IMenuRepository menuRepositoryInterface;

    private MenuController(MenuRepository<Item> menuRepository) {
        super(menuRepository);
        menuRepositoryInterface = menuRepository;
    }

    public static MenuController getInstance() {
        if(instance == null) {
            instance = new MenuController(MenuRepository.getInstance());
        }
        return instance;
    }
}
