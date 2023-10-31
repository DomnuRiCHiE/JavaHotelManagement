package Domain.Restaurant;

import Domain.Payment;
import Domain.PaymentMethod;
import Domain.People.Client;
import java.util.ArrayList;
import java.util.Objects;

public class RestaurantOrder implements Payment {
    private String ID;
    private Client client;
    private ArrayList<Item> items;
    private PaymentMethod paymentMethod;

    public RestaurantOrder(String ID, Client client, ArrayList<Item> items, PaymentMethod paymentMethod) {
        this.ID = ID;
        this.client = client;
        this.items = items;
        this.paymentMethod = paymentMethod;
    }

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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantOrder that = (RestaurantOrder) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public double calculateTotalCost() {
        double totalSum = 0;

        for(Item item: this.items) {
            totalSum += item.getPrice();
        }

        return totalSum;
    }
}
