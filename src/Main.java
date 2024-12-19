import java.util.function.Function;

public class Main {
    // Узлы и веса для метода Гаусса-Эрмита при n = 3
    static final double[] NODES = {-1.22474, 0.0, 1.22474};
    static final double[] WEIGHTS = {0.29541, 1.18164, 0.29541};

    public static double gaussHermite(Function<Double, Double> f) {
        double result = 0.0;
        for (int i = 0; i < NODES.length; i++) {
            result += WEIGHTS[i] * f.apply(NODES[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        //f(x) = (x + 1)^4
        Function<Double, Double> f1 = x -> Math.pow(x + 1, 4);
        // f(x) = x^2 * cos(2x)
        Function<Double, Double> f2 = x -> Math.pow(x, 2) * Math.cos(2 * x);

        double result1 = gaussHermite(f1);
        double result2 = gaussHermite(f2);

        System.out.printf("Результат для f(x) = (x + 1)^4: %.5f \n", result1);
        System.out.printf("Результат для f(x) = x^2 * cos(2x): %.5f \n", result2);
    }
}
