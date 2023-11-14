package UI.admin;

import Domain.Hotel.Hotel;
import Domain.Restaurant.Restaurant;

public interface ManageHotelUI {
    public void assignRestaurantToHotel();

    public void manageRestaurant(); // uses ManageRestaurantUI

    public void manageRoom(); // uses ManageRoomUI

    public void getClientsInfoList();

    public void searchClientByName();

    public void addRoomToHotel();

    public void deleteRoomFromHotel();

    public void deleteClientFromHotel();

    public void modifyClientName();

    public void modifyClientPhoneNumber();

    public void modifyClientAddress();

    public void modifyClientEmail();

    public void modifyBookingInfo();

    public void searchBookingByClientName();

}
