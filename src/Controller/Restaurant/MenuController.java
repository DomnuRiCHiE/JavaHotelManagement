package Controller.Restaurant;

import Controller.IController;
import Domain.Restaurant.Menu;
import Repository.Restaurant.MenuRepository;
import Domain.Restaurant.Item;
import java.util.ArrayList;

public class MenuController implements IController<Item> {
    private final MenuRepository<Item> menuRepository;
    private static MenuController instance;

    public MenuController(MenuRepository<Item> menuRepository) {
        this.menuRepository = menuRepository;
    }

    public static MenuController getInstance(MenuRepository<Item> menuRepository) {
        if(instance == null) {
            instance = new MenuController(menuRepository);
        }
        return instance;
    }

    @Override
    public void add(Item object) {
        menuRepository.add(object);
    }

    @Override
    public void update(Item object1, Item object2) {
        menuRepository.update(object1, object2);
    }

    @Override
    public void delete(Item object) {
        menuRepository.delete(object);
    }

    @Override
    public ArrayList<Item> getAll() {
        return menuRepository.getAll();
    }
}
