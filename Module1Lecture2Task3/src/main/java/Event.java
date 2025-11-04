// Updated Event class with EventType
public class Event implements Comparable<Event> {
    private double eventTime;
    private EventType eventType;
    private int customerId; // Optional: to identify which customer

    public Event(double eventTime, EventType eventType) {
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.customerId = -1; // Not assigned
    }

    public Event(double eventTime, EventType eventType, int customerId) {
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.customerId = customerId;
    }

    public double getEventTime() {
        return eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }

    @Override
    public String toString() {
        if (customerId != -1) {
            return String.format("Event{time=%.2f, type=%s, customer=%d}",
                    eventTime, eventType, customerId);
        } else {
            return String.format("Event{time=%.2f, type=%s}", eventTime, eventType);
        }
    }
}