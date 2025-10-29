public class OrientationTask1_5_6 {
    public static void main(String[] args) {
        // Run multiple simulations
        int numberOfSimulations = 3;
        int customersPerSimulation = 5;

        for (int sim = 1; sim <= numberOfSimulations; sim++) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("SIMULATION " + sim + " - " + customersPerSimulation + " CUSTOMERS");
            System.out.println("=".repeat(50));

            ServicePoint servicePoint = new ServicePoint();
            CustomerGenerator generator = new CustomerGenerator();

            // Generate customers
            generator.generateCustomers(servicePoint, customersPerSimulation);

            // Serve customers
            servicePoint.serve();

            // Display statistics
            System.out.println("\n=== SIMULATION " + sim + " RESULTS ===");
            System.out.println("Total customers served: " + servicePoint.getTotalCustomersServed());
            System.out.printf("Average service time: %.2f ms\n", servicePoint.getAverageServiceTime());

            // Wait between simulations
            if (sim < numberOfSimulations) {
                try {
                    System.out.println("\nWaiting 2 seconds before next simulation...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("\nAll simulations completed!");
    }
}