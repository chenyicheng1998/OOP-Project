// Updated EventList class (same as before, works with enhanced Event class)
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class EventList {
    private PriorityQueue<Event> events;

    public EventList() {
        events = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getNextEvent() {
        return events.poll();
    }

    public boolean hasMoreEvents() {
        return !events.isEmpty();
    }

    public ArrayList<Event> getEventsInOrder() {
        ArrayList<Event> sortedEvents = new ArrayList<>(events);
        Collections.sort(sortedEvents);
        return sortedEvents;
    }

    public void printEvents() {
        ArrayList<Event> sortedEvents = getEventsInOrder();
        System.out.println("Events in chronological order:");
        for (Event event : sortedEvents) {
            System.out.println(event);
        }
    }

    public int size() {
        return events.size();
    }
}