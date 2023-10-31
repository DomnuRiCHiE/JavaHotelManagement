package Controller.Restaurant;

public class ItemController {
    private static ItemController instance;

    public ItemController() {}

    public static ItemController getInstance() {
        if(instance == null) {
            instance = new ItemController();
        }
        return instance;
    }
}
