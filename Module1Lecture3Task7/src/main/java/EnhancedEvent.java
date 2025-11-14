public class EnhancedEvent {
    private double time;
    private String type;
    private Customer customer;

    public EnhancedEvent(double time, String type, Customer customer) {
        this.time = time;
        this.type = type;
        this.customer = customer;
    }

    public double getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return String.format("Event{time=%.2f, type='%s', customer=%s}",
                time, type, customer);
    }
}