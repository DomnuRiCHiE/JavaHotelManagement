package Domain.Restaurant;

public class SpicyFood extends Food{
    private int spiceLevel;

    public SpicyFood(String name, double price, String description, int quantity, FoodType foodType, int spiceLevel) {
        super(name, price, description, quantity, foodType);
        this.spiceLevel = spiceLevel;
    }

    public int getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(int spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    @Override
    public String toString() {
        return "SpicyFood{" +
                "spiceLevel=" + spiceLevel +
                '}';
    }

    private final static SpicyFood nullSpicyFood = new SpicyFood();

    public SpicyFood(String name, double price, String description, int quantity, int spiceLevel) {
        super(name, price, description, quantity);
        this.spiceLevel = spiceLevel;
    }

    public SpicyFood() {
        super();
        this.spiceLevel = 0;
    }

    public static SpicyFood getNullSpicyFood() {
        return nullSpicyFood;
    }
}
