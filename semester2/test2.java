import java.util.Scanner;

class Mineral {
    String nama;
    String jenis;
    int jumlah;

    public Mineral(String nama, String jenis, int jumlah) {
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getJumlah() {
        return jumlah;
    }
}

class Pekerja {
    int id;
    String nama;
    String jabatan;
    String spesialisasi;

    public Pekerja(int id, String nama, String jabatan, String spesialisasi) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.spesialisasi = spesialisasi;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }
}

class Peralatan {
    int id;
    String nama;
    String jenis;

    public Peralatan(int id, String nama, String jenis) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }
}

class SystemManagement {
    Mineral[] minerals;
    Pekerja[] pekerja;
    Peralatan[] peralatan;
    int capacityMineral;
    int capacityPekerja;
    int capacityPeralatan;
    int mineralCount = 0;
    int pekerjaCount = 0;
    int peralatanCount = 0;

    public void setSystemCapacity(int capacityMineral, int capacityPekerja, int capacityPeralatan) {
        this.capacityMineral = capacityMineral;
        this.capacityPekerja = capacityPekerja;
        this.capacityPeralatan = capacityPeralatan;
        minerals = new Mineral[capacityMineral];
        pekerja = new Pekerja[capacityPekerja];
        peralatan = new Peralatan[capacityPeralatan];
        System.out.println("Kapasitas mineral berhasil ditentukan!");
        System.out.println("Kapasitas pekerja berhasil ditentukan!");
        System.out.println("Kapasitas peralatan berhasil ditentukan!");
    }

    public void setSystemCapacityMineral(int capacityMineral) {
        this.capacityMineral = capacityMineral;
        minerals = new Mineral[capacityMineral];
        System.out.println("Kapasitas mineral berhasil ditentukan!");
    }

    public void setSystemCapacityPekerja(int capacityPekerja) {
        this.capacityPekerja = capacityPekerja;
        pekerja = new Pekerja[capacityPekerja];
        System.out.println("Kapasitas pekerja berhasil ditentukan!");
    }

    public void setSystemCapacityPeralatan(int capacityPeralatan) {
        this.capacityPeralatan = capacityPeralatan;
        peralatan = new Peralatan[capacityPeralatan];
        System.out.println("Kapasitas peralatan berhasil ditentukan!");
    }

    public void addMineral(String nama, String jenis, int jumlah) {
        if (mineralCount < capacityMineral) {
            minerals[mineralCount++] = new Mineral(nama, jenis, jumlah);
            System.out.println("Mineral berhasil ditambahkan!");
        } else {
            System.out.println("Kapasitas penyimpanan mineral penuh!");
        }
    }

    public void addPekerja(int id, String nama, String jabatan, String spesialisasi) {
        if (pekerjaCount < capacityPekerja) {
            pekerja[pekerjaCount++] = new Pekerja(id, nama, jabatan, spesialisasi);
            System.out.println("Pekerja berhasil ditambahkan!");
        } else {
            System.out.println("Kapasitas penyimpanan pekerja penuh!");
        }
    }

    public void addPeralatan(int id, String nama, String jenis) {
        if (peralatanCount < capacityPeralatan) {
            peralatan[peralatanCount++] = new Peralatan(id, nama, jenis);
            System.out.println("Peralatan berhasil ditambahkan!");
        } else {
            System.out.println("Kapasitas penyimpanan peralatan penuh!");
        }
    }

    public void displayAll() {
        if (minerals == null && pekerja == null && peralatan == null) {
            System.out.println("Tolong tentukan kapasitas sistem dan isi data terlebih dahulu!");
            return;
        }

        if (mineralCount == 0 && pekerjaCount == 0 && peralatanCount == 0) {
            System.out.println("Tidak ada data yang tersimpan.");
            return;
        }

        System.out.println("Mineral:");
        for (int i = 0; i < mineralCount; i++) {
            System.out.println((i + 1) + ". Nama: " + minerals[i].getNama() + ", Jenis: " + minerals[i].getJenis()
                    + ", Jumlah: " + minerals[i].getJumlah());
        }

        System.out.println("Pekerja:");
        for (int i = 0; i < pekerjaCount; i++) {
            System.out.print((i + 1) + ". ID: " + pekerja[i].getId() + ", Nama: " + pekerja[i].getNama() + ", Jabatan: "
                    + pekerja[i].getJabatan());
            if (pekerja[i].getJabatan().equals("Teknisi")) {
                System.out.println(", Spesialis: " + pekerja[i].getSpesialisasi());
            } else {
                System.out.println();
            }
        }

        System.out.println("Peralatan:");
        for (int i = 0; i < peralatanCount; i++) {
            System.out.println((i + 1) + ". ID: " + peralatan[i].getId() + ", Nama: " + peralatan[i].getNama()
                    + ", Jenis: " + peralatan[i].getJenis());
        }
    }
}

public class test2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        SystemManagement systemManagement = new SystemManagement();

        int choice;
        do {
            choice = than.nextInt();
            if (than.hasNextLine()) {
                than.nextLine();
            }
            switch (choice) {
                case 1:
                    boolean pilih1 = true;
                    while (pilih1) {
                        int pilih = than.nextInt();
                        if (than.hasNextLine()) {
                            than.nextLine();
                        }
                        switch (pilih) {
                            case 1:
                                int capacityMineral = than.nextInt();
                                if (than.hasNextLine()) {
                                    than.nextLine();
                                }
                                systemManagement.setSystemCapacityMineral(capacityMineral);

                                break;
                            case 2:
                                int capacityPekerja = than.nextInt();
                                if (than.hasNextLine()) {
                                    than.nextLine();
                                }
                                systemManagement.setSystemCapacityPekerja(capacityPekerja);
                                break;
                            case 3:
                                int capacityPeralatan = than.nextInt();
                                if (than.hasNextLine()) {
                                    than.nextLine();
                                }
                                systemManagement.setSystemCapacityPeralatan(capacityPeralatan);
                                break;
                            case 4:
                                pilih1 = false;
                                break;
                            case 5:
                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                                break;

                            default:
                                break;
                        }

                    }
                    break;
                case 2:
                    if (systemManagement.capacityMineral == 0) {
                        System.out.println("Tolong tentukan kapasitas sistem terlebih dahulu!");
                    } else if (systemManagement.mineralCount < systemManagement.capacityMineral) {
                        String mineralName = than.nextLine();
                        String mineralType = than.nextLine();
                        int mineralQuantity = than.nextInt();
                        if (than.hasNextLine()) {
                            than.nextLine();
                        }
                        systemManagement.addMineral(mineralName, mineralType, mineralQuantity);
                    } else {
                        System.out.println("Kapasitas penyimpanan mineral penuh!");
                    }
                    break;
                case 3:
                    if (systemManagement.capacityPekerja == 0) {
                        System.out.println("Tolong tentukan kapasitas sistem terlebih dahulu!");
                    } else if (systemManagement.pekerjaCount < systemManagement.capacityPekerja) {
                        int id = than.nextInt();
                        than.nextLine();
                        String name = than.nextLine();
                        int job = than.nextInt();
                        than.nextLine();
                        String jobTitle = "";
                        String specialization = "";
                        if (job == 1) {
                            jobTitle = "Teknisi";
                            specialization = than.nextLine();
                        } else if (job == 2) {
                            jobTitle = "Operator";
                        }
                        systemManagement.addPekerja(id, name, jobTitle, specialization);
                    } else {
                        System.out.println("Kapasitas penyimpanan pekerja penuh!");
                    }
                    break;
                case 4:
                    if (systemManagement.capacityPeralatan == 0) {
                        System.out.println("Tolong tentukan kapasitas sistem terlebih dahulu!");
                    } else if (systemManagement.peralatanCount < systemManagement.capacityPeralatan) {
                        int equipmentId = than.nextInt();
                        than.nextLine();
                        String equipmentName = than.nextLine();
                        String equipmentType = than.nextLine();
                        systemManagement.addPeralatan(equipmentId, equipmentName, equipmentType);
                    } else {
                        System.out.println("Kapasitas penyimpanan peralatan penuh!");
                    }
                    break;
                case 5:
                    systemManagement.displayAll();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 6);
    }
}
