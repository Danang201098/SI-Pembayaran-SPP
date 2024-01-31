import java.util.ArrayList;
import java.util.List;

public class Siswa {
    private String nama;
    private String NIS;
    private List<MataKuliah> mataKuliahList;
    private double totalBiayaDibayar;

    // Constructor
    public Siswa(String nama, String NIS) {
        this.nama = nama;
        this.NIS = NIS;
        this.mataKuliahList = new ArrayList<>();
        this.totalBiayaDibayar = 0;
    }

    // Method untuk menghitung total biaya SPP berdasarkan jumlah SKS
    public double hitungTotalBiaya() {
        int totalSKS = hitungTotalSKS();
        double biayaPerSKS = 200000;
        return totalSKS * biayaPerSKS;
    }

    // Method untuk membayar biaya
    public void bayarBiaya(double nominalPembayaran) {
        totalBiayaDibayar += nominalPembayaran;
    }

    // Method mencetak bukti pembayaran
    public void cetakBuktiPembayaran(double nominalPembayaran) {
        System.out.println("===== BUKTI PEMBAYARAN SPP =====");
        displayInfo();
        System.out.println("Total SKS yang diambil: " + hitungTotalSKS());
        double totalBiaya = hitungTotalBiaya();
        System.out.println("Total Biaya SPP: " + totalBiaya);
        System.out.println("Total Biaya yang Telah Dibayar: " + nominalPembayaran);
        System.out.println();
        System.out.println("===========Terimaksih==========");
        System.out.println("===============================");
    }


    public void ambilMataKuliah(MataKuliah mataKuliah) {
        mataKuliahList.add(mataKuliah);
    }

    public int hitungTotalSKS() {
        int totalSKS = 0;
        for (MataKuliah mataKuliah : mataKuliahList) {
            totalSKS += mataKuliah.getSks();
        }
        return totalSKS;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIS: " + NIS);
    }
}
