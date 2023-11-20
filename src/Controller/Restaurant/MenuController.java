package Controller.Restaurant;

import Controller.Interfaces.IMenuController;
import Controller.MainController;
import Domain.Restaurant.Menu;
import Domain.Restaurant.Item;
import Repository.Interfaces.IMenuRepository;
import Repository.Restaurant.MenuRepository;
import java.util.ArrayList;

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

    public void add(Menu<Item> object) {
        super.add(object);
    }

    public void delete(Menu<Item> object) {
        super.delete(object);
    }

    public void update(Menu<Item> object1, Menu<Item> object2) {
        super.update(object1, object2);
    }

    public ArrayList<Menu<Item>> getAll() {
        return super.getAll();
    }
}
