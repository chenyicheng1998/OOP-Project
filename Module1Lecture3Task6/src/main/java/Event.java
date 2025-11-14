public class Event {
    private double time;
    private String type;

    public Event(double time, String type) {
        this.time = time;
        this.type = type;
    }

    public double getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Event{time=%.2f, type='%s'}", time, type);
    }
}