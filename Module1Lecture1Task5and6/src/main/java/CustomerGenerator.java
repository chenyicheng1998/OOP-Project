public class CustomerGenerator {
    public void generateCustomers(ServicePoint servicePoint, int numberOfCustomers) {
        System.out.println("Generating " + numberOfCustomers + " customers...");

        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer();
            servicePoint.addToQueue(customer);

            // Random delay between customer arrivals (0-1000 ms)
            if (i < numberOfCustomers - 1) {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("All " + numberOfCustomers + " customers generated.");
    }
}