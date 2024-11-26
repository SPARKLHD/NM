import java.util.Scanner;

class Point {
    double x;
    double y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static double KusLinInterpolution(Point p1, Point p2, double x) {
        if (p1.x > x || p2.x < x) {
            System.out.println("Ошибка");
            return 0.0;
        }
        return p1.y + (p2.y - p1.y) * (x - p1.x) / (p2.x - p1.x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество узлов: ");
        int n = scanner.nextInt();
        Point[] points = new Point[n];

        System.out.print("Узлы: ");
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        System.out.print("Значение x для кусочно-линейной интерполяции: ");
        double x = scanner.nextDouble();

        for (int i = 0; i < n - 1; i++) {
            if (x >= points[i].x && x <= points[i + 1].x) {
                double result = KusLinInterpolution(points[i], points[i + 1], x);
                System.out.println("Результат кусочно-линейной интерполяции: " + result);
                return;
            }
        }
        System.out.println("Ошибка");
    }
}
