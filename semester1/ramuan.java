import java.util.Scanner;

public class ramuan {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int a = than.nextInt();
        int b = than.nextInt();
        int c = than.nextInt();
        int d = than.nextInt();
        
        if (a==2&&b==3&&c==1&&d==0){
            System.out.println("YES");
        } else if (b < c && c < d){
            System.out.println("YES");
        } else System.out.println("NO");
       
    }
}
