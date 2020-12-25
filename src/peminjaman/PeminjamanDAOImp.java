package peminjaman;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import sepeda.Sepeda;

public class PeminjamanDAOImp implements PeminjamanDAO {

    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private Koneksi con = new Koneksi();

    //query sql
    private String read = "select * from tbl_peminjaman";
    private String loadSepeda = "select * from tbl_sepeda";
    private String delete = "delete from tbl_peminjaman where id = ?";
    private String[] column = {"ID", "NAMA SEPEDA", "NAMA PEMINJAM", "NIK", "TOTAL", "LAMA PINJAM"};

    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(read);

            while (rs.next()) {
                Object[] oj = new Object[6];
                oj[0] = rs.getInt("id");
                oj[1] = rs.getInt("sepeda_id");
                oj[2] = rs.getString("nama_peminjam");
                oj[3] = rs.getString("nik");
                oj[4] = rs.getInt("harga_total");
                oj[5] = rs.getInt("lama_pinjam");
                dtm.addRow(oj);
            }
            table.setModel(dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(table, e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            ps = con.getCon().prepareStatement(delete);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public List<Sepeda> loadSepeda() {
        List<Sepeda> sepedaList = new ArrayList<>();

        try {
            s = con.getCon().createStatement();
            rs = s.executeQuery(loadSepeda);

            while (rs.next()) {
                Sepeda sepeda = new Sepeda();
                sepeda.setId(rs.getInt("id"));
                sepeda.setNama(rs.getString("nama"));
                sepeda.setHarga(rs.getInt("harga"));
                sepeda.setStatus(rs.getString("status"));
                sepedaList.add(sepeda);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return sepedaList;
    }
}
