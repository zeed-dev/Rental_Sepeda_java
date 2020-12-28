package pengembalian;

import java.util.List;
import javax.swing.JTable;
import sepeda.Sepeda;

public interface PengembalianDAO {

    public List<Sepeda> loadSepeda();

    public void read(JTable table);

    public void cekStatus(String nama);

    public void hapusPeminjaman(int id);

    public void search(JTable jt, String key);
}
