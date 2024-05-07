package filkomtravel.studikasus1;

public class Member extends User {
    private String tanggalLahir;
    // private Date date;
    private String status = "member";
    private boolean isMember = true;

    public Member(String username, String password, String email, String namaLengkap) {
        super(username, password, email, namaLengkap);
    }

    @Override
    public void viewProfile() {
        System.out.println("Nama Lengkap\t: " + getNamaLengkap());
        System.out.println("Username\t: " + getUsername());
        System.out.println("Email\t\t: " + getEmail());
        System.out.println("Tanggal Lahir\t: " + getTanggalLahir());
        System.out.println("Status\t\t: " + status);
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}
