package Domain.Restaurant;

public class Beverage extends Item{
    private int volume;

    public Beverage(String name, double price, String description, int volume) {
        super(name, price, description);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + "Beverages{" +
                "volume=" + volume +
                '}';
    }

    private final static Beverage nullBeverage = new Beverage();

    public Beverage() {
        super();
        this.volume = 0;
    }

    public static Beverage getNullBeverage() {
        return nullBeverage;
    }
}