import java.util.PriorityQueue;

// Event class implementing Comparable for priority queue ordering
public class Event implements Comparable<Event> {
    private double eventTime;

    public Event(double eventTime) {
        this.eventTime = eventTime;
    }

    public double getEventTime() {
        return eventTime;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }

    @Override
    public String toString() {
        return String.format("Event{time=%.2f}", eventTime);
    }
}