package Domain.Hotel;

import Controller.Observer.Subjects.SubjectRoomOccupancy;

public class Room extends SubjectRoomOccupancy {
    private int roomNumber;
    private RoomCategories roomType;
    private int numberOfBeds;
    private boolean occupied;
    private int price;

    public Room(int roomNumber, RoomCategories roomType, int numberOfBeds, int price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomCategories getRoomType() {
        return roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getPrice() {
        return price;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
        notifyObservers(this);
    }

    public void notifyObservers(Room room) {
        super.notifyObservers(room);
    }
}
