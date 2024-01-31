import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang Di Sistem Informasi Pemabyaran SPP");
        System.out.print("Masukkan Nama Siswa: ");
        String namaSiswa = scanner.nextLine();
        System.out.print("Masukkan NIS Siswa: ");
        String nisSiswa = scanner.nextLine();

        Siswa siswa1 = new Siswa(namaSiswa, nisSiswa);

        System.out.println("Masukkan data mata kuliah yang diambil (selesai dengan menginput 'selesai'):");
        while (true) {
            System.out.print("Nama Mata Kuliah (selesai untuk mengakhiri): ");
            String namaMatkul = scanner.nextLine();
            if (namaMatkul.equals("selesai")) {
                break;
            }

            System.out.print("Jumlah SKS: ");
            int sksMatkul = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            MataKuliah matkul = new MataKuliah(generateKodeMatkul(), namaMatkul, sksMatkul);
            siswa1.ambilMataKuliah(matkul);
        }

        // Menampilkan informasi siswa dan total SKS yang diambil
        siswa1.displayInfo();
        System.out.println("Total SKS yang diambil: " + siswa1.hitungTotalSKS());

        // Menampilkan total biaya SPP
        double totalBiaya = siswa1.hitungTotalBiaya();
        System.out.println("Total Biaya SPP: " + totalBiaya);

        // Meminta input nominal pembayaran dari pengguna
        System.out.print("Masukkan Nominal Pembayaran: ");
        double nominalPembayaran = scanner.nextDouble();

        // Memeriksa apakah nominal pembayaran sesuai
        if (nominalPembayaran >= totalBiaya) {
            double kembalian = nominalPembayaran - totalBiaya;
            System.out.println("Pembayaran berhasil. Kembalian: " + kembalian);
        } else {
            System.out.println("Nominal pembayaran kurang. Silakan bayar sesuai total biaya.");
        }

        // Mencetak bukti pembayaran
        siswa1.cetakBuktiPembayaran(nominalPembayaran);

        // Menutup scanner
        scanner.close();
    }
    private static String generateKodeMatkul() {
        // Implementasi generate kode mata kuliah sesuai kebutuhan
        // Contoh sederhana: menggunakan timestamp
        return Long.toString(System.currentTimeMillis());
    }

}
