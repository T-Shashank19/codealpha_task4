import java.util.*;

public class HotelReservationSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Hotel hotel = new Hotel();
            while (true) {
                System.out.println("\n===== Hotel Reservation System =====");
                System.out.println("1. Show Available Rooms");
                System.out.println("2. Book Room");
                System.out.println("3. Cancel Booking");
                System.out.println("4. Exit");
                System.out.print("Choose: ");
                String ch = sc.nextLine().trim();
                switch (ch) {
                    case "1" -> hotel.showAvailableRooms();
                    case "2" -> {
                        int bookNum = readInt(sc, "Enter room number to book: ");
                        Room r = hotel.getRoom(bookNum);
                        if (r != null && !r.isBooked()) {
                            r.book();
                            System.out.println("Room booked successfully!");
                        } else if (r != null) {
                            System.out.println("Room is already booked.");
                        } else {
                            System.out.println("Room not found."); 
                        }
                    }
                    case "3" -> {
                        int cancelNum = readInt(sc, "Enter room number to cancel: ");
                        Room rc = hotel.getRoom(cancelNum);
                        if (rc != null && rc.isBooked()) {
                            rc.cancel();
                            System.out.println("Booking cancelled!");
                        } else if (rc != null) {
                            System.out.println("Room is not currently booked."); 
                        } else {
                            System.out.println("Room not found."); 
                        }
                    }
                    case "4" -> {
                        System.out.println("Goodbye!"); 
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String ln = sc.nextLine().trim();
            try {
                return Integer.parseInt(ln);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
