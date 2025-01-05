public class Main {
    public static double f(double x) {
        return 2 * x * x - 1 / (1 + x) - 16;
    }
    // Метод хорд
    public static double findRoot(double a, double b, double epsilon) {
        double c;
        int iteration = 0;
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%n", "Итерация", "a", "b", "c", "f(c)");
        while (Math.abs(b - a) > epsilon) {
            iteration++;
            c = a - f(a) * (b - a) / (f(b) - f(a));
            System.out.printf("%-10d%-15f%-15f%-15f%-15f%n", iteration, a, b, c, f(c));
            if (f(c) == 0) { // Если найден точный корень
                return c;
            } else if (f(a) * f(c) < 0) { // Корень находится в левом подотрезке
                b = c;
            } else { // Корень находится в правом подотрезке
                a = c;
            }
        }
        return (a + b) / 2; // Возвращаем среднюю точку интервала
    }

    public static void main(String[] args) {
        double a = 2;
        double b = 4;
        double epsilon = 0.001;
        double root = findRoot(a, b, epsilon);
        System.out.printf("Найденный корень: %.6f%n", root);
    }
}