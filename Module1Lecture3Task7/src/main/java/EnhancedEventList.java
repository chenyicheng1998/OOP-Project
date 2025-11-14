import java.util.ArrayList;
import java.util.List;

public class EnhancedEventList {
    private List<EnhancedEvent> events;

    public EnhancedEventList() {
        this.events = new ArrayList<>();
    }

    public void addEvent(EnhancedEvent event) {
        events.add(event);
        // Simple insertion sort to maintain time order
        events.sort((e1, e2) -> Double.compare(e1.getTime(), e2.getTime()));
    }

    public EnhancedEvent getNextEvent() {
        return events.isEmpty() ? null : events.remove(0);
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public void printEvents() {
        System.out.println("Event List (in time order):");
        for (EnhancedEvent event : events) {
            System.out.println("  " + event);
        }
    }
}