package filkomtravel.studikasus1;

public class User {
    private String username, password, email, namaLengkap;

    public User(String username, String password, String email, String namaLengkap) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.namaLengkap = namaLengkap;
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login berhasil");
            return true;
        } else {
            System.out.println("Login gagal");
            return false;
        }
    }

    public void register(String username, String password, String email, String namaLengkap) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.namaLengkap = namaLengkap;
        System.out.println("Register berhasil");
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
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Nama Lengkap: " + namaLengkap);
    }

    

    
}
