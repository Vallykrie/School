public class DataType {

    public static void main(String[] args){
        /*
         * Primitive data types:
         * It specifies the size and type of variable's values, and it has no additional
         * methods.
         */
        byte byte_dt = 127;                         // 1 byte
        short short_dt = 32_767;                    // 2 bytes
        int int_dt = 2_147_483_647;                 // 4 bytes
        long long_dt = 9_223_372_036_854_775_807L;  // 8 bytes
        float float_dt = 0.12345678f;               // 4 bytes
        double double_dt = 0.1234567890123456d;     // 8 bytes
        boolean boolean_dt = true;                  // 1 bit
        char char_dt = 'C';                         // 2 bytes

        System.out.println(byte_dt);
        System.out.println(short_dt);
        System.out.println(int_dt);
        System.out.println(long_dt);
        System.out.println(float_dt);
        System.out.println(double_dt);
        System.out.println(boolean_dt);
        System.out.println(char_dt);
        System.out.println();

        /*
         * Non-primitive data types:
         * It enable the creation of more complex structures and allow for the
         * organization and manipulation of larger sets of data.
         */
        boolean[] array_dt = new boolean[3];              // Array
        CustomClass class_dt = new CustomClass();         // Class
        CustomInterface interface_dt = new CustomClass(); // Interface
        String string_dt = "String";                      // String
        // etc.

        System.out.println(array_dt);
        System.out.println(class_dt);
        System.out.println(interface_dt);
        System.out.println(string_dt);
        System.out.println(CustomEnum.OPT1);               // Enum
        System.out.println();

        /*
         * Class wrapper
         * A wrapper class provide a way to use primitive data types (int, boolean, etc..) as objects. 
         * It gives programmer more flexibility in converting, storing, and
         * manipulating data in JAVA.
         */
        Byte byte_wr = 127;
        Short short_wr = 32_767;
        Integer int_wr = 2_147_483_647;
        Long long_wr = 9_223_372_036_854_775_807L;
        Float float_wr = 0.12345678f;
        Double double_wr = 0.1234567890123456d;
        Boolean boolean_wr = true;
        Character char_wr = 'C';

        System.out.println(byte_wr);
        System.out.println(short_wr);
        System.out.println(int_wr);
        System.out.println(long_wr);
        System.out.println(float_wr);
        System.out.println(double_wr);
        System.out.println(boolean_wr);
        System.out.println(char_wr);
    }
}

interface CustomInterface {

    
}

class CustomClass implements CustomInterface{

}

enum CustomEnum {
    OPT1,
    OPT2
}