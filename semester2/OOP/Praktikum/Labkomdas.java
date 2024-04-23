package OOP.Praktikum;

import java.util.Scanner;

public class Labkomdas {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int a, b, c = 0;
        System.out.print("Jacket A quantity: ");
        a = than.nextInt();
        System.out.print("Jacket B quantity: ");
        b = than.nextInt();
        System.out.print("Jacket C quantity: ");
        c = than.nextInt();
        Jacket jacket = new Jacket();
        System.out.println("Total price: " + jacket.price(a, b, c));

    }

}

class Calc {
    double a, b;

    Calc(double a, double b) {
        this.a = a;
        this.b = b;
    }

    Calc() {
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        return a / b;
    }

    public void simplify() {
        int gcd = KPK((int) a, (int) b);
        a = a / gcd;
        b = b / gcd;
    }

    private int KPK(int a, int b) {
        if (b == 0) {
            return a;
        }
        return KPK(b, a % b);
    }
}

class Jacket {
    final int A = 100_000;
    final int B = 125_000;
    final int C = 175_000;

    public int price(int qtyA, int qtyB, int qtyC) {
        int A = this.A;
        int B = this.B;
        int C = this.C;

        if (qtyA >= 100) {
            A = 95_000;
        }
        if (qtyB >= 100) {
            B = 120_000;

        }
        if (qtyC >= 100) {
            C = 160_000;

        }

        Calc calc = new Calc();
        return (int) Calc.add(Calc.add(calc.mul(qtyA, A), calc.mul(qtyB, B)), calc.mul(qtyC, C));
    }
}