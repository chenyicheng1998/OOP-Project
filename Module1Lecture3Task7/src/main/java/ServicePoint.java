import java.util.LinkedList;
import java.util.Queue;

public class ServicePoint {
    private Queue<Customer> queue;

    public ServicePoint() {
        this.queue = new LinkedList<>();
    }

    public void addToQueue(Customer customer) {
        queue.add(customer);
        System.out.println("Added to queue: " + customer);
    }

    public Customer serveNext() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getQueueSize() {
        return queue.size();
    }
}