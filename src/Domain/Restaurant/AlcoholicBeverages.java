package Domain.Restaurant;

public class AlcoholicBeverages extends Beverages{
    private int alcoholPercentage;

    public AlcoholicBeverages(String name, double price, String description, int volume, int alcoholPercentage) {
        super(name, price, description, volume);
        this.alcoholPercentage = alcoholPercentage;
    }

    public int getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(int alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public String toString() {
        return "AlcoholicBeverages{" +
                "alcoholPercentage=" + alcoholPercentage +
                '}';
    }
}
