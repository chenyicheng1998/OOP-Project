public class Clock {
    private static Clock instance = null;
    private double currentTime;

    // Private constructor to prevent external instantiation
    private Clock() {
        this.currentTime = 0.0;
    }

    // Static method to get the singleton instance
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    // Get current time
    public double getTime() {
        return currentTime;
    }

    // Set current time
    public void setTime(double newTime) {
        if (newTime >= currentTime) {
            this.currentTime = newTime;
        } else {
            System.out.println("Error: Cannot set time backwards");
        }
    }

    // Advance time by a specific amount
    public void advanceTime(double increment) {
        if (increment > 0) {
            this.currentTime += increment;
        }
    }

    // Reset the clock
    public void reset() {
        this.currentTime = 0.0;
    }
}