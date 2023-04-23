import java.util.Scanner;

class Passenger {
    private String name;
    private int age;
    private String seatNumber;
    private String luxury;

    public Passenger(String name, int age, String luxury) {
        this.name = name;
        this.age = age;
        this.luxury = luxury;

    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getLuxury() {
        return this.luxury;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }
}

class Flight {

    private String origin;

    private int numSeats;
    private int numBookedSeats;
    private Passenger[] passengers;

    public Flight(String origin, int numSeats) {

        this.origin = origin;

        this.numSeats = numSeats;
        this.numBookedSeats = 0;
        this.passengers = new Passenger[numSeats];
    }

    public boolean bookSeat(Passenger passenger) {
        if (numBookedSeats >= numSeats) {
            System.out.println("Sorry, the flight is full.");
            return false;
        } else {

            passenger.setSeatNumber(Integer.toString(numBookedSeats + 1));
            passengers[numBookedSeats] = passenger;
            numBookedSeats++;
            System.out.println("Seat booked successfully. " + passenger.getName() + " Your " + passenger.getLuxury()
                    + " class seat number is "
                    + passenger.getSeatNumber() + ".");
            return true;
        }
    }

    public String getOrigin() {
        return this.origin;
    }

    public int getNumSeats() {
        return this.numSeats;
    }

    public int getNumBookedSeats() {
        return this.numBookedSeats;
    }
}

public class Airlines {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Flight flight1 = new Flight("Bangalore", 100);

        while (true) {
            System.out
                    .println("\nThe system greets the user and introduces itself as an Airline Reservation System.\n");

            System.out.println("\nMenu:");
            System.out.println("1. Make a reservation for a seat");
            System.out.println("2. Exit");

            System.out.print("\nEnter your choice (1 or 2): ");
            int choice = input.nextInt();

            if (choice == 1) {

                System.out.println("Origin: " + flight1.getOrigin());
                boolean flag = true;
                while (flag) {
                    System.out.println("Destination(Delhi/Mumbai): ");
                    String to = input.next();

                    if (to.equals("Delhi")) {
                        System.out.println("Destination: Delhi");
                        System.out.println("Flight Number: IN302");
                        flag = false;
                    } else if (to.equals("Mumbai")) {
                        System.out.println("Destination: Mumbai");
                        System.out.println("Flight Number: MI222");
                        flag = false;
                    } else {
                        System.out.println("Sorry! for today our destination is only Delhi and Mumbai");
                    }
                }
                System.out.println("Number of seats: " + flight1.getNumSeats());
                System.out.println("Number of booked seats: " + flight1.getNumBookedSeats());

                System.out.print("Enter your age: ");
                int age = input.nextInt();

                input.nextLine();
                System.out.println("Enter your full name: ");
                String name = input.nextLine();
                String luxury = "hi";
                boolean fla = true;
                while (fla) {
                    System.out.println("Economy or Business: ");
                    luxury = input.next();
                    if (luxury.equals("Economy")) {
                        fla = false;
                    } else if (luxury.equals("Business")) {
                        fla = false;
                    } else {
                        System.out.println("Invalid");
                    }
                }
                Passenger passenger = new Passenger(name, age, luxury);
                flight1.bookSeat(passenger);
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nThank you for using the Airline Reservation System!");
    }
}