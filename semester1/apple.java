import java.util.Scanner;

public class apple {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String typo = than.nextLine();
        boolean Apple = false;
        if (typo.indexOf("apple")==-1) {
            Apple = false;
        } else Apple = true;
        if (typo.length() >= 5) {
            int indexA = typo.indexOf("a");
            int indexP = typo.indexOf("p", indexA + 1);
            int indexP2 = typo.indexOf("p", indexP + 1);
            int indexL = typo.indexOf("l", indexP2 + 1);
            int indexE = typo.indexOf("e", indexL + 1);
            
            if (indexA != -1 && indexP != -1 && indexP2 != -1 && indexL != -1 && indexE != -1) {
                Apple = true;
            } else Apple = false;
        }

        if (Apple) {
            System.out.println("He's a little confused but he got the spirit.");
        } else {
            System.out.println("Maybe he's confused after all.");
        }
    }
}
