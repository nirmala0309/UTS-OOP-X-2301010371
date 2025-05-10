package UTS;

/**
 *
 * @author Eufemia Kristiani Sanratu Nirmala
 * NIM: 2301010371
 * Tgl 7/05/2025
 */
import java.util.Scanner;

public class AplikasiMatakuliah {
    private static Matakuliah[] matakuliahArray = new Matakuliah[10];
    private static int arrayIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Aplikasi Pencatatan Matakuliah");
            System.out.println("==============================");
            
            System.out.println("Menu:");
            System.out.println("1. Input Data Matakuliah");
            System.out.println("2. Menampilkan Data Matakuliah");
            System.out.println("3. Mengubah Data Matakuliah");
            System.out.println("4. Menghapus Data Matakuliah");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputDataMatakuliah(scanner);
                    break;
                case 2:
                    menampilkanData();
                    break;
                case 3:
                    mengubahData(scanner);
                    break;
                case 4:
                    menghapusData(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }
        }
    }

    private static void inputDataMatakuliah(Scanner scanner) {
        System.out.print("Masukkan kode matakuliah: ");
        String kode = scanner.next();
        System.out.print("Masukkan nama matakuliah: ");
        String nama = scanner.next();

        Matakuliah matakuliah = new Matakuliah(kode, nama);
        matakuliahArray[arrayIndex] = matakuliah;
        arrayIndex++;

        System.out.println("Data berhasil disimpan");
    }

    private static void menampilkanData() {
        for (int i = 0; i < arrayIndex; i++) {
            Matakuliah matakuliah = matakuliahArray[i];
            System.out.println("Kode matakuliah: " + matakuliah.getKode() + ", Nama matakuliah: " + matakuliah.getNama());
        }
    }

    private static void mengubahData(Scanner scanner) {
        System.out.print("Masukkan kode matakuliah yang ingin diubah: ");
        String kode = scanner.next();

        for (int i = 0; i < arrayIndex; i++) {
            Matakuliah matakuliah = matakuliahArray[i];
            if (matakuliah.getKode().equals(kode)) {
                System.out.print("Masukkan nama matakuliah baru: ");
                String nama = scanner.next();
                matakuliah.setNama(nama);
                System.out.println("Data matakuliah berhasil diubah");
                return;
            }
        }

        System.out.println("Data tidak ditemukan");
    }

    private static void menghapusData(Scanner scanner) {
        System.out.print("Masukkan kode matakuliah yang ingin dihapus: ");
        String kode = scanner.next();

        for (int i = 0; i < arrayIndex; i++) {
            Matakuliah matakuliah = matakuliahArray[i];
            if (matakuliah.getKode().equals(kode)) {
                for (int j = i; j < arrayIndex - 1; j++) {
                    matakuliahArray[j] = matakuliahArray[j + 1];
                }
                arrayIndex--;
                System.out.println("Data matakuliah berhasil dihapus");
                return;
            }
        }

        System.out.println("Data tidak ditemukan");
    }
}