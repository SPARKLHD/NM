public class Main {
    public static void main(String[] args) {
        float epsilon = 1.0f;
        while (1.0f + (epsilon/2.0f) > 1.0f){
            epsilon/=2.0f;
        }
        System.out.println("Machine epsilon for float: " + epsilon);

    double epsilonDouble = 1.0;
    while (1.0 + (epsilonDouble/2.0) > 1.0){
        epsilonDouble/=2.0;
    }
    System.out.println("Machine epsilon for double: " + epsilonDouble);
}
}
