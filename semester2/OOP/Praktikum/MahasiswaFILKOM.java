package OOP.Praktikum;

public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    MahasiswaFILKOM() {
    }

    MahasiswaFILKOM(String nama, String nik, boolean jenisKelamin, boolean isMenikah, String nim, double ipk) {
        super(nama, nik, jenisKelamin, isMenikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    // setters and getters
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2);
        String prodi;
        switch (nim.charAt(6)) {
            case '2':
                prodi = "Teknik Informatika";
                break;
            case '3':
                prodi = "Teknik Komputer";
                break;
            case '4':
                prodi = "Sistem Informasi";
                break;
            case '6':
                prodi = "Pendidikan Teknologi Informasi";
                break;
            case '7':
                prodi = "Teknologi Informasi";
                break;
            default:
                prodi = "Unknown";
        }
        return prodi + ", " + angkatan;
    }

    public double getBeasiswa() {
        if (ipk >= 3.5) {
            return 75;
        } else if (ipk >= 3.0) {
            return 50;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nNIM\t\t: " + nim + "\nIPK\t\t: " + ipk + "\nStatus\t\t: " + getStatus();
    }
}
