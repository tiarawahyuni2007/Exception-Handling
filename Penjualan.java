import java.util.InputMismatchException;
import java.util.Scanner;

public class Penjualan extends Transaksi { // bentuk inheritence
    private long hargaBarang;
    private int jumlahBeli;
    
    public Penjualan(int noFaktur, String namaPelanggan, String namaBarang, long hargaBarang, int jumlahBeli){
        super(noFaktur, namaPelanggan, namaBarang);
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }

    public long hitungTotalBayar(long harga, int jumlah){
        return super.hitungTotalBayar(harga, jumlah);
    }

    public long getTotalbayar(){
        return hitungTotalBayar(hargaBarang,jumlahBeli);
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // bentuk handling exception
        try{
            System.out.print("Masukkan nomor faktur: ");
            int noFaktur = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Masukkan nama pelanggan: ");
            String namaPelanggan = scanner.nextLine();

            System.out.print("Masukkan nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan harga barang: ");
            long hargaBarang = scanner.nextLong(); 

            System.out.print("Masukkan jumlah beli: ");
            int jumlahBeli = scanner.nextInt();

            Penjualan transaksi = new Penjualan(noFaktur, namaPelanggan, namaBarang, hargaBarang, jumlahBeli);
            long totalBayar = transaksi.hitungTotalBayar(hargaBarang, jumlahBeli); // bentuk polymorphisme
            System.out.println("Total bayar: " + totalBayar);

        } catch (InputMismatchException e){ // bentuk exception
            System.out.println("Input tidak valid. Pastikan input data sesuai dengan tipe data yang benar.");
        } finally {
            scanner.close(); 
        }
    }
}