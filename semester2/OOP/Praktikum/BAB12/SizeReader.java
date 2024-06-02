import java.io.File;

public class SizeReader {
    public static void main(String[] args) {
        File file = new File("test.txt");

        long fileSize = file.length();
        double fileSizeKB = (double) fileSize / 1024;

        if (fileSizeKB < 1024) {
            System.out.println("Ukuran file: " + fileSizeKB + " KB");
        } else {
            double fileSizeMB = fileSizeKB / 1024;
            System.out.println("Ukuran file: " + fileSizeMB + " MB");
        }
    }
}
