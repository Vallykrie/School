public class Laprak {
    /**
     * Mahasiswa A ingin menulis pada sebuah buku tulis yang ingin dia miliki, 
     * isi lembar buku tersebut adalah 50 lembar. 
     * Setiap harinya ia menulis sebanyak 100 kata perhari yang cukup untuk 1/2 halaman buku. 
     * Buatlah rumus untuk menghitung berapa lama ia menghabiskan 1 buku tersebut serta identifikasilah objek, 
     * dan karakteristiknya kemudian implementasikan dalam bentuk class.
     */
    
    private int lembarBuku = 50;
    private int kataPerHari = 100;
    private double menulisPerHari = 0.5;

    public void lamaMenghabiskanBuku(){
        double waktuMenghabiskanBuku = lembarBuku/menulisPerHari;
        double totalKata = waktuMenghabiskanBuku*kataPerHari;
        System.out.println("Waktu yang dibutuhkan untuk menghabiskan buku adalah " + waktuMenghabiskanBuku + " hari");
        System.out.println("Total kata yang ditulis adalah " + totalKata + " kata");
    }

}
