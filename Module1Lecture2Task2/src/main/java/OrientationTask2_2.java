// Test program for Event and EventList
public class OrientationTask2_2 {
    public static void main(String[] args) {
        // Create event list
        EventList eventList = new EventList();

        // a) Generate a list of events with random times
        System.out.println("=== Generating Events ===");
        eventList.addEvent(new Event(10.5));
        eventList.addEvent(new Event(5.2));
        eventList.addEvent(new Event(15.8));
        eventList.addEvent(new Event(3.1));
        eventList.addEvent(new Event(8.7));

        // Print initial events
        eventList.printEvents();
        System.out.println("Total events: " + eventList.size());

        // b) Remove and process events in order
        System.out.println("\n=== Processing Events ===");
        while (eventList.hasMoreEvents()) {
            Event nextEvent = eventList.getNextEvent();
            System.out.println("Processing: " + nextEvent);
            System.out.println("Remaining events: " + eventList.size());
        }

        // Test with another set of events
        System.out.println("\n=== Second Test ===");
        eventList.addEvent(new Event(25.0));
        eventList.addEvent(new Event(12.3));
        eventList.addEvent(new Event(7.6));
        eventList.addEvent(new Event(30.1));

        eventList.printEvents();

        // Process a few events
        System.out.println("\nProcessing first event: " + eventList.getNextEvent());
        System.out.println("Processing second event: " + eventList.getNextEvent());

        // Show remaining events
        System.out.println("\nRemaining events:");
        eventList.printEvents();
    }
}