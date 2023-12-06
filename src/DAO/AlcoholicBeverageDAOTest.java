package DAO;

import Domain.Restaurant.AlcoholicBeverages;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

class AlcoholicBeverageDAOTest {

    @Test
    void addEntity() throws Exception {
        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/hotel", "root", "vulpea25");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        Connection connection = DatabaseConnection.getConnection();
        try{
            String createTable = "CREATE TABLE AlcoholicBeverages (ID int IDENTITY(1,1))";
            PreparedStatement createTableStatement = connection.prepareStatement(createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        AlcoholicBeverages alcoholicBeverages1 = new AlcoholicBeverages("bere Heineken", 12,"bere blonda",1000, 5);
        AlcoholicBeverages alcoholicBeverages2 = new AlcoholicBeverages("bere Carlsberg", 13,"bere blonda",1000, 4);
        AlcoholicBeverages alcoholicBeverages3 = new AlcoholicBeverages("bere Paulaner", 15,"bere blonda",1000, 6);
        AlcoholicBeverageDAO testRepo = AlcoholicBeverageDAO.getInstance();
        testRepo.addEntityDAO(alcoholicBeverages1);
        testRepo.addEntityDAO(alcoholicBeverages2);
        testRepo.addEntityDAO(alcoholicBeverages3);

        ArrayList<AlcoholicBeverages> results = testRepo.getAllEntitiesDAO();
        assert (results.size() == 3);
    }

    @Test
    void updateEntity() throws Exception {

        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/hotel", "root", "vulpea25");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        AlcoholicBeverages alcoholicBeverages1 = new AlcoholicBeverages("bere Heineken", 12,"bere blonda",1000, 6);
        AlcoholicBeverageDAO testRepo = AlcoholicBeverageDAO.getInstance();
        testRepo.updateEntityDAO(alcoholicBeverages1);

        ArrayList<AlcoholicBeverages> results = testRepo.getAllEntitiesDAO();
        for (AlcoholicBeverages a : results){
            if (a.equals(alcoholicBeverages1)){
                return;
            }
        }
        throw new Exception();
    }

    @Test
    void deleteEntity() throws Exception {
        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/hotel", "root", "vulpea25");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        AlcoholicBeverages alcoholicBeverages1 = new AlcoholicBeverages("bere Carlsberg", 12,"bere blonda",1000, 4);
        AlcoholicBeverageDAO testRepo = AlcoholicBeverageDAO.getInstance();
        testRepo.deleteEntityDAO(alcoholicBeverages1);

        ArrayList<AlcoholicBeverages> results = testRepo.getAllEntitiesDAO();
        assert (results.size() == 2);
    }

    @Test
    void getAllEntities() {
        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/hotel", "root", "vulpea25");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        AlcoholicBeverageDAO testRepo = AlcoholicBeverageDAO.getInstance();
        ArrayList<AlcoholicBeverages> results = testRepo.getAllEntitiesDAO();
        assert (results.size() == 2);
    }
}