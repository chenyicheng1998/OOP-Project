// CompleteSimulationTest.java
public class CompleteSimulationTest {
    public static void main(String[] args) {
        // Initialize all components
        Clock clock = Clock.getInstance();
        EnhancedEventList eventList = new EnhancedEventList();
        ServicePoint servicePoint = new ServicePoint();

        // Create arrival process
        ExponentialGenerator expGenerator = new ExponentialGenerator(8.0);
        EnhancedArrivalProcess arrivalProcess = new EnhancedArrivalProcess("ARRIVAL", expGenerator);

        System.out.println("=== PHASE 1: Generating Arrival Events ===");
        System.out.println("Initial clock time: " + clock.getTime());

        // Generate 10 arrival events
        arrivalProcess.generateEvents(eventList, 10);

        System.out.println("Final clock time after event generation: " + clock.getTime());
        eventList.printEvents();

        System.out.println("\n=== PHASE 2: Processing Events ===");

        // Process all events and add customers to service point queue
        while (!eventList.isEmpty()) {
            EnhancedEvent event = eventList.getNextEvent();
            System.out.println("Processing: " + event);
            servicePoint.addToQueue(event.getCustomer());
        }

        System.out.println("\n=== PHASE 3: Advancing Time and Serving Customers ===");

        // Advance clock by 5 time units
        clock.advanceTime(5.0);
        System.out.println("Clock advanced to: " + clock.getTime());

        // Serve customers and calculate time in system
        System.out.println("\nCustomer Service Results:");
        System.out.println("Customer ID\tArrival Time\tDeparture Time\tTime in System");
        System.out.println("----------\t------------\t-------------\t--------------");

        while (!servicePoint.isEmpty()) {
            Customer customer = servicePoint.serveNext();
            double departureTime = clock.getTime();
            double timeInSystem = departureTime - customer.getArrivalTime();

            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n",
                    customer.getId(),
                    customer.getArrivalTime(),
                    departureTime,
                    timeInSystem);

            // Simulate some processing time between customers
            clock.advanceTime(2.0);
        }

        System.out.println("\nSimulation completed. Final clock time: " + clock.getTime());
    }
}