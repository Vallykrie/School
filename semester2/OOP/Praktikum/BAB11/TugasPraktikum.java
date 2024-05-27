package BAB11;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TugasPraktikum {
    public static void main(String[] args) {
        java.util.Scanner than = new java.util.Scanner(System.in);
        String input = than.nextLine().toLowerCase();
        StringTokenizer st = new StringTokenizer(input, " .,;?!");
        System.out.println("-".repeat(50));
        System.out
                .println(" ".repeat(10) + "Token" + " ".repeat(10) + "|" + " ".repeat(8) + "Frekuensi" + " ".repeat(8));
        System.out.println("-".repeat(50));

        Map<String, Integer> frequencyMap = new HashMap<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            frequencyMap.put(token, frequencyMap.getOrDefault(token, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.printf("%-25s|%10d\n", entry.getKey(), entry.getValue());
        }
    }
}
