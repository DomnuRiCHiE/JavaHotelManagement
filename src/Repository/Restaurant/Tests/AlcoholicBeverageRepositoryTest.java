package Repository.Restaurant.Tests;

import Domain.Restaurant.AlcoholicBeverages;
import Repository.Restaurant.AlcoholicBeverageRepository;
import org.opentest4j.AssertionFailedError;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AlcoholicBeverageRepositoryTest {

    private AlcoholicBeverageRepository alcoholicBeverageRepository;

    public AlcoholicBeverageRepositoryTest() {
        alcoholicBeverageRepository = AlcoholicBeverageRepository.getInstance();
    }

    @org.junit.jupiter.api.Test
    void getInstance() {
        AlcoholicBeverageRepository alcoholicBeverageRepository2 = AlcoholicBeverageRepository.getInstance();
        assertTrue(alcoholicBeverageRepository2 == alcoholicBeverageRepository );
    }

    @org.junit.jupiter.api.Test
    void add() {
        AlcoholicBeverages alcoholicBeverage1 = new AlcoholicBeverages("Kronenburg blanc", 10, "Refreshing beer", 330, 5);
        AlcoholicBeverages alcoholicBeverage2 = new AlcoholicBeverages("Kronenburg blanc", 10, "Refreshing beer", 330, 5);
        alcoholicBeverageRepository.add(alcoholicBeverage1);
        alcoholicBeverageRepository.add(alcoholicBeverage2);

        assertEquals(2, alcoholicBeverageRepository.length());
        alcoholicBeverageRepository.delete(alcoholicBeverage1);
        alcoholicBeverageRepository.delete(alcoholicBeverage2);
    }

    @org.junit.jupiter.api.Test
    void update() {

        AlcoholicBeverages alcoholicBeverage1 = new AlcoholicBeverages("Kronenburg blanc", 10, "Refreshing beer", 330, 5);
        AlcoholicBeverages alcoholicBeverage2 = new AlcoholicBeverages("Guiness", 13, "Refreshing beer", 500, 7);
        AlcoholicBeverages alcoholicBeverage3 = new AlcoholicBeverages("Glennfiddich", 15, "12 year aged scotch", 100, 35);
        AlcoholicBeverages alcoholicBeverage4 = new AlcoholicBeverages("Glennfiddich", 15, "12 year aged scotch", 100, 35);

        alcoholicBeverageRepository.add(alcoholicBeverage1);
        alcoholicBeverageRepository.add(alcoholicBeverage2);
        alcoholicBeverageRepository.add(alcoholicBeverage3);

        ArrayList<AlcoholicBeverages> array = alcoholicBeverageRepository.getAll();

        alcoholicBeverageRepository.update(alcoholicBeverage1, alcoholicBeverage3);
        assertEquals(array.getLast(), alcoholicBeverage4);
        alcoholicBeverageRepository.delete(alcoholicBeverage1);
        alcoholicBeverageRepository.delete(alcoholicBeverage2);
        alcoholicBeverageRepository.delete(alcoholicBeverage3);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        AlcoholicBeverages alcoholicBeverage1 = new AlcoholicBeverages("Kronenburg blanc", 10, "Refreshing beer", 330, 5);
        AlcoholicBeverages alcoholicBeverage2 = new AlcoholicBeverages("Guiness", 13, "Refreshing beer", 500, 7);
        alcoholicBeverageRepository.add(alcoholicBeverage1);
        alcoholicBeverageRepository.add(alcoholicBeverage2);
        alcoholicBeverageRepository.delete(alcoholicBeverage1);

        assertEquals(1, alcoholicBeverageRepository.length());
        alcoholicBeverageRepository.delete(alcoholicBeverage2);
    }

    @org.junit.jupiter.api.Test
    void getAll() {

        AlcoholicBeverages alcoholicBeverage1 = new AlcoholicBeverages("Kronenburg blanc", 10, "Refreshing beer", 330, 5);
        AlcoholicBeverages alcoholicBeverage2 = new AlcoholicBeverages("Guiness", 13, "Refreshing beer", 500, 7);
        AlcoholicBeverages alcoholicBeverage3 = new AlcoholicBeverages("Glennfiddich", 15, "12 year aged scotch", 100, 35);

        alcoholicBeverageRepository.add(alcoholicBeverage1);
        alcoholicBeverageRepository.add(alcoholicBeverage2);
        alcoholicBeverageRepository.add(alcoholicBeverage3);

        ArrayList<AlcoholicBeverages> array = new ArrayList<>();
        array.add(alcoholicBeverage1);
        array.add(alcoholicBeverage2);
        array.add(alcoholicBeverage3);

        ArrayList<AlcoholicBeverages> array2 = alcoholicBeverageRepository.getAll();


        assertEquals(array, array2);
    }
}