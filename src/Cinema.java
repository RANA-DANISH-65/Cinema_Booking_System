import java.util.Scanner;

public class Cinema {
    private Screen[] screens;
    private String name;
    private Scanner sc;

    public Cinema(int screenNo, String name) {
        screens = new Screen[screenNo];
        sc = new Scanner(System.in);
        setScreens();
        this.name = name;
    }

    private void setScreens() {
        for (int i = 0; i < screens.length; i++) {
            System.out.print("Enter Id for Screen " + (i + 1) + ": ");
            String id = sc.nextLine();
            System.out.println("Enter Movie name for Screen " + (i + 1) + ": ");
            String movie = sc.nextLine();
            screens[i] = new Screen(id, movie);
        }
    }

    private int selectScreen() {
        for (int i = 0; i < screens.length; i++) {
            System.out.println((i + 1) + ". Screen " + (i + 1));
        }
        System.out.println("Select Screen:");
        int screenChoice = sc.nextInt();
        sc.nextLine();
        if (screenChoice < 1 || screenChoice > screens.length) {
            System.out.println("Invalid screen choice.");
            return -1;
        }
        return screenChoice;
    }

    public void changeMovieName() {
        int screenChoice = selectScreen()-1;
        if (screenChoice == -1) return;

        System.out.println("Enter New Name of Movie:");
        String newName = sc.nextLine();
        screens[screenChoice].setMovie(newName);
    }

    public void bookScreenSeat() {
        int screenChoice = selectScreen()-1;
        if (screenChoice == -1) return;

        System.out.println("Enter Id of Seat to book:");
        int idChoice = sc.nextInt();
        screens[screenChoice].bookSeat(idChoice);
    }

    public void cancelBookScreenSeat() {
        int screenChoice = selectScreen()-1;
        if (screenChoice == -1) return;

        System.out.println("Enter Id of Seat to cancel booking:");
        int idChoice = sc.nextInt();
        screens[screenChoice].cancelSeatBooking(idChoice);
    }

    public void getScreenBookedSeatsDetail() {
        int screenChoice = selectScreen()-1;
        if (screenChoice == -1) return;

        screens[screenChoice].getBookedSeatsDetail();
    }

    public void getScreenTotalBookedSeats() {
        int screenChoice = selectScreen()-1;
        if (screenChoice == -1) return;

        screens[screenChoice].getTotalBookedSeats();
    }

    public void getScreenAvailableSeatsDetail() {
        int screenChoice = selectScreen()-1;
        if (screenChoice == -1) return;

        screens[screenChoice].getAvailableSeatsDetail();
    }

    public void getScreenTotalAvailableSeats() {
        int screenChoice = selectScreen()-1;
        if (screenChoice == -1) return;

        screens[screenChoice].getTotalAvailableSeats();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Screen[] getScreens() {
        return screens;
    }

    public String getName() {
        return name;
    }


}
