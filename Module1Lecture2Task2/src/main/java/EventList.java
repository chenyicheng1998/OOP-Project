import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

// EventList class using PriorityQueue
public class EventList {
    private PriorityQueue<Event> events;

    public EventList() {
        events = new PriorityQueue<>();
    }

    // Add event to the list
    public void addEvent(Event event) {
        events.add(event);
    }

    // Get the next event (earliest time)
    public Event getNextEvent() {
        return events.poll();
    }

    // Check if there are more events
    public boolean hasMoreEvents() {
        return !events.isEmpty();
    }

    // Get all events in chronological order (for printing)
    public ArrayList<Event> getEventsInOrder() {
        ArrayList<Event> sortedEvents = new ArrayList<>(events);
        Collections.sort(sortedEvents);
        return sortedEvents;
    }

    // Print all events in chronological order
    public void printEvents() {
        ArrayList<Event> sortedEvents = getEventsInOrder();
        System.out.println("Events in chronological order:");
        for (Event event : sortedEvents) {
            System.out.println(event);
        }
    }

    // Get the number of events in the list
    public int size() {
        return events.size();
    }
}