import static java.lang.Math.PI;

public class Main {
    public static void derivative(double x) {
        double h = 1e-10;
        double[] r = new double[7];
        int j = 0;
        for (double i = x; i < PI/2; i = i + PI/6 ) {
            r[j] =  (Math.sin(i + h) - Math.sin(i - h)) / (2 * h);
            System.out.println("Производная функции y = sin(x) в x = " + i + " равна: " + r[j]);
//            System.out.println("Производная функции y = sin(x) в x == " + i + " равна: " + Math.cos(i));
            j++;
        }
    }
    public static void main(String[] args){
        double x = PI / 6;
        derivative(x);
    }
}