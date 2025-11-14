// ExponentialGenerator.java
import eduni.distributions.Negexp;

public class ExponentialGenerator {
    private Negexp negexp;

    public ExponentialGenerator(double mean) {
        this.negexp = new Negexp(mean);
    }

    public double nextDouble() {
        return negexp.sample();
    }
}