package peminjaman;

import java.util.List;
import javax.swing.JTable;
import sepeda.Sepeda;

public interface PeminjamanDAO {

    public List<Sepeda> loadSepeda();

    public void read(JTable table);

    public void create(Peminjaman peminjaman, int id);

    public void hitungJumlah(int lamaPinjam, int harga);

    public void cekStatus(String nama);

    public boolean jikaKeluar(String nama);

    public void delete(int id);

    public void search(JTable jt, String key);
}
