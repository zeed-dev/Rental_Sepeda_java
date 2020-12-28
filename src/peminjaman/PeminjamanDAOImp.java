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
    String status1;
    private Koneksi con = new Koneksi();

    //query sql
    private String read = "SELECT tbl_peminjaman.id, nama, nama_peminjam, nik, harga_total, harga_total, lama_pinjam FROM tbl_peminjaman INNER JOIN tbl_sepeda ON tbl_peminjaman.sepeda_id = tbl_sepeda.id";
    private String loadSepeda = "select * from tbl_sepeda";
    private String insert = "insert into tbl_peminjaman (sepeda_id, nama_peminjam, nik, harga_total, lama_pinjam) value (?, ?, ?, ? ,?)";
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
                oj[1] = rs.getString("nama");
                oj[2] = rs.getString("nama_peminjam");
                oj[3] = rs.getString("nik");
                oj[4] = rs.getInt("harga_total");
                oj[5] = rs.getInt("lama_pinjam") + "- Hari";
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

    @Override
    public void create(Peminjaman peminjaman, int id) {

        try {
            ps = con.getCon().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setString(2, peminjaman.getNama_peminjam());
            ps.setString(3, peminjaman.getNik());
            ps.setInt(4, peminjaman.getHarga_total());
            ps.setInt(5, peminjaman.getLama_pinjam());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("error");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cekStatus(String nama) {

        try {
            s = con.getCon().createStatement();
            String cekStatus = "SELECT * FROM tbl_sepeda WHERE nama='" + nama + "'";
            rs = s.executeQuery(cekStatus);

            while (rs.next()) {
                status1 = rs.getString("status");
            }
            String Update_status = "Keluar";
            String queryUpdate = "Update tbl_sepeda SET status='" + Update_status + "' WHERE nama='" + nama + "'";
            s.executeUpdate(queryUpdate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @Override
    public boolean jikaKeluar(String nama) {
        boolean hasil = false;
        try {
            s = con.getCon().createStatement();
            String cekStatus = "SELECT * FROM tbl_sepeda WHERE nama='" + nama + "'";
            rs = s.executeQuery(cekStatus);

            while (rs.next()) {
                status1 = rs.getString("status");
            }
            if (status1.equals("Keluar")) {
                hasil = false;
            } else {
                hasil = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return hasil;
    }

    @Override
    public void hitungJumlah(int lamaPinjam, int harga) {

    }

    @Override
    public void search(JTable jt, String key) {
        String cari = "select * from tbl_peminjaman WHERE nama_peminjam LIKE '%" + key + "%' OR nik LIKE '%" + key + "%' OR harga_total LIKE '%" + key + "%'";

        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();

            rs = s.executeQuery(cari);
            while (rs.next()) {

                Object[] oj = new Object[6];
                oj[0] = rs.getInt("id");
                oj[1] = rs.getString("sepeda_id");
                oj[2] = rs.getString("nama_peminjam");
                oj[3] = rs.getString("nik");
                oj[4] = rs.getInt("harga_total");
                oj[5] = rs.getInt("lama_pinjam") + "- Hari";
                dtm.addRow(oj);
            }
            jt.setModel(dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
