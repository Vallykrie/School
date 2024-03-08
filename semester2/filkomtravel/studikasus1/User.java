package filkomtravel.studikasus1;
import java.util.LinkedList;

public class User {
    private String username, password, email, namaLengkap;
    private String status = "non-member";
    private boolean isMember = false;

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
        System.out.println("Nama Lengkap\t: " + namaLengkap);
        System.out.println("Username\t: " + username);
        System.out.println("Email\t\t: " + email);
        System.out.println("Status\t\t: " + status);
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

    public String getStatus() {
        return status;
    }

    public boolean isMember() {
        return isMember;
    }



}
