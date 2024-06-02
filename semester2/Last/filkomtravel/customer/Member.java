package customer;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Represents a member of the system.
 * Extends the Guest class and adds additional member-specific functionality.
 */
/**
 * Represents a member of the system.
 * Extends the Guest class.
 */
public class Member extends Guest {
    
    private String nama;
    private Date tanggalDaftar;

    public Member(String id, String nama, String tanggalDaftar, String saldoAwal) throws ParseException {
        super(id, saldoAwal);
        SimpleDateFormat diFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.nama = nama;
        this.tanggalDaftar =  diFormat.parse(tanggalDaftar);
    }

    public String getNama() {
        return nama;
    }

    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }


}
