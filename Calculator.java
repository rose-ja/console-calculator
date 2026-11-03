import java.util.Scanner;

/** 控制台计算器 */
public class Calculator {
    private static final String EXIT = "exit";
    private static final String EMPTY = "empty";

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入: 数字 运算符 数字 (例如 3 + 4)");
        System.out.println("支持 ans 表示上一次结果,输入 exit 退出");
        Double lastRes = null;

        while (true) {
            String[] strings = readInput(scanner);

            if (strings[0].equals(EMPTY)) {
                System.out.println("输入内容不能为空");
                continue;
            } else if (strings[0].equals(EXIT)) {
                break;
            } else if (strings.length != 3) {
                System.out.println("格式错误,请按: 数字 运算符 数字");
                continue;
            }

            try {
                double num1 = parseOperand(strings[0], lastRes);
                String s = strings[1];
                double num2 = parseOperand(strings[2],lastRes);
                Double res = calculate(num1, s, num2);

                if (res != null) {
                    lastRes = res;
                    System.out.println(res);
                }
            } catch (NumberFormatException e) {
                System.out.println("格式错误,请按: 数字 运算符 数字");
                continue;
            } catch (IllegalStateException e) {
                System.out.println("还没有可用结果,请先算一次");
                continue;
            }
        }
        scanner.close();
    }

    /**
     * 连加判断函数
     * @param token
     * @param lastRes
     * @return
     */
    public static double parseOperand(String token, Double lastRes) {
        if (token.equals("ans")) {
            if (lastRes == null) {
                throw new IllegalStateException("还没有可用结果");  // 或返回特殊值
            }
            return lastRes;
        }
        return Double.parseDouble(token);
    }

    /**
     * 输入处理函数
     * @param scanner
     * @return
     */
    public static String[] readInput(Scanner scanner) {
        String line = scanner.nextLine().trim();
        String[] strings = new String[3];

        if (line.length() == 0) {
            strings[0] = EMPTY;
        } else if (line.equals(EXIT)) {
            strings[0] = EXIT;
        } else {
            strings = line.split("\\s+"); //    \\s+ 表示"一个或多个空白",能兼容多个空格的情况
        }

        return strings;
    }

    /**
     * 分发函数
     * @param num1
     * @param s
     * @param num2
     * @return
     */
    public static Double calculate(double num1, String s, double num2) {
        switch (s) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "^":
                return power(num1, num2);
            case "%":
                if (num2 == 0) {
                    System.out.println("除数不能为零");
                    return null;
                }
                return remainder(num1, num2);
            case "/":
                if (num2 == 0) {
                    System.out.println("除数不能为零");
                    return null;
                }
                return divide(num1, num2);
            default:
                System.out.println("不支持的运算符");
                return null;
        }
    }

    /**
     * 加法函数
     * @param d1
     * @param d2
     * @return
     */
    public static double add(double d1, double d2) {
        return d1 + d2;
    }

    /**
     * 减法函数
     * @param d1
     * @param d2
     * @return
     */
    public static double subtract(double d1, double d2) {
        return d1 - d2;
    }

    /**
     * 乘法函数
     * @param d1
     * @param d2
     * @return
     */
    public static double multiply(double d1, double d2) {
        return d1 * d2;
    }

    /**
     * 除法函数
     * @param d1
     * @param d2
     * @return
     */
    public static double divide(double d1, double d2) {
        return d1 / d2;
    }

    /**
     * 取余函数
     * @param d1
     * @param d2
     * @return
     */
    public static double remainder(double d1, double d2) {
        return d1 % d2;
    }

    /**
     * 乘方函数
     * @param d1
     * @param d2
     * @return
     */
    public static double power(double d1, double d2) {
        return Math.pow(d1, d2);
    }
}
