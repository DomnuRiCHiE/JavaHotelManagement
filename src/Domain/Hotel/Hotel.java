package Domain.Hotel;

import Domain.People.Client;
import Domain.Restaurant.Restaurant;

import java.util.ArrayList;

public class Hotel {

    private static Hotel instance;
    private String name;
    private Restaurant restaurant;
    private ArrayList<Booking> booking;
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

    public ArrayList<Booking> getBookings() {
        return booking;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.booking = booking;
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
