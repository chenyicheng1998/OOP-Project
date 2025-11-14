public class Customer {
    private static int nextId = 1;
    private int id;
    private double arrivalTime;

    public Customer(double arrivalTime) {
        this.id = nextId++;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, arrivalTime=%.2f}", id, arrivalTime);
    }
}