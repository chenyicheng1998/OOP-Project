public class Customer {
    private static int nextId = 1;

    private int id;
    private long startTime;
    private long endTime;

    public Customer() {
        this.id = nextId++;
        this.startTime = System.nanoTime();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getTimeSpent() {
        if (endTime == 0) {
            return System.nanoTime() - startTime;
        }
        return endTime - startTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", timeSpent=" + getTimeSpent() + " ns" +
                '}';
    }
}