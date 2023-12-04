package Domain.Restaurant;

public class Food extends Item{
    private int quantity;
    private FoodType foodType;

    public Food(String name, double price, String description, int quantity, FoodType foodType) {
        super(name, price, description);
        this.quantity = quantity;
        this.foodType = foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "Food{" +
                "quantity=" + quantity +
                ", foodType=" + foodType +
                '}';
    }

    private final static Food nullFood = new Food();

    public Food(String name, double price, String description, int quantity) {
        super(name, price, description);
        this.quantity = quantity;
    }

    public Food() {
        super();
        this.quantity = 0;
    }

    public static Food getNullFood() {
        return nullFood;
    }
}
