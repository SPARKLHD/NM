import static java.lang.Math.PI;

public class Main {
    // Метод для вычисления производной функции y = sin(x)
    public static double derivative(double x) {
        double h = 1e-10; // малое значение для приближения
        return (Math.sin(x + h) - Math.sin(x - h)) / (2 * h);
    }

    public static void main(String[] args) {
        double x = PI / 2;
        double derivativeValue = derivative(x);
        System.out.println("Производная функции y = sin(x) в x = " + x + " равна: " + derivativeValue);
    }
}
