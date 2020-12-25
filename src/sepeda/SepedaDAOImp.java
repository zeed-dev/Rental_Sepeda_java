package sepeda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

public class SepedaDAOImp implements SepedaDAO {

    // private String key;
    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"ID", "NAMA", "JUMLAH", "HARGA"};

    // Query
    private String view = "select * from tbl_sepeda";
    private String insert = "insert into tbl_sepeda (nama, status, harga) value (?, ?, ?)";
    private String update = "update tbl_sepeda set nama=?, status=?, harga=? where id=?";
    private String delete = "delete from tbl_sepeda where id=?";

    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);
            while (rs.next()) {
                Object[] col = new Object[4];
                col[0] = rs.getInt("id");
                col[1] = rs.getString("nama");
                col[2] = rs.getString("status");
                col[3] = rs.getInt("harga");
                dtm.addRow(col);
            }
            table.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void create(Sepeda sepeda) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setString(1, sepeda.getNama());
            ps.setString(2, sepeda.getStatus());
            ps.setInt(3, sepeda.getHarga());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tambah data berhasil");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void update(Sepeda sepeda) {
        try {
            ps = con.getCon().prepareStatement(update);
            ps.setString(1, sepeda.getNama());
            ps.setString(2, sepeda.getStatus());
            ps.setInt(3, sepeda.getHarga());

            ps.setString(4, String.valueOf(sepeda.getId()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update data berhasil");
        } catch (Exception e) {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            ps = con.getCon().prepareStatement(delete);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hapus data berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void search(JTable jt, String key) {
        String cari = "select * from tbl_sepeda WHERE nama LIKE '%" + key + "%' OR status LIKE '%" + key + "%' OR harga LIKE '%" + key + "%'";

        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();

            rs = s.executeQuery(cari);
            while (rs.next()) {
                Object[] col = new Object[5];
                col[0] = rs.getInt("id");
                col[1] = rs.getString("nama");
                col[2] = rs.getString("status");
                col[3] = rs.getInt("harga");

                dtm.addRow(col);
            }
            jt.setModel(dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
