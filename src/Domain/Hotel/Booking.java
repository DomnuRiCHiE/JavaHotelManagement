package Domain.Hotel;

import Domain.Payment;
import Domain.PaymentMethod;
import Domain.People.Client;
import java.util.Set;

public class Booking implements Payment {
    private String ID;
    private Client client;
    private Set<Room> bookedRooms;
    private PaymentMethod paymentMethod;

    public Booking() {}

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

    public Set<Room> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(Set<Room> bookedRooms) {
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
