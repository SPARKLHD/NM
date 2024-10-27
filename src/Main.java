
ejeur0werogdfe][]

public class Main {
    public static void main(String[] args) {

        double[] x = {0, 1, 2, 3, 6};
        double[] y = {1, 3, 2, 5, 4};

        System.out.print("Введите значение x для интерполяции: ");
        double xInput = readDouble();

        double interpolatedValue = interpolate(x, y, xInput);
        if (isNaN(interpolatedValue)) {
            System.out.println("Значение x выходит за пределы данных.");
        } else {
            System.out.println("Интерполированное значение для x = " + xInput + " : y = " + interpolatedValue);
        }
    }

    public static double interpolate(double[] x, double[] y, double xInput) {
        if (xInput < x[0] || xInput > x[x.length - 1]) {
            return Double.NaN;
        }

        for (int i = 0; i < x.length - 1; i++) {
            if (xInput >= x[i] && xInput <= x[i + 1]) {
                // Вычисляем y с помощью кусочной линейной интерполяции
                double slope = (y[i + 1] - y[i]) / (x[i + 1] - x[i]); // Нахождение углового коэффициента
                return y[i] + slope * (xInput - x[i]); // Линейная интерполяция
            }
        }
        return Double.NaN;
    }

    // Метод для проверки на NaN
    public static boolean isNaN(double value) {
        return value != value;
    }

    // Метод для чтения значения типа double с консоли
    public static double readDouble() {
        StringBuilder input = new StringBuilder();
        try {
            int character;
            while ((character = System.in.read()) != '\n') {
                input.append((char) character);
            }
        } catch (java.io.IOException e) {
            System.out.println("Ошибка чтения ввода.");
        }

        try {
            return Double.parseDouble(input.toString().trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Установлено значение по умолчанию 0.0.");
            return 0.0; // Возвращаем значение по умолчанию в случае некорректного ввода
        }
    }
}
