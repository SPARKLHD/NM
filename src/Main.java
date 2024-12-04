import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        float epsilon = 1.0f;

        while (1.0f + (epsilon / 2.0f) > 1.0f) {
            epsilon /= 2.0f;
        }

        // Преобразуем epsilon в BigDecimal и выводим с 256 знаками после запятой
        BigDecimal bdEpsilonFloat = new BigDecimal(epsilon).setScale(256, RoundingMode.HALF_UP);
        System.out.println("Machine epsilon for float: " + bdEpsilonFloat);

        double epsilonDouble = 1.0;

        while (1.0 + (epsilonDouble / 2.0) > 1.0) {
            epsilonDouble /= 2.0;
        }

        // Преобразуем epsilonDouble в BigDecimal и выводим с 256 знаками после запятой
        BigDecimal bdEpsilonDouble = new BigDecimal(epsilonDouble).setScale(256, RoundingMode.HALF_UP);
        System.out.println("Machine epsilon for double: " + bdEpsilonDouble);
    }
}

