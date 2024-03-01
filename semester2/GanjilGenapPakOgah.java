import java.util.*;

public class GanjilGenapPakOgah {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int loop = than.nextInt();
        Printer<String> ogah = new Printer<>(); 
        
        for (int i = 0; i < loop; i++) {
            String input = than.next();
            try {
                int num = Integer.parseInt(input);
                ogah.print(num);
            } catch (Exception e) {
                ogah.print(input);
            }

        }

    }
}

class Printer<T> {
    public void print(String input) {
        System.out.println(input + " adalah kata");
    }

    public void print(int input) {
        if (input < 0)
            System.out.println(input + " adalah angka minus");
        else
            System.out.println(input + " adalah angka");
    }
}
