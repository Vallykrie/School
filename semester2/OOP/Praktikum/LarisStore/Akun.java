package OOP.Praktikum.LarisStore;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Akun {
    private String nama, pin;
    private static int count = 0;
    private int ID;
    private double saldo;
    Member member;

    enum Member {
        SILVER, GOLD, PLATINUM
    }

    public Akun(String nama, String pin, double saldo, Member member) {
        count++;
        this.nama = nama;
        this.pin = pin;
        this.saldo = saldo;
        this.ID = count;
        this.member = member;
    }

    public void show() {
        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);

        System.out.println("Nama\t: " + nama);
        switch (member) {
            case SILVER:
                System.out.println("ID\t: 426" + getID());

                break;
            case GOLD:
                System.out.println("ID\t: 591" + getID());

                break;
            case PLATINUM:
                System.out.println("ID\t: 772" + getID());

                break;
        }
        System.out.println("Saldo\t: " + df.format(saldo));
        System.out.println("Member\t: " + member);
    }

    public String getID() {
        String id = String.format("%09d", ID);
        return id;
    }

    public String getPin() {
        return pin;
    }

    public void topUp(double saldo) {
        this.saldo += saldo;
    }

    public void belanja(int pilih) {
        if (saldo < 20000) {
            System.err.println("GAGAL!\nSaldo anda kurang dari Rp 20.000\nSilahkan top up saldo anda terlebih dahulu!");
        } else {
            double discount = 1;
            double cashback = 0;
            switch (member) {
                case SILVER:
                    discount = 0.97;
                    break;
                case GOLD:
                    discount = 0.95;
                    cashback = 0.02;
                    break;
                case PLATINUM:
                    discount = 0.93;
                    cashback = 0.03;
                    break;
                default:
                    break;
            }
            switch (pilih) {
                case 1:
                    if (saldo < 1_000_000_000) {
                        System.err.println("GAGAL!\nSaldo anda kurang");
                    } else {
                        this.saldo -= (1_000_000_000 * discount) + (1_000_000_000 * cashback);
                        System.out.println("Berhasil!\nTerimakasih telah berbelanja di Laris Store!");

                    }
                    break;
                case 2:
                    if (saldo < 1_000_000) {
                        System.err.println("GAGAL!\nSaldo anda kurang");
                    } else {
                        this.saldo -= 1_000_000;
                        System.out.println("Berhasil!\nTerimakasih telah berbelanja di Laris Store!");

                    }
                    break;
                case 3:
                    if (saldo < 10_000) {
                        System.err.println("GAGAL!\nSaldo anda kurang");
                    } else {
                        this.saldo -= 10_000;
                        System.out.println("Berhasil!\nTerimakasih telah berbelanja di Laris Store!");

                    }
                    break;
                case 4:
                    if (saldo < 1_000) {
                        System.err.println("GAGAL!\nSaldo anda kurang");
                    } else {
                        this.saldo -= 1_000;
                        System.out.println("Berhasil!\nTerimakasih telah berbelanja di Laris Store!");

                    }
                    break;
            }

        }
    }
}
