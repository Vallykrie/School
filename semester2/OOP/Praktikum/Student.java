package OOP.Praktikum;

public class Student {
    private String name;
    private int mark;

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setMark(int m) {
        mark = m;
    }

    public int getMark() {
        return mark;
    }
}

// public class Student {
// private String name;
// private String address;
// private int age;
// private double mathGrade;
// private double englishGrade;
// private double scienceGrade;
// private double average;
// private static int jumlah = 0;

// public Student() {
// name = "";
// address = "";
// age = 0;
// jumlah++;
// }

// public Student(String n, String a, int ag) {
// name = n;
// address = a;
// age = ag;
// jumlah++;
// }

// public Student(double mathGrade, double englishGrade, double scienceGrade) {
// this.mathGrade = mathGrade;
// this.englishGrade = englishGrade;
// this.scienceGrade = scienceGrade;
// jumlah++;

// }

// public void setName(String n) {
// name = n;
// }

// public void setAddress(String a) {
// address = a;
// }

// public void setAge(int ag) {
// age = ag;
// }

// public void setMath(double math) {
// mathGrade = math;
// }

// public void setEnglish(double english) {
// englishGrade = english;
// }

// public void setScience(double science) {
// scienceGrade = science;
// }

// private double getAverage() {
// double result = 0;
// result = (mathGrade + scienceGrade + englishGrade) / 3;
// return result;
// }

// public void displayMessage() {
// System.out.println("Siswa dengan nama " + name);
// System.out.println("beralamat di " + address);
// System.out.println("berumur " + age);
// System.out.println("mempunyai nilai rata rata " + getAverage());
// System.out.println("status kelulusan " + (statusAkhir() ? "Lulus" : "Tidak
// Lulus"));
// }

// public boolean statusAkhir() {
// return getAverage() >= 61;
// }

// public static void jumlahObjek() {
// System.out.println("Jumlah objek yang telah dibuat: " + jumlah);
// }
// }
