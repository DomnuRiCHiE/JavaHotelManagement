package Domain.Hotel;

import Domain.People.Client;
import Domain.Restaurant.Restaurant;

import java.util.ArrayList;

public class Hotel {

    private static Hotel instance;
    private String name;
    private Restaurant restaurant;
    private ArrayList<Bookings> bookings;
    private ArrayList<Room> rooms;
    private ArrayList<Client> clients;

    private Hotel() {
    }

    public static Hotel getInstance() {
        if (instance == null) {
            instance = new Hotel();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ArrayList<Bookings> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Bookings> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
