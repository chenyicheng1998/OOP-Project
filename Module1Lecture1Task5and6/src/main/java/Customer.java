public class Customer {
    private static int nextId = 1;

    private int id;
    private long arrivalTime;
    private long serviceStartTime;
    private long serviceEndTime;

    public Customer() {
        this.id = nextId++;
        this.arrivalTime = System.nanoTime();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(long serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public long getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(long serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public long getWaitingTime() {
        if (serviceStartTime == 0) return 0;
        return serviceStartTime - arrivalTime;
    }

    public long getServiceTime() {
        if (serviceEndTime == 0 || serviceStartTime == 0) return 0;
        return serviceEndTime - serviceStartTime;
    }

    public long getResponseTime() {
        if (serviceEndTime == 0) return System.nanoTime() - arrivalTime;
        return serviceEndTime - arrivalTime;
    }
}