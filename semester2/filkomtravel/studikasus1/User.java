package filkomtravel.studikasus1;
import java.util.LinkedList;

public class User {
    private String username, password, email, namaLengkap;

    public User(String username, String password, String email, String namaLengkap) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.namaLengkap = namaLengkap;
    }

    public static boolean login(String username, String password, LinkedList<User> userList) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static int get (String username, LinkedList<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public void editProfile(String username, String password, String email, String namaLengkap) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.namaLengkap = namaLengkap;
        System.out.println("Edit profile berhasil");
    }

    public void deleteProfile() {
        this.username = null;
        this.password = null;
        this.email = null;
        this.namaLengkap = null;
        System.out.println("Delete profile berhasil");
    }

    public void viewProfile() {
        System.out.println("Nama Lengkap: " + namaLengkap);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void logout() {
        System.out.println("Logout berhasil");
    }    

}
