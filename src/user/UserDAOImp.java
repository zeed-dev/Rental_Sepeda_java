package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.Koneksi;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserDAOImp implements UserDAO {

//    private String key;
    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"ID", "NAMA", "ALAMAT", "USERNAME", "PASSWORD"};

    // Query
    private String view = "select * from tb_user";
    private String insert = "insert into tb_user (nama, alamat, username, password) value (?, ?, ?, ?)";
    private String update = "update tb_user set nama=?, alamat=?, username=?," + "password=? where id=?";
    private String delete = "delete from tb_user where id=?";

    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);
            while (rs.next()) {
                Object[] col = new Object[5];
                col[0] = rs.getInt("id");
                col[1] = rs.getString("nama");
                col[2] = rs.getString("alamat");
                col[3] = rs.getString("username");
                col[4] = rs.getString("password");
                dtm.addRow(col);
            }
            table.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void create(User user) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setString(1, user.getNama());
            ps.setString(2, user.getAlamat());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tambah data berhasil");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void update(User user) {
        try {
            ps = con.getCon().prepareStatement(update);
            ps.setString(1, user.getNama());
            ps.setString(2, user.getAlamat());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());

            ps.setString(5, String.valueOf(user.getId()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update data berhasil");
        } catch (Exception e) {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
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
        String cari = "select * from tb_user WHERE nama LIKE '%" + key + "%' OR alamat LIKE '%" + key + "%' OR username LIKE '%" + key + "%'";
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();

            rs = s.executeQuery(cari);

            while (rs.next()) {
                Object[] col = new Object[5];
                col[0] = rs.getInt("id");
                col[1] = rs.getString("nama");
                col[2] = rs.getString("alamat");
                col[3] = rs.getString("username");
                col[4] = rs.getString("password");
                dtm.addRow(col);
            }
            jt.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
