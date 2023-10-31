package Domain.Restaurant;

public class Beverages extends Item{
    private int volume;

    public Beverages(String name, double price, String description, int volume) {
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
        return "Beverages{" +
                "volume=" + volume +
                '}';
    }
}
