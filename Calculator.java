import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        String s = scanner.next();
        double num2 = scanner.nextDouble();
        System.out.println(num1 + s + num2);
    }
}
