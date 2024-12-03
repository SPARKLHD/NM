import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        double[] x = {10, 15, 20, 25, 30};
//        double[] y = {3, 7, 11, 17, 18};
        double[] y = {};

        if (y.length == 0) {
            y = computeFunctionValues(x);
        }
        System.out.println("x: " + Arrays.toString(x));
        System.out.println("y: " + Arrays.toString(y));
       
        // Пример:
        double xi = 11;
        double result = gaussInterpolationSecondFormula(x, y, xi);
        System.out.printf("Значение интерполяции в x = %.2f : result = %.4f%n", xi, result);
    }
    private static double[] computeFunctionValues(double[] x) {
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = Math.pow(x[i], 3);
        }
        return y;
    }

    private static double gaussInterpolationSecondFormula(double[] x, double[] y, double xi) {
        int n = x.length;
        double[][] diffTable = new double[n][n];

        for (int i = 0; i < n; i++) {
            diffTable[i][0] = y[i];
        }
        // Заполняем таблицу конечных разностей
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                diffTable[i][j] = diffTable[i + 1][j - 1] - diffTable[i][j - 1];
            }
    }
        System.out.println("Таблица конечных разностей:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(diffTable[i][j] + "  \t");
            }
            System.out.println();
        }

        double h = x[1] - x[0];
        double q = (xi - x[n - 1]) / h; 
        double result = y[n - 1]; 
        double term = 1;

    // Вычисляем интерполяционную сумму
        for (int i = 1; i < n; i++) {
            term *= (q + (i - 1)) / i; 
            result += term * diffTable[n - i - 1][i]; 
        }
        return result;
    }
}
