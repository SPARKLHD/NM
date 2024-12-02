import java.util.Arrays;
public class GaussInterpolationSecondFormula {
    public static void main(String[] args) {
        double[] x = {10, 15, 20, 25, 30};
        double[] y = {};
        // Если массив y пустой, вычисляем его как y = x^3
        if (y.length == 0) {
            y = computeFunctionValues(x);
        }
        System.out.println("x: " + Arrays.toString(x));
        System.out.println("y: " + Arrays.toString(y));
        // Пример:
        double xi = 26;
        double result = gaussInterpolationSecondFormula(x, y, xi);
        System.out.printf("Значение интерполяции в x=%.2f: result = %.4f%n", xi, result);
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
        // Заполняем нулевой порядок разностей (это y)
        for (int i = 0; i < n; i++) {
        diffTable[i][0] = y[i];        }
    // Заполняем таблицу конечных разностей
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
        diffTable[i][j] = diffTable[i + 1][j - 1] - diffTable[i][j - 1];
            }
    }
        double h = x[1] - x[0]; // Равномерный шаг
        double q = (xi - x[n - 1]) / h; // q считается относительно последнего узла
        double result = y[n - 1]; // Начинаем с последнего значения y
        double term = 1; // Для хранения множителя
    // Вычисляем интерполяционную сумму
        for (int i = 1; i < n; i++) {
            term *= (q + (i - 1)) / i; // Учитываем, что q увеличивается
            result += term * diffTable[n - i - 1][i]; // Используем разности с конца таблицы
        }
        return result;
    }
}
