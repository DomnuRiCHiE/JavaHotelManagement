package Controller.Restaurant;

public class ItemController {
    private static ItemController instance;

    private ItemController() {}

    public static ItemController getInstance() {
        if(instance == null) {
            instance = new ItemController();
        }
        return instance;
    }
}
