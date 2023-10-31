package Domain.Hotel;

import Domain.PaymentMethod;
import Domain.People.Client;

import java.util.ArrayList;

public class Bookings {
    private String ID;
    private Client client;
    private ArrayList<Room> bookedRooms;
    private PaymentMethod paymentMethod;

    public Bookings() {}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Room> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(ArrayList<Room> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
