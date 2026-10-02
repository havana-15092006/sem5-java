class TicketCounter {

    int tickets = 5;

    synchronized void bookTicket(String name, int number) {

        if (tickets >= number) {

            System.out.println(name + " is booking "
                    + number + " ticket(s).");

            tickets -= number;

            System.out.println("Booking successful.");
            System.out.println("Remaining tickets: " + tickets);

        } else {
            System.out.println(name
                    + " - Not enough tickets available.");
        }
    }
}

class Customer extends Thread {

    TicketCounter counter;
    int number;

    Customer(TicketCounter counter, String name, int number) {
        super(name);
        this.counter = counter;
        this.number = number;
    }

    public void run() {
        counter.bookTicket(getName(), number);
    }
}

public class TicketBooking {

    public static void main(String[] args) {

        TicketCounter counter = new TicketCounter();

        Customer c1 = new Customer(counter, "Alice", 2);
        Customer c2 = new Customer(counter, "Bob", 2);
        Customer c3 = new Customer(counter, "Charlie", 2);

        c1.start();
        c2.start();
        c3.start();
    }
}
