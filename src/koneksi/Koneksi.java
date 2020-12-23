package koneksi;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {

    private Connection con;
    private final String db = "rental_sepeda";
    private final String url = "jdbc:mysql://localhost:3306/" + db;
    private final String user = "root";
    private final String pass = "";

    public Koneksi() {
        if (con == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection(url, user, pass);
                // Test Connection
                System.out.println("Connected Success!");
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public Connection getCon() {
        return con;
    }

    public static void main(String[] args) {
        Koneksi con = new Koneksi();
    }
}
