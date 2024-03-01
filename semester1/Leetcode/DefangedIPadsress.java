import java.util.Scanner;
public class DefangedIPadsress {
    public static void main(String[] args) {
        try (Scanner than = new Scanner(System.in)) {
            String address = than.nextLine();
            // for (int i = address.hashCode(); i >= 0; i--) {
            //     if (address.charAt(i) == '.') {
            //         System.out.print("[.]");

            //     } else {
            //         System.out.print(address.charAt(i));
            //     }
            // }
            System.out.println(address.replace(".", "[.]"));
            // ternyata sesimple ini 
        }
    }
}
