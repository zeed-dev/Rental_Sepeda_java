package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

public class LoginImp implements LoginDAO {

    private String authQuery = "select * from tb_user where username = ? and password= ?";
    private PreparedStatement ps;
    private ResultSet rs;
    private final Koneksi koneksi = new Koneksi();

    @Override
    public void login(String username, String password) {
        try {
            ps = koneksi.getCon().prepareStatement(authQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Login.AUTH = true;
                Login.NAMA = rs.getString("nama");
                Login.USER_ID = rs.getInt("id");
            }
        } catch (Exception e) {
            //Logger.getLogger(LoginDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void logout() {
        Login.AUTH = false;
        Login.NAMA = "";
        Login.USER_ID = 0;
    }
}
