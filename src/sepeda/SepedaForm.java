package sepeda;

import javax.swing.JOptionPane;

public class SepedaForm extends javax.swing.JFrame {
    
    private int id;
    private SepedaDAO dao;
    private int tag;
    
    public SepedaForm() {
        initComponents();
        dao = new SepedaDAOImp();
        reset();
    }
    
    public void reset() {
        tag = 0;
        tf_nama.setText("");
        cb_status.setSelectedIndex(0);
        tf_harga.setText("");
        
        read();
    }
    
    public void read() {
        dao.read(tbl_sepeda);
    }
    
    public boolean validasi() {
        boolean hasil = false;
        
        if (tf_nama.getText().isEmpty() || tf_harga.getText().isEmpty() || cb_status.getSelectedIndex() == 0) {
            hasil = false;
        } else {
            hasil = true;
        }
        return hasil;
    }
    
    public void create() {
        Sepeda sepeda = new Sepeda();
        sepeda.setNama(tf_nama.getText());
        sepeda.setStatus(cb_status.getSelectedItem().toString());
        sepeda.setHarga(Integer.valueOf(tf_harga.getText()));
        
        dao.create(sepeda);
    }
    
    public void update() {
        Sepeda sepeda = new Sepeda();
        sepeda.setNama(tf_nama.getText());
        sepeda.setStatus(cb_status.getSelectedItem().toString());
        sepeda.setHarga(Integer.valueOf(tf_harga.getText()));
        
        sepeda.setId(id);
        dao.update(sepeda);
    }
    
    public void save() {
        if (validasi() == true) {
            if (tag == 0) {
                create();
            } else if (tag == 1) {
                update();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Input belum lengkap!");
        }
        reset();
    }
    
    public void getRecord() {
        int selected = tbl_sepeda.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin ingin mengubah data?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (conf == JOptionPane.YES_OPTION) {
                tag = 1;
                int baris = tbl_sepeda.getSelectedRow();
                id = Integer.valueOf(tbl_sepeda.getValueAt(baris, 0).toString());
                tf_nama.setText(tbl_sepeda.getValueAt(baris, 1).toString());
                cb_status.setSelectedItem(tbl_sepeda.getValueAt(baris, 2).toString());
                tf_harga.setText(tbl_sepeda.getValueAt(baris, 3).toString());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }
    
    public void delete() {
        int selected = tbl_sepeda.getSelectedRowCount();
        if (selected > 0) {
            int conf = JOptionPane.NO_OPTION;
            conf = JOptionPane.showConfirmDialog(rootPane, "Yakin ingin menghapus data?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                int baris = tbl_sepeda.getSelectedRow();
                id = Integer.valueOf(tbl_sepeda.getValueAt(baris, 0).toString());
                dao.delete(id);
                reset();;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada data yang dipilih!");
        }
    }
    
    public void cari() {
        if (tf_cari.getText().isEmpty()) {
            reset();
        } else {
            dao.search(tbl_sepeda, tf_cari.getText());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        tf_harga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sepeda = new javax.swing.JTable();
        tf_cari = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_status = new javax.swing.JComboBox<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\SEPEDA.png")); // NOI18N
        jLabel1.setText("MANAGEMENT SEPEDA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("NAMA SEPEDA");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("STATUS");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("HARGA");

        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_edit.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_delete.png"))); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/download2.2.png"))); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        tbl_sepeda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_sepeda);

        tf_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cariKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("CARI");

        cb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "Tersedia", "Keluar" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_harga)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        save();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        getRecord();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        delete();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        reset();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void tf_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariKeyReleased
        cari();
    }//GEN-LAST:event_tf_cariKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SepedaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SepedaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SepedaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SepedaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SepedaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cb_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_sepeda;
    private javax.swing.JTextField tf_cari;
    private javax.swing.JTextField tf_harga;
    private javax.swing.JTextField tf_nama;
    // End of variables declaration//GEN-END:variables
}
