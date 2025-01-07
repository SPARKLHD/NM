public class Main {
    public static void main(String[] args) {
        double[][] A = {
                {-2, 4, -3.3},
                {3, -5, 1},
                {-1, 2, 1}
        };
        double[] f = {-19.9, 16, -2};

        // Переменная для хранения количества перестановок строк
        int swapCount = 0;

        double[] solution = solveGaussian(A, f, swapCount);

        System.out.println("Решение системы:");
        for (int i = 0; i < solution.length; i++) {
            System.out.printf("x%d = %.5f%n", i + 1, solution[i]);
        }

        // Вычисление определителя
        double determinant = calculateDeterminant(A, swapCount);
        System.out.printf("Определитель матрицы: %.5f%n", determinant);

        System.out.println("Матрица A после преобразований:");
        printMatrix(A);
    }

    public static double[] solveGaussian(double[][] A, double[] f, int swapCount) {
        int n = A.length;

        // Прямой ход
        for (int i = 0; i < n; i++) {
            // Поиск главного элемента в текущем столбце
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Перестановка строк (если главная строка отличается)
            if (i != maxRow) {
                double[] temp = A[i];
                A[i] = A[maxRow];
                A[maxRow] = temp;

                double t = f[i];
                f[i] = f[maxRow];
                f[maxRow] = t;

                // Увеличиваем количество перестановок
                swapCount++;
            }

            // Приведение к треугольному виду
            for (int k = i + 1; k < n; k++) {
                double factor = A[k][i] / A[i][i];
                f[k] -= factor * f[i];
                for (int j = i; j < n; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }

        // Обратный ход
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (f[i] - sum) / A[i][i];
        }
        return x;
    }

    public static double calculateDeterminant(double[][] A, int swapCount) {
        int n = A.length;
        double determinant = 1.0;

        // Вычисляем произведение диагональных элементов
        for (int i = 0; i < n; i++) {
            determinant *= A[i][i];
        }

        // Учитываем знак перестановок строк
        if (swapCount % 2 != 0) {
            determinant *= -1;
        }

        return determinant;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%10.5f", value);
            }
            System.out.println();
        }
    }
}