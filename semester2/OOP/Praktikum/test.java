package OOP.Praktikum;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Enkapsulasi");
        s1.setMark(90); // seharusnya 90 bukan "90"
        System.out.println("s1Name is " + s1.getName()); // seharusnya getName() bukan setName()
        System.out.println("s1Mark is " + s1.getMark()); // seharusnya getMark() bukan setMark()
        System.out.println("name dan mark " + s1.getName() + " " + s1.getMark()); // seharusnya s1.getName() dan
                                                                                  // s1.getMark()
    }
}