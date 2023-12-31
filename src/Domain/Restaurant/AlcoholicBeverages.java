package Domain.Restaurant;

import java.util.Objects;

public class AlcoholicBeverages extends Beverage{
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

        return super.toString() + "AlcoholicBeverages{" +
                "alcoholPercentage=" + alcoholPercentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlcoholicBeverages that = (AlcoholicBeverages) o;
        return alcoholPercentage == that.alcoholPercentage;
    }

    private final static AlcoholicBeverages nullAlcoholicBeverage = new AlcoholicBeverages();

    public AlcoholicBeverages() {
        super();
        this.alcoholPercentage = 0;
    }

    public static AlcoholicBeverages getNullAlcoholicBeverage() {
        return nullAlcoholicBeverage;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(alcoholPercentage);
//    }
}
