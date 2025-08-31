import java.util.*;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
        // create some rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Standard"));
        rooms.add(new Room(201, "Suite"));
    }

    public void showAvailableRooms() {
        boolean any = false;
        for (Room r : rooms) {
            if (!r.isBooked()) {
                System.out.println(r.toString());
                any = true;
            }
        }
        if (!any) System.out.println("No rooms available.");
    }

    public Room getRoom(int number) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == number) return r;
        }
        return null;
    }
}
