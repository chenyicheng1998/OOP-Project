import java.util.ArrayList;
import java.util.List;

public class EventList {
    private List<Event> events;

    public EventList() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void printEvents() {
        System.out.println("Event List:");
        for (Event event : events) {
            System.out.println("  " + event);
        }
    }
}