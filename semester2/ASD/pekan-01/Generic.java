/*
 * Generics means parameterized types.
 * The idea is to allow data type (Integer, String, … etc., and user-defined types) to be a parameter to methods, classes, and interfaces.
 * Using Generics, it is possible to create classes that work with different data types.
 * 
 * Type Parameter Naming Conventions
 * By convention, type parameter names are single, uppercase letters.
 * This stands in sharp contrast to the variable naming conventions that you already know about,and with good reason:
 * Without this convention, it would be difficult to tell the difference between a type variable and an ordinary class or interface name.
 * 
 * The most commonly used type parameter names are:
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * S,U,V etc. - 2nd, 3rd, 4th types
 * 
 * Ref:
 * https://www.geeksforgeeks.org/generics-in-java/
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html
 */

public class Generic {

    /*
     * A generic method is a method that introduce their own type parameters.
     * This is similar to declaring a generic type, but the type parameter's scope
     * is limited to the method where it is declared.
     */
    static <T> void print(T input) {
        System.out.println(input);
    }

    public static void main(String[] args) {
        print("Hello");
        print(2_147_483_647);
        print(9_223_372_036_854_775_807L);
        print(0.1234567890123456d);

        System.out.println();

        Message<String> messageStr = new Message<>();
        messageStr.print("Hello");

        Message<Integer> messageInt = new Message<>();
        messageInt.print(2_147_483_647);

        Message<Long> messageLong = new Message<>();
        messageLong.print(9_223_372_036_854_775_807L);

        Message<Double> messageDouble = new Message<>();
        messageDouble.print(0.1234567890123456d);
    }
}

/*
 * A generic type is a generic class or interface that is parameterized over types.
 */
class Message<T> {
    public void print(T input) {
        System.out.println(input);
    }
}