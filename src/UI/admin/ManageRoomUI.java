package UI.admin;

import Domain.Hotel.Hotel;
import Domain.Hotel.Room;
import Domain.Hotel.RoomCategories;

public interface ManageRoomUI {
    public void changeRoomType();
    public void getRoomInfo();
    public void changeOccupancyStatus();
    public void changePrice();
}
