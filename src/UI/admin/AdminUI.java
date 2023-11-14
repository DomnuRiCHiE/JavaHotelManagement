package UI.admin;

import Domain.Hotel.Hotel;
import Domain.Hotel.Room;
import Domain.Restaurant.Item;
import Domain.Restaurant.Menu;
import UI.UInterface;

public interface AdminUI extends UInterface {
    public void manageHotel(); // uses ManageHotelUI
}
