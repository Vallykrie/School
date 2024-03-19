import java.util.Scanner;

public class Praktikum2PBO {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        while (than.hasNextLine()) {
            String input = than.nextLine();
            String data[] = input.split(" ");
            Mahasiswa mhs = new Mahasiswa(data[0], data[1], data[2], data[3]);
            mhs.print();

        }

    }
}

class Mahasiswa {
    String num, nama, NIM, prodi;

    Mahasiswa(String num, String nama, String NIM, String prodi) {
        this.num = num;
        this.nama = nama;
        this.NIM = NIM;
        this.prodi = prodi;
    }

    public void print() {
        switch (num) {
            case "1":
                System.out.println("Mahasiswa pertama : " + nama + ", " + NIM + " " + prodi);
                break;
            case "2":
                System.out.println("Mahasiswa kedua : " + nama + ", " + NIM + " " + prodi);
                break;
            case "3":
                System.out.println("Mahasiswa ketiga : " + nama + ", " + NIM + " " + prodi);
                break;
            case "4":
                System.out.println("Mahasiswa keempat : " + nama + ", " + NIM + " " + prodi);
                break;
            case "5":
                System.out.println("Mahasiswa kelima : " + nama + ", " + NIM + " " + prodi);
                break;
            case "6":
                System.out.println("Mahasiswa keenam : " + nama + ", " + NIM + " " + prodi);
                break;
            case "7":
                System.out.println("Mahasiswa ketujuh : " + nama + ", " + NIM + " " + prodi);
                break;
            case "8":
                System.out.println("Mahasiswa kedelapan : " + nama + ", " + NIM + " " + prodi);
                break;
            case "9":
                System.out.println("Mahasiswa kesembilan : " + nama + ", " + NIM + " " + prodi);
                break;
            case "10":
                System.out.println("Mahasiswa kesepuluh : " + nama + ", " + NIM + " " + prodi);
                break;

            default:
                break;
        }
    }
}