import eduni.distributions.Negexp;

public class ExponentialGenerator {
    private Negexp negexp;

    public ExponentialGenerator(double mean) {
        // eduni.distributions.Negexp 使用均值作为参数
        this.negexp = new Negexp(mean);
    }

    public double nextDouble() {
        return negexp.sample();
    }
}