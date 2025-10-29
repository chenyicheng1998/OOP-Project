import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();
    private long totalServiceTime = 0;
    private int totalCustomersServed = 0;

    public void addToQueue(Customer customer) {
        queue.addFirst(customer);
        System.out.println("Customer " + customer.getId() + " added to queue.");
    }

    public Customer removeFromQueue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeLast();
    }

    public void serve() {
        System.out.println("\nStarting service process...");

        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer != null) {
                // Record service start time
                customer.setServiceStartTime(System.nanoTime());

                // Generate random service time between 500-2000 ms
                long serviceTime = (long) (Math.random() * 1500 + 500);

                System.out.println("Serving customer " + customer.getId() +
                        " with service time: " + serviceTime + " ms");

                // Simulate service time
                try {
                    Thread.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Record service end time
                customer.setServiceEndTime(System.nanoTime());

                // Calculate times
                long waitingTime = customer.getWaitingTime();
                long actualServiceTime = customer.getServiceTime();
                long responseTime = customer.getResponseTime();

                // Accumulate statistics
                totalServiceTime += actualServiceTime;
                totalCustomersServed++;

                System.out.println("Customer " + customer.getId() + " served:");
                System.out.println("  - Waiting time: " + (waitingTime / 1_000_000.0) + " ms");
                System.out.println("  - Service time: " + (actualServiceTime / 1_000_000.0) + " ms");
                System.out.println("  - Response time: " + (responseTime / 1_000_000.0) + " ms");
            }
        }

        System.out.println("All customers served!");
    }

    public double getAverageServiceTime() {
        if (totalCustomersServed == 0) return 0;
        return (totalServiceTime / 1_000_000.0) / totalCustomersServed;
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getTotalCustomersServed() {
        return totalCustomersServed;
    }
}