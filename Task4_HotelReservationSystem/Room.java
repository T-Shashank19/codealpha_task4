public class Room {
    private int roomNumber;
    private String category;
    private boolean booked;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    public void cancel() {
        this.booked = false;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + category + ") - " + (booked ? "Booked" : "Available");
    }
}
