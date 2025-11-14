// Clock.java
public class Clock {
    private static Clock instance = null;
    private double currentTime;

    private Clock() {
        this.currentTime = 0.0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public double getTime() {
        return currentTime;
    }

    public void setTime(double newTime) {
        if (newTime >= currentTime) {
            this.currentTime = newTime;
        } else {
            System.out.println("Error: Cannot set time backwards");
        }
    }

    public void advanceTime(double increment) {
        if (increment > 0) {
            this.currentTime += increment;
        }
    }

    public void reset() {
        this.currentTime = 0.0;
    }
}