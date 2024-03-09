import java.util.*;

class KTM {
    String nama, tahun, jurusan, univ;

    public KTM(String nama, String tahun, String jurusan, String univ) {
        this.nama = nama;
        this.tahun = tahun;
        this.jurusan = jurusan;
        this.univ = univ;
    }

    @Override
    public String toString() {
        return nama + ", " + tahun + ", " + jurusan + ", " + univ;
    }
}

public class reno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String m = scanner.nextLine();

        KTM[] listKTM = new KTM[n];
        
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            KTM ktm = new KTM(data[0], data[1], data[2], data[3]);
            listKTM[i] = ktm;
        }
        
        if (m.indexOf(" ") == -1) {
            int printIndexKeBerapa = Integer.parseInt(m);
                System.out.println(listKTM[printIndexKeBerapa-1]);
        } else {
            String[] printIndexKeBerapa = m.split(" ");
            for (String i : printIndexKeBerapa) {
                System.out.println(listKTM[Integer.parseInt(i)-1]);
            }
        }

        scanner.close();
    }
}