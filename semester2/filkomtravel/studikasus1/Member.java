package filkomtravel.studikasus1;

public class Member extends User{
    private String tanggalLahir;
    
    public Member(String username, String password, String email, String namaLengkap) {
        super(username, password, email, namaLengkap);
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    @Override
    public void viewProfile() {
        System.out.println("Nama Lengkap: " + getNamaLengkap());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
        System.out.println("Email: " + getEmail());
        System.out.println("Tanggal Lahir: " + getTanggalLahir());
    }
}
