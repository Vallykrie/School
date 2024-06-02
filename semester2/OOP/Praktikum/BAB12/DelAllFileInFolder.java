import java.io.File;

public class DelAllFileInFolder {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\magnu\\OneDrive\\Documents\\VSCode\\hackerrank"; // Ganti dengan path direktori
                                                                                         // yang ingin dihapus

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }

            folder.delete();
            System.out.println("Direktori dan semua file di dalamnya berhasil dihapus.");
        } else {
            System.out.println("Direktori tidak ditemukan atau bukan direktori.");
        }
    }
}