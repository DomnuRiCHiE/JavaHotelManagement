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
}
