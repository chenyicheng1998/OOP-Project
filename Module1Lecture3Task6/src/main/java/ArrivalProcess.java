public class ArrivalProcess {
    private String eventType;
    private ExponentialGenerator randomGenerator; // 改为具体类
    private Clock clock;

    public ArrivalProcess(String eventType, ExponentialGenerator generator) {
        this.eventType = eventType;
        this.randomGenerator = generator;
        this.clock = Clock.getInstance();
    }

    public void generateEvents(EventList eventList, int numberOfEvents) {
        double currentTime = clock.getTime();

        for (int i = 0; i < numberOfEvents; i++) {
            // Generate inter-arrival time using eduni distribution
            double interArrivalTime = randomGenerator.nextDouble();
            currentTime += interArrivalTime;

            // Create new event
            Event newEvent = new Event(currentTime, eventType);
            eventList.addEvent(newEvent);

            // Update clock to the new event time
            clock.setTime(currentTime);
        }
    }
}