public class Seat {
    private int id;
    private String type;
    private boolean isAvailable;
    private double price;

    public Seat(int id, String type) {
        this.id = id;
        this.type = type;
        this.isAvailable = true;
        setPrice();
    }


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
        setPrice();
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }


    public void setPrice() {
        if (type.equalsIgnoreCase("VIP")) {
            this.price = 1500;
        } else {
            this.price = 1000;
        }
    }

    @Override
    public String toString() {
        return "Seat ID: " + id + ", Type: " + type + ", Price: " + price + ", Available: " + (isAvailable ? "Yes" : "No");
    }


    public void displaySeatInfo() {
        System.out.println("-----The ID of Seat: " + id);
        System.out.println("-----The Type of Seat: " + type);
        System.out.println("-----The Price: " + price);
        System.out.println("-----Available: " + (isAvailable ? "Yes" : "No"));
    }
}
