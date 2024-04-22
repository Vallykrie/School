/**
 * test
 */
public class test {
    static int count;

    test() {
        count++;
    }
}

class Main {
    public static void main(String[] args) {
        test t1 = new test();
        test t2 = new test();
        test t3 = new test();
        System.out.println(test.count);
    }
}