// EnhancedArrivalProcess.java
public class EnhancedArrivalProcess {
    private String eventType;
    private ExponentialGenerator randomGenerator;
    private Clock clock;

    public EnhancedArrivalProcess(String eventType, ExponentialGenerator generator) {
        this.eventType = eventType;
        this.randomGenerator = generator;
        this.clock = Clock.getInstance();
    }

    public void generateEvents(EnhancedEventList eventList, int numberOfEvents) {
        double currentTime = clock.getTime();

        for (int i = 0; i < numberOfEvents; i++) {
            double interArrivalTime = randomGenerator.nextDouble();
            currentTime += interArrivalTime;

            Customer customer = new Customer(currentTime);
            EnhancedEvent newEvent = new EnhancedEvent(currentTime, eventType, customer);
            eventList.addEvent(newEvent);

            clock.setTime(currentTime);
        }
    }
}