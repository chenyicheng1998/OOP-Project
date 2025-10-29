public class OrientationTask1_3 {
    public static void main(String[] args) {
        // Test Customer class
        Customer customer1 = new Customer();
        System.out.println("Customer 1 created: " + customer1);

        try {
            Thread.sleep(100); // Simulate some time passing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Customer customer2 = new Customer();
        customer2.setEndTime(System.nanoTime());
        System.out.println("Customer 2 created and served: " + customer2);

        customer1.setEndTime(System.nanoTime());
        System.out.println("Customer 1 served: " + customer1);

        // Test time calculation
        System.out.println("Customer 1 time spent: " + customer1.getTimeSpent() + " ns");
        System.out.println("Customer 2 time spent: " + customer2.getTimeSpent() + " ns");
    }
}