public class FinalValueofVariable {
    public static void main(String[] args) {
        String operations = "X++, ++X, X--";
        int result = 0;
        for (int i = operations.length() - 1; i >= 0; i--) {
            if (operations.charAt(i) == '+')
                result++;
            if (operations.charAt(i) == '-')
                result--;
        }
        result /= 2;
        System.out.println(result);
    }
}
