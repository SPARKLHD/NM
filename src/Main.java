import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Пример данных
        double[] x = {1, 3, 4, 7};  // Значения x
        double[] y = {2, 3, 6, 8};  // Значения y

        Scanner scanner = new Scanner(System.in);
        System.out.print("Значение x для интерполяции: ");
        double xInput = scanner.nextDouble();

        double interpolatedValue = interpolate(x, y, xInput);
        if (interpolatedValue != Double.NaN) {
            System.out.println("Значение y = " + interpolatedValue);
        } else {
            System.out.println("Значение x выходит за пределы данных.");
        }
    }

    public static double interpolate(double[] x, double[] y, double xInput) {
        if (xInput < x[0] || xInput > x[x.length - 1]) {
            return Double.NaN; // Если xInput вне диапазона
        }
        for (int i = 0; i < x.length - 1; i++) {
            if (xInput >= x[i] && xInput <= x[i + 1]) {
                return y[i] + (y[i + 1] - y[i]) * (xInput - x[i]) / (x[i + 1] - x[i]);
            }
        }
        return Double.NaN; // Не должно достигать здесь
    }
}
