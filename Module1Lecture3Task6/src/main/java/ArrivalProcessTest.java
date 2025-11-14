public class ArrivalProcessTest {
    public static void main(String[] args) {
        // Initialize components
        Clock clock = Clock.getInstance();
        EventList eventList = new EventList();

        // Create ArrivalProcess with exponential distribution using eduni (mean = 5.0)
        ExponentialGenerator expGenerator = new ExponentialGenerator(5.0);
        ArrivalProcess arrivalProcess = new ArrivalProcess("ARRIVAL", expGenerator);

        System.out.println("Initial clock time: " + clock.getTime());

        // Generate 10 arrival events
        arrivalProcess.generateEvents(eventList, 10);

        System.out.println("Final clock time: " + clock.getTime());

        // Print all generated events
        eventList.printEvents();
    }
}