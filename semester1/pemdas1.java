public class pemdas1 {
  public static void main(String[] args) {
    String hasil = "";
    double IPK = 0;

    if (IPK < 2.0) {
      hasil = "Kurang";
    } else if (IPK <= 2.4) {
      hasil = "Baik";
    } else if (IPK <= 2.9) {
      hasil = "Baik Sekali";
    } else if (IPK <= 3.4) {
      hasil = "Memuaskan";
    } else if (IPK <= 4.0) {
      hasil = "Sangat Memuaskan";
    }

    System.out.println(hasil);
    // =============================================================================================================================
    String nilaiHuruf = "";
    double nilaiAngka = 0;

    nilaiHuruf = nilaiAngka > 80 ? "A" : nilaiAngka > 75 ? "B+" : nilaiAngka > 69 ? "B" : nilaiAngka > 60 ? "C+" : "E";

    // if (nilaiAngka <= 60) {
    // nilaiHuruf = "E";
    // } else if (nilaiAngka <= 69) {
    // nilaiHuruf = "C+";
    // } else if (nilaiAngka <= 75) {
    // nilaiHuruf = "B";
    // } else if (nilaiAngka <= 80) {
    // nilaiHuruf = "B+";
    // } else {
    // nilaiHuruf = "A";
    // }

    System.out.println(nilaiHuruf);

  }
}
