import java.io.File;

public class FileInFolder {
    public static void main(String[] args) {
        String direktori = "C:\\Users\\magnu\\OneDrive\\Documents\\VSCode\\School\\semester1";

        File folder = new File(direktori);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Direktori tidak ditemukan.");
        }
    }
}
