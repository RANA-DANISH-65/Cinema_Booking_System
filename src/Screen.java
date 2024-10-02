public class Screen {
    private Seat[][] seats;
    private String screenId;
    private String movie;

    public Screen(String screenId, String movie) {
        this.screenId = screenId;
        this.movie = movie;
        initializeSeats();
    }

    private void initializeSeats() {
        seats = new Seat[10][];
        for (int row = 0; row < 10; row++) {
            int numberOfSeatsInRow = 5 + row;
            seats[row] = new Seat[numberOfSeatsInRow];
            String type;
            for (int seatNumber = 0; seatNumber < numberOfSeatsInRow; seatNumber++) {
                type = (row < 5) ? "VIP" : "Regular";
                int uniqueId = (row + 1) * 100 + (seatNumber + 1);
                seats[row][seatNumber] = new Seat(uniqueId, type);
            }
        }
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getScreenId() {
        return screenId;
    }

    public String getMovie() {
        return movie;
    }

    public void bookSeat(int seatNumber) {
        boolean isFound = false;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.getId() == seatNumber) {
                    isFound = true;
                    if (seat.isAvailable()) {
                        seat.setAvailable(false);
                        System.out.println("-----Seat Booked Successfully");
                    } else {
                        System.out.println("----Seat is Already Booked---------");
                    }
                }
            }
        }
        if (!isFound) {
            System.out.println("This Seat is Not Present in This Screen");
        }
    }

    public void cancelSeatBooking(int seatNumber) {
        boolean isFound = false;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.getId() == seatNumber) {
                    isFound = true;
                    if (!seat.isAvailable()) {
                        seat.setAvailable(true);
                        System.out.println("-----Seat Booking Canceled Successfully");
                    } else {
                        System.out.println("----Seat is Already Not Booked---------");
                    }
                }
            }
        }
        if (!isFound) {
            System.out.println("This Seat is Not Present in This Screen");
        }
    }

    public void getTotalAvailableSeats() {
        int availableCount = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.isAvailable()) {
                    availableCount++;
                }
            }
        }
        System.out.println("-----Total Available Seats: " + availableCount);
    }

    public void getAvailableSeatsDetail() {
        System.out.println("-----Available Seats Details-----");
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.isAvailable()) {
                    System.out.println(seat);
                }
            }
        }
    }

    public void getTotalBookedSeats() {
        int bookedCount = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (!seat.isAvailable()) {
                    bookedCount++;
                }
            }
        }
        System.out.println("-----Total Booked Seats: " + bookedCount);
    }

    public void getBookedSeatsDetail() {
        System.out.println("-----Booked Seats Details-----");
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (!seat.isAvailable()) {
                    System.out.println(seat);
                }
            }
        }
    }

    public void getScreenDetails() {
        System.out.println("-----Screen Details-----");
        System.out.println("The ID of Screen: " + screenId);
        System.out.println("The Movie on This Screen: " + movie);
        getTotalAvailableSeats();
        getTotalBookedSeats();
    }
}
