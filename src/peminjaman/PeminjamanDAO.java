package peminjaman;

import java.util.List;
import javax.swing.JTable;
import sepeda.Sepeda;

public interface PeminjamanDAO {

    public List<Sepeda> loadSepeda();

    public void read(JTable table);

    public void delete(int id);
}
