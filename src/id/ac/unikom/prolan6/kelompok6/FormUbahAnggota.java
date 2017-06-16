/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.prolan6.kelompok6;

import id.ac.unikom.prolan6.kelompok6.dao.AnggotaDAO;
import id.ac.unikom.prolan6.kelompok6.daoimpl.AnggotaDAOImpl;
import id.ac.unikom.prolan6.kelompok6.entity.Anggota;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Saeful Rahman
 */
public class FormUbahAnggota extends javax.swing.JDialog {

    public FormUbahAnggota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ButtonGroup grupRadio = new ButtonGroup();
        grupRadio.add(radioLaki);
        grupRadio.add(radioPerempuan);
    }
    private String jurusan;

    public FormUbahAnggota(java.awt.Frame parent, boolean modal, Anggota anggota) {
        super(parent, modal);
        initComponents();
        fieldNim.setText(anggota.getNim());
        fieldNama.setText(anggota.getNama());
        jurusan = anggota.getJurusan();

        if ("Laki-laki".equals(anggota.getJenisKelamin())) {
            radioLaki.setSelected(true);
        } else {
            radioPerempuan.setSelected(true);
        }

        comboBoxJurusan.setSelectedItem(jurusan);
        fieldNoHp.setText(anggota.getNoHp());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldNim = new javax.swing.JTextField();
        fieldNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        radioLaki = new javax.swing.JRadioButton();
        radioPerempuan = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldNoHp = new javax.swing.JTextField();
        buttonSimpan = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        comboBoxJurusan = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuKeluar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PERPUSTAKAAN  UNIVERSITAS KODING");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ubah Data Anggota");

        jLabel3.setText("NIM                             :");

        jLabel4.setText("Nama                          :");

        fieldNim.setEditable(false);
        fieldNim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNimKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNimKeyTyped(evt);
            }
        });

        fieldNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaKeyPressed(evt);
            }
        });

        jLabel5.setText("Jenis Kelamin              :");

        buttonGroup1.add(radioLaki);
        radioLaki.setSelected(true);
        radioLaki.setText("Laki-laki");
        radioLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLakiActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioPerempuan);
        radioPerempuan.setText("Perempuan");
        radioPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPerempuanActionPerformed(evt);
            }
        });

        jLabel6.setText("Jurusan                      :");

        jLabel7.setText("No. HP                        :");

        fieldNoHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNoHpActionPerformed(evt);
            }
        });
        fieldNoHp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNoHpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNoHpKeyTyped(evt);
            }
        });

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        jLabel8.setText("Copyright © 2016");

        comboBoxJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknik Informatika", "Teknik Komputer", "Sistem Informasi", "Manajemen Informatika", "Akuntansi", "Manajemen Pemasaran", "Keuangan dan Perbankan", "Ilmu Hukum", "Desain Komunikasi Visual", "Sastra Inggris", "Sastra Jepang", "Pendidikan Biologi", "Pendidikan Kimia", "Pendidikan Bahasa Indonesia", "Pendidikan Matematika" }));
        comboBoxJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxJurusanActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        menuKeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuKeluar.setText("Keluar");
        menuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKeluarActionPerformed(evt);
            }
        });
        jMenu1.add(menuKeluar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioLaki)
                                        .addGap(40, 40, 40)
                                        .addComponent(radioPerempuan))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonSimpan)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonReset)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioLaki)
                    .addComponent(radioPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fieldNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_menuKeluarActionPerformed

    private void radioPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPerempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPerempuanActionPerformed

    private void fieldNoHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNoHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoHpActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        fieldNama.setText("");
        radioLaki.setSelected(true);
        comboBoxJurusan.setSelectedItem("Teknik Informatika");
        fieldNoHp.setText("");
    }//GEN-LAST:event_buttonResetActionPerformed

    private void radioLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioLakiActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // mengambil data dari form
        String nim = fieldNim.getText();
        String nama = fieldNama.getText();

        String jenisKelamin;

        if (radioLaki.isSelected()) {
            jenisKelamin = radioLaki.getText();
        } else {
            jenisKelamin = radioPerempuan.getText();
        }

        //Menentukan jurusan
        if (comboBoxJurusan.getSelectedItem() == "Teknik Informatika") {
            jurusan = "Teknik Informatika";
        } else if (comboBoxJurusan.getSelectedItem() == "Teknik Komputer") {
            jurusan = "Teknik Komputer";
        } else if (comboBoxJurusan.getSelectedItem() == "Sistem Informasi") {
            jurusan = "Sistem Informasi";
        } else if (comboBoxJurusan.getSelectedItem() == "Manajemen Informatika") {
            jurusan = "Manajemen Informatika";
        } else if (comboBoxJurusan.getSelectedItem() == "Akuntansi") {
            jurusan = "Akuntansi";
        } else if (comboBoxJurusan.getSelectedItem() == "Manajemen Pemasaran") {
            jurusan = "Manajemen Pemasaran";
        } else if (comboBoxJurusan.getSelectedItem() == "Keuangan dan Perbankan") {
            jurusan = "Keuangan dan Perbankan";
        } else if (comboBoxJurusan.getSelectedItem() == "Ilmu Hukum") {
            jurusan = "Ilmu Hukum";
        } else if (comboBoxJurusan.getSelectedItem() == "Desain Komunikasi Visual") {
            jurusan = "Desain Komunikasi Visual";
        } else if (comboBoxJurusan.getSelectedItem() == "Sastra Inggris") {
            jurusan = "Sastra Inggris";
        } else if (comboBoxJurusan.getSelectedItem() == "Sastra Jepang") {
            jurusan = "Sastra Jepang";
        } else if (comboBoxJurusan.getSelectedItem() == "Pendidikan Biologi") {
            jurusan = "Pendidikan Biologi";
        } else if (comboBoxJurusan.getSelectedItem() == "Pendidikan Kimia") {
            jurusan = "Pendidikan Kimia";
        } else if (comboBoxJurusan.getSelectedItem() == "Pendidikan Bahasa Indonesia") {
            jurusan = "Pendidikan Bahasa Indonesia";
        } else if (comboBoxJurusan.getSelectedItem() == "Pendidikan Matematika") {
            jurusan = "Pendidikan Matematika";
        }
        String noHp = fieldNoHp.getText();
        
        //Validasi nim, nama, jenis kelamin, jurusan, dan no hp
        if ((nim != null && !nim.isEmpty())
                && (nama != null && !nama.isEmpty())
                && (jenisKelamin != null && !jenisKelamin.isEmpty())
                && (jurusan != null && !jurusan.isEmpty())
                && (noHp != null && !noHp.isEmpty())) {
            Anggota anggota = new Anggota();
            anggota.setNim(nim);
            anggota.setNama(nama);
            anggota.setJenisKelamin(jenisKelamin);
            anggota.setJurusan(jurusan);
            anggota.setNoHp(noHp);

            AnggotaDAO dao = new AnggotaDAOImpl();
            boolean sukses = dao.ubahAnggota(anggota);

            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Silakan isi data anggota");
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void comboBoxJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxJurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxJurusanActionPerformed

    private void fieldNimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNimKeyTyped

    }//GEN-LAST:event_fieldNimKeyTyped

    private void fieldNimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNimKeyPressed

    }//GEN-LAST:event_fieldNimKeyPressed

    private void fieldNoHpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoHpKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9)
                || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)
                || (key == KeyEvent.VK_BACK_SPACE)) {
            fieldNoHp.setEditable(true);
            fieldNoHp.setBackground(Color.white);
        } else {
            fieldNoHp.setEditable(false);
            fieldNoHp.setBackground(Color.red);
        }
    }//GEN-LAST:event_fieldNoHpKeyPressed

    private void fieldNoHpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoHpKeyTyped
        if (fieldNoHp.getText().length() == 12) {
            evt.consume();
        }
    }//GEN-LAST:event_fieldNoHpKeyTyped

    private void fieldNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9)
                || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)) {
            fieldNama.setEditable(false);
            fieldNama.setBackground(Color.red);
        } else {
            fieldNama.setEditable(true);
            fieldNama.setBackground(Color.white);
        }
    }//GEN-LAST:event_fieldNamaKeyPressed

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
            java.util.logging.Logger.getLogger(FormUbahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUbahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUbahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUbahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormUbahAnggota dialog = new FormUbahAnggota(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> comboBoxJurusan;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNim;
    private javax.swing.JTextField fieldNoHp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JMenuItem menuKeluar;
    private javax.swing.JRadioButton radioLaki;
    private javax.swing.JRadioButton radioPerempuan;
    // End of variables declaration//GEN-END:variables
}