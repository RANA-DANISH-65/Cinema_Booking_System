import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema_1 = new Cinema(4, "Bollywood Hub");
        displayMenu(cinema_1);
    }

    public static void displayMenu(Cinema cinema) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menu ===");
            System.out.println("1. Get Screen Details");
            System.out.println("2. Change Movie Name");
            System.out.println("3. Book Seat");
            System.out.println("4. Cancel Seat Booking");
            System.out.println("5. View Booked Seats");
            System.out.println("6. View Total Booked Seats");
            System.out.println("7. View Available Seats");
            System.out.println("8. View Total Available Seats");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Screen details are as follows:");
                    for (Screen screen : cinema.getScreens()) {
                        System.out.println("Screen ID: " + screen.getScreenId() + ", Movie: " + screen.getMovie());
                    }
                    break;
                case 2:
                    cinema.changeMovieName();
                    break;
                case 3:
                    cinema.bookScreenSeat();
                    break;
                case 4:
                    cinema.cancelBookScreenSeat();
                    break;
                case 5:
                    cinema.getScreenBookedSeatsDetail();
                    break;
                case 6:
                    cinema.getScreenTotalBookedSeats();
                    break;
                case 7:
                    cinema.getScreenAvailableSeatsDetail();
                    break;
                case 8:
                    cinema.getScreenTotalAvailableSeats();
                    break;
                case 9:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
