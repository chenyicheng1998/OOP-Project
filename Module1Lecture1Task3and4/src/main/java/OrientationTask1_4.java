import java.util.LinkedList;
import java.util.Scanner;

public class OrientationTask1_4 {
    private LinkedList<Customer> queue = new LinkedList<>();

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Queue Management System ===");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Remove customer from queue");
            System.out.println("3. Show queue size");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCustomerToQueue();
                    break;
                case 2:
                    removeCustomerFromQueue();
                    break;
                case 3:
                    System.out.println("Current queue size: " + queue.size());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void addCustomerToQueue() {
        Customer customer = new Customer();
        queue.addFirst(customer);
        System.out.println("Customer " + customer.getId() + " added to queue. Queue size: " + queue.size());
    }

    private void removeCustomerFromQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        Customer customer = queue.removeLast();
        customer.setEndTime(System.nanoTime());
        long timeSpent = customer.getTimeSpent();

        System.out.println("Customer " + customer.getId() + " removed from queue.");
        System.out.println("Time spent in queue: " + timeSpent + " ns (" + (timeSpent / 1_000_000.0) + " ms)");
    }

    public static void main(String[] args) {
        OrientationTask1_4 system = new OrientationTask1_4();
        system.run();
    }
}