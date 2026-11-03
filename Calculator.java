import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        String s = scanner.next();
        double num2 = scanner.nextDouble();
        double res = add(num1, num2);
        System.out.println(res);
    }

    public static double add(double d1, double d2) {
        return d1 + d2;
    }

    public static double add(double d1, double d2, double d3){
        return d1 + d2 + d3;
    }

    public static double subtract(double d1, double d2) {
        return d1 - d2;
    }

    public static double multiply(double d1, double d2) {
        return d1 * d2;
    }

    public static double divide(double d1, double d2) {
        return d1 / d2;
    }
}
