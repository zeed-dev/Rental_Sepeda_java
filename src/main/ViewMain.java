package main;

import javax.swing.JOptionPane;
import login.LoginDAO;
import login.LoginForm;
import login.LoginImp;
import user.UserForm;
import sepeda.SepedaForm;
import peminjaman.PeminjamanForm;
import pengembalian.PengembalianForm;

public class ViewMain extends javax.swing.JFrame {

    private LoginDAO dao;

    public ViewMain() {
        initComponents();
        dao = new LoginImp();
    }

    public void logout() {
        int conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk Logout?", "Logout?",
                JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            dao.logout();
            this.dispose();
            new LoginForm().setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_ViewUser = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_ViewSepeda = new javax.swing.JButton();
        btn_ViewPeminjaman = new javax.swing.JButton();
        btn_logout1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(595, 651));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        jLabel1.setText("RENTAL SEPEDA GILI TRAWANGAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btn_ViewUser.setBackground(new java.awt.Color(204, 204, 255));
        btn_ViewUser.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_ViewUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User-Group-icon.png"))); // NOI18N
        btn_ViewUser.setText("USER");
        btn_ViewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewUserActionPerformed(evt);
            }
        });

        btn_logout.setBackground(new java.awt.Color(204, 204, 255));
        btn_logout.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout_icon-icons.com_51025.png"))); // NOI18N
        btn_logout.setText("KELUAR");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_ViewSepeda.setBackground(new java.awt.Color(204, 204, 255));
        btn_ViewSepeda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_ViewSepeda.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\SEPEDA.png")); // NOI18N
        btn_ViewSepeda.setText("SEPEDA");
        btn_ViewSepeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewSepedaActionPerformed(evt);
            }
        });

        btn_ViewPeminjaman.setBackground(new java.awt.Color(204, 204, 255));
        btn_ViewPeminjaman.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_ViewPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Money-32.png"))); // NOI18N
        btn_ViewPeminjaman.setText("PEMINJAMAN");
        btn_ViewPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewPeminjamanActionPerformed(evt);
            }
        });

        btn_logout1.setBackground(new java.awt.Color(204, 204, 255));
        btn_logout1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Button-Refresh-icon.png"))); // NOI18N
        btn_logout1.setText("PENGEMBALIAN");
        btn_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ViewSepeda, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ViewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ViewPeminjaman)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ViewPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ViewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ViewSepeda, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btn_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ViewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewUserActionPerformed
        new UserForm().setVisible(true);
    }//GEN-LAST:event_btn_ViewUserActionPerformed

    private void btn_ViewSepedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewSepedaActionPerformed
        new SepedaForm().setVisible(true);
    }//GEN-LAST:event_btn_ViewSepedaActionPerformed

    private void btn_ViewPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ViewPeminjamanActionPerformed
        new PeminjamanForm().setVisible(true);
    }//GEN-LAST:event_btn_ViewPeminjamanActionPerformed

    private void btn_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout1ActionPerformed
        new PengembalianForm().setVisible(true);
    }//GEN-LAST:event_btn_logout1ActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        logout();
    }//GEN-LAST:event_btn_logoutActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ViewPeminjaman;
    private javax.swing.JButton btn_ViewSepeda;
    private javax.swing.JButton btn_ViewUser;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_logout1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
