package sepeda;

import javax.swing.JTable;

public interface SepedaDAO {

    public void read(JTable table);

    public void create(Sepeda sepeda);

    public void update(Sepeda sepeda);

    public void delete(int id);

    public void search(JTable jt, String key);

}
