package Domain.Hotel;

public class Room {
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

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
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
}
