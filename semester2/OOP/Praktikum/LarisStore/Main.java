package OOP.Praktikum.LarisStore;

import java.util.Scanner;

public class Main {

    // Pembuatan akun
    static Akun akunSilver1 = new Akun("Nathan", "1234", 100_000_000, Akun.Member.SILVER);
    static Akun akunSilver2 = new Akun("Reno", "4567", 10_000_000, Akun.Member.SILVER);
    static Akun akunSilver3 = new Akun("Wewe", "7890", 1_000_000, Akun.Member.SILVER);
    static Akun akunSilver4 = new Akun("Komang", "0123", 100_000, Akun.Member.SILVER);
    static Akun akunSilver5 = new Akun("Jason", "3456", 10_000, Akun.Member.SILVER);
    static Akun akunGold1 = new Akun("Nathan", "1234", 100_000_000, Akun.Member.GOLD);
    static Akun akunGold2 = new Akun("Reno", "4567", 10_000_000, Akun.Member.GOLD);
    static Akun akunGold3 = new Akun("Wewe", "7890", 1_000_000, Akun.Member.GOLD);
    static Akun akunGold4 = new Akun("Komang", "0123", 100_000, Akun.Member.GOLD);
    static Akun akunGold5 = new Akun("Jason", "3456", 10_000, Akun.Member.GOLD);
    static Akun akunPlatinum1 = new Akun("Nathan", "1234", 100_000_000, Akun.Member.PLATINUM);
    static Akun akunPlatinum2 = new Akun("Reno", "4567", 10_000_000, Akun.Member.PLATINUM);
    static Akun akunPlatinum3 = new Akun("Wewe", "7890", 1_000_000, Akun.Member.PLATINUM);
    static Akun akunPlatinum4 = new Akun("Komang", "0123", 100_000, Akun.Member.PLATINUM);
    static Akun akunPlatinum5 = new Akun("Jason", "3456", 10_000, Akun.Member.PLATINUM);

    enum Member {
        SILVER, GOLD, PLATINUM
    }

    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        boolean isRunning = true;
        int akun = 0;

        while (isRunning) {
            System.out.println("-".repeat(50));
            System.out.println(" ".repeat(17) + "DEMO Laris Store" + " ".repeat(18));
            System.out.println("-".repeat(50));
            System.out.println();
            System.out.println("1. Pengguna Silver");
            System.out.println("2. Pengguna Gold");
            System.out.println("3. Pengguna Platinum");
            System.out.println("4. Keluar");
            System.out.println();
            System.out.println("Ketik 1, 2, 3, atau 4");
            System.out.print("-> ");
            int pilih = than.nextInt();
            than.nextLine();
            System.out.println();
            System.out.println("-".repeat(50));
            switch (pilih) {
                case 1:
                    System.out.println("Pilih Pengguna Silver: ");
                    System.out.println("1. Nathan");
                    System.out.println("2. Reno");
                    System.out.println("3. Wewe");
                    System.out.println("4. Komang");
                    System.out.println("5. Jason");
                    System.out.println();
                    System.out.println("Ketik 1, 2, 3, 4, atau 5");
                    System.out.print("-> ");
                    akun = than.nextInt();
                    than.nextLine();

                    break;
                case 2:
                    System.out.println("Pilih Pengguna Gold: ");
                    System.out.println("1. Nathan");
                    System.out.println("2. Reno");
                    System.out.println("3. Wewe");
                    System.out.println("4. Komang");
                    System.out.println("5. Jason");
                    System.out.println();
                    System.out.println("Ketik 1, 2, 3, 4, atau 5");
                    System.out.print("-> ");
                    akun = than.nextInt();
                    than.nextLine();

                    break;
                case 3:
                    System.out.println("Pilih Pengguna Platinum: ");
                    System.out.println("1. Nathan");
                    System.out.println("2. Reno");
                    System.out.println("3. Wewe");
                    System.out.println("4. Komang");
                    System.out.println("5. Jason");
                    System.out.println();
                    System.out.println("Ketik 1, 2, 3, 4, atau 5");
                    System.out.print("-> ");
                    akun = than.nextInt();
                    than.nextLine();

                    break;
                case 4:
                    isRunning = false;
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }

            while (true) {
                showAkun(pilih, akun);
                System.out.println("-".repeat(50));
                System.out.println();
                System.out.println("1. Beli");
                System.out.println("2. Top Up");
                System.out.println("3. Keluar");
                System.out.println();
                System.out.println("Ketik 1, 2, atau 3");
                System.out.print("-> ");
                int pilih2 = than.nextInt();
                than.nextLine();

                switch (pilih2) {
                    case 1:
                        System.out.println();
                        System.out.println("1. Barang 1m");
                        System.out.println("2. Barang 1jt");
                        System.out.println("3. Barang 10rb");
                        System.out.println("4. Barang 1rb");
                        System.out.println("Ketik 1, 2, 3, atau 4");
                        System.out.print("-> ");
                        int pilih3 = than.nextInt();
                        than.nextLine();
                        System.out.println("-".repeat(50));
                        if (beli(pilih, akun, pilih3))
                            ;
                        else
                            return;

                        break;
                    case 2:
                        System.out.println("Masukkan nominal top up: ");
                        System.out.print("-> ");
                        double jumlah = than.nextDouble();
                        than.nextLine();
                        topUp(pilih, akun, jumlah);

                        break;
                    case 3:
                        return;
                    default:
                        break;
                }
            }

        }
    }

    static void topUp(int pilih, int akun, double jumlah) {
        switch (pilih) {
            case 1:
                switch (akun) {
                    case 1:
                        akunSilver1.topUp(jumlah);
                        break;
                    case 2:
                        akunSilver2.topUp(jumlah);
                        break;
                    case 3:
                        akunSilver3.topUp(jumlah);
                        break;
                    case 4:
                        akunSilver4.topUp(jumlah);
                        break;
                    case 5:
                        akunSilver5.topUp(jumlah);
                        break;

                }
                break;
            case 2:
                switch (akun) {
                    case 1:
                        akunGold1.topUp(jumlah);
                        break;
                    case 2:
                        akunGold2.topUp(jumlah);
                        break;
                    case 3:
                        akunGold3.topUp(jumlah);
                        break;
                    case 4:
                        akunGold4.topUp(jumlah);
                        break;
                    case 5:
                        akunGold5.topUp(jumlah);
                        break;

                }
                break;
            case 3:
                switch (akun) {
                    case 1:
                        akunPlatinum1.topUp(jumlah);
                        break;
                    case 2:
                        akunPlatinum2.topUp(jumlah);
                        break;
                    case 3:
                        akunPlatinum3.topUp(jumlah);
                        break;
                    case 4:
                        akunPlatinum4.topUp(jumlah);
                        break;
                    case 5:
                        akunPlatinum5.topUp(jumlah);
                        break;

                }
                break;

        }
    }

    static boolean beli(int pilih, int akun, int barang) {
        switch (pilih) {
            case 1:
                switch (akun) {
                    case 1:
                        if (authenticate(akunSilver1.getID(), akunSilver1.getPin(), akunSilver1.member)) {
                            akunSilver1.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 2:
                        if (authenticate(akunSilver2.getID(), akunSilver2.getPin(), akunSilver2.member)) {
                            akunSilver2.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 3:
                        if (authenticate(akunSilver3.getID(), akunSilver3.getPin(), akunSilver3.member)) {
                            akunSilver3.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 4:
                        if (authenticate(akunSilver4.getID(), akunSilver4.getPin(), akunSilver4.member)) {
                            akunSilver4.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 5:
                        if (authenticate(akunSilver5.getID(), akunSilver5.getPin(), akunSilver5.member)) {
                            akunSilver5.belanja(barang);
                            return true;
                        } else
                            return false;

                }
                break;
            case 2:
                switch (akun) {
                    case 1:
                        if (authenticate(akunGold1.getID(), akunGold1.getPin(), akunGold1.member)) {
                            akunGold1.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 2:
                        if (authenticate(akunGold2.getID(), akunGold2.getPin(), akunGold2.member)) {
                            akunGold2.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 3:
                        if (authenticate(akunGold3.getID(), akunGold3.getPin(), akunGold3.member)) {
                            akunGold3.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 4:
                        if (authenticate(akunGold4.getID(), akunGold4.getPin(), akunGold4.member)) {
                            akunGold4.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 5:
                        if (authenticate(akunGold5.getID(), akunGold5.getPin(), akunGold5.member)) {
                            akunGold5.belanja(barang);
                            return true;
                        } else
                            return false;

                }
                break;
            case 3:
                switch (akun) {
                    case 1:
                        if (authenticate(akunPlatinum1.getID(), akunPlatinum1.getPin(), akunPlatinum1.member)) {
                            akunPlatinum1.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 2:
                        if (authenticate(akunPlatinum2.getID(), akunPlatinum2.getPin(), akunPlatinum2.member)) {
                            akunPlatinum2.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 3:
                        if (authenticate(akunPlatinum3.getID(), akunPlatinum3.getPin(), akunPlatinum3.member)) {
                            akunPlatinum3.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 4:
                        if (authenticate(akunPlatinum4.getID(), akunPlatinum4.getPin(), akunPlatinum4.member)) {
                            akunPlatinum4.belanja(barang);
                            return true;
                        } else
                            return false;

                    case 5:
                        if (authenticate(akunPlatinum5.getID(), akunPlatinum5.getPin(), akunPlatinum5.member)) {
                            akunPlatinum5.belanja(barang);
                            return true;
                        } else
                            return false;

                }
                break;

        }
        return false;

    }

    static void showAkun(int pilih, int akun) {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Akun anda ");
        System.out.println("-".repeat(50));
        switch (pilih) {
            case 1:
                switch (akun) {
                    case 1:
                        akunSilver1.show();
                        break;
                    case 2:
                        akunSilver2.show();
                        break;
                    case 3:
                        akunSilver3.show();
                        break;
                    case 4:
                        akunSilver4.show();
                        break;
                    case 5:
                        akunSilver5.show();
                        break;

                }
                break;
            case 2:
                switch (akun) {
                    case 1:
                        akunGold1.show();
                        break;
                    case 2:
                        akunGold2.show();
                        break;
                    case 3:
                        akunGold3.show();
                        break;
                    case 4:
                        akunGold4.show();
                        break;
                    case 5:
                        akunGold5.show();
                        break;

                }
                break;
            case 3:
                switch (akun) {
                    case 1:
                        akunPlatinum1.show();
                        break;
                    case 2:
                        akunPlatinum2.show();
                        break;
                    case 3:
                        akunPlatinum3.show();
                        break;
                    case 4:
                        akunPlatinum4.show();
                        break;
                    case 5:
                        akunPlatinum5.show();
                        break;

                }
                break;

        }
    }

    static boolean authenticate(String ID, String PIN, Akun.Member member) {
        Scanner than = new Scanner(System.in);
        int attempts = 0;

        while (attempts < 3) {
            System.out.println("Konfirmasi pembayaran");
            System.out.print("ID: ");
            String id = than.nextLine();

            System.out.print("PIN: ");
            String pin = than.nextLine();

            switch (member) {
                case SILVER:
                    if (id.equals("426" + ID) && pin.equals(PIN)) {
                        System.out.println("Autentifikasi berhasil!");
                        return true;
                    } else {
                        System.out.println("Autentifikasi gagal. Silahkan coba lagi.\n");
                        attempts++;
                    }

                    break;
                case GOLD:
                    if (id.equals("591" + ID) && pin.equals(PIN)) {
                        System.out.println("Autentifikasi berhasil!");
                        return true;
                    } else {
                        System.out.println("Autentifikasi gagal. Silahkan coba lagi.\n");
                        attempts++;
                    }

                    break;
                case PLATINUM:
                    if (id.equals("772" + ID) && pin.equals(PIN)) {
                        System.out.println("Autentifikasi berhasil!");
                        return true;
                    } else {
                        System.out.println("Autentifikasi gagal. Silahkan coba lagi.\n");
                        attempts++;
                    }

                    break;

                default:
                    break;
            }

        }

        System.out.println("Akun diblokir. Silahkan hubungi customer support.");
        return false;
    }
}
