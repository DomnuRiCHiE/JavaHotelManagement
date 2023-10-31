package Domain.Hotel;

import Domain.Payment;
import Domain.PaymentMethod;
import Domain.People.Client;

import java.util.ArrayList;

public class Bookings implements Payment {
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

    @Override
    public double calculateTotalCost() {
        double sum = 0;
        for (Room room : this.bookedRooms){
            sum += room.getPrice();
        }
        return sum;
    }
}
