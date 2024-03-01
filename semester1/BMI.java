import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {

        // INPUT
        System.out.println("BMI Calculator");
        Scanner than = new Scanner(System.in);
        System.out.printf("%-24s: ", "Input your weight (kg)");
        double weight = than.nextDouble();
        System.out.printf("%-24s: ", "Input your height (m)");
        double height = than.nextDouble();
        String weightClass = " ";

        // Calculation
        double BMI = weight / (height * height);
        if (BMI <= 18.5) {
            weightClass = "Underweight";
        } else if (BMI <= 25) {
            weightClass = "Normal";
        } else if (BMI <= 30) {
            weightClass = "Overweight";
        } else if (BMI > 30) {
            weightClass = "Very Overweight";
        }

        // OUTPUT
        System.out.printf("%s = %.2f %15s\n", "BMI", BMI, "(" + weightClass + ")");
        System.out.println("-".repeat(30));
        than.close();
    }
}
