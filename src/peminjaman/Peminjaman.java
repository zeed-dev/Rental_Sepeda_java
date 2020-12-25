package peminjaman;

import sepeda.Sepeda;

public class Peminjaman {

    // relasi
    private Sepeda sepeda;

    private String nama_peminjam;
    private String nik;
    private int harga_total;
    private int lama_pinjam;

    public Sepeda getSepeda() {
        return sepeda;
    }

    public void setSepeda(Sepeda sepeda) {
        this.sepeda = sepeda;
    }

    public String getNama_peminjam() {
        return nama_peminjam;
    }

    public void setNama_peminjam(String nama_peminjam) {
        this.nama_peminjam = nama_peminjam;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public int getHarga_total() {
        return harga_total;
    }

    public void setHarga_total(int harga_total) {
        this.harga_total = harga_total;
    }

    public int getLama_pinjam() {
        return lama_pinjam;
    }

    public void setLama_pinjam(int lama_pinjam) {
        this.lama_pinjam = lama_pinjam;
    }
    
    

}
