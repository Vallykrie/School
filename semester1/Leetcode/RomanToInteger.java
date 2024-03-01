import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        try (Scanner than = new Scanner(System.in)) {
            // INPUT
            System.out.println("==================== Roman to Integer Converter ====================");
            System.out.print("Input Roman Numerals: ");
            String roman = than.nextLine();
            System.out.println("====================================================================");
            int num = 0;
            int sum = 0;
            int order = 0;
            int prevOrder = 0;

            // CALCULATION
            for (int i = roman.length() - 1; i >= 0; i--) {
                switch (roman.charAt(i)) {
                    case 'I':
                        order = 1;
                        num = 1;
                        break;
                    case 'V':
                        num = 5;
                        order = 2;
                        break;
                    case 'X':
                        num = 10;
                        order = 3;
                        break;
                    case 'L':
                        num = 50;
                        order = 4;
                        break;
                    case 'C':
                        num = 100;
                        order = 5;
                        break;
                    case 'D':
                        num = 500;
                        order = 6;
                        break;
                    case 'M':
                        num = 1000;
                        order = 7;
                        break;
                    default:
                        break;
                }

                if (order < prevOrder) {
                    sum -= num;
                } else {
                    sum += num;
                }
                prevOrder = order;
                // System.out.println(sum);
                // System.out.println(order);
            }

            // OUTPUT
            System.out.println("Integer ---> " + sum);
        }
    }
}
