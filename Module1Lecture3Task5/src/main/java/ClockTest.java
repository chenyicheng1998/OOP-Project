public class ClockTest {
    public static void main(String[] args) {
        // Get the singleton instance
        Clock clock = Clock.getInstance();

        // Test initial time
        System.out.println("Initial time: " + clock.getTime());

        // Test setting time
        clock.setTime(10.5);
        System.out.println("After setting time: " + clock.getTime());

        // Test advancing time
        clock.advanceTime(2.5);
        System.out.println("After advancing time: " + clock.getTime());

        // Try to set time backwards (should show error)
        clock.setTime(5.0);
        System.out.println("After trying to set backwards: " + clock.getTime());

        // Test that we get the same instance
        Clock anotherReference = Clock.getInstance();
        System.out.println("Same instance? " + (clock == anotherReference));
        System.out.println("Time from another reference: " + anotherReference.getTime());
    }
}