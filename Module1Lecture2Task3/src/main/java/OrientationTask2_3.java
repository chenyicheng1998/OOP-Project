// Test program with EventType
public class OrientationTask2_3 {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Create events with different types
        eventList.addEvent(new Event(10.5, EventType.ARRIVAL, 1));
        eventList.addEvent(new Event(5.2, EventType.DEPARTURE, 1));
        eventList.addEvent(new Event(15.8, EventType.SERVICE_START, 2));
        eventList.addEvent(new Event(3.1, EventType.ARRIVAL, 2));
        eventList.addEvent(new Event(8.7, EventType.SERVICE_END, 1));
        eventList.addEvent(new Event(12.3, EventType.DEPARTURE, 2));

        // Print all events in order
        System.out.println("=== All Events ===");
        eventList.printEvents();

        // Process events in order
        System.out.println("\n=== Processing Events ===");
        while (eventList.hasMoreEvents()) {
            Event nextEvent = eventList.getNextEvent();
            System.out.println("Processing: " + nextEvent);

            // Simulate event processing based on type
            switch (nextEvent.getEventType()) {
                case ARRIVAL:
                    System.out.println("  -> Customer " + nextEvent.getCustomerId() + " arrives");
                    break;
                case DEPARTURE:
                    System.out.println("  -> Customer " + nextEvent.getCustomerId() + " departs");
                    break;
                case SERVICE_START:
                    System.out.println("  -> Customer " + nextEvent.getCustomerId() + " starts service");
                    break;
                case SERVICE_END:
                    System.out.println("  -> Customer " + nextEvent.getCustomerId() + " ends service");
                    break;
            }
        }
    }
}