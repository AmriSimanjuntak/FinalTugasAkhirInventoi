/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventori_barang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author amris
 */
public class FrmDaftarPermintaan extends javax.swing.JDialog {

    /**
     * Creates new form FrmDaftarPermintaan
     */
    inventori_barang.UserSession UserSession = new inventori_barang.UserSession();
    inventori_barang.koneksi konek = new inventori_barang.koneksi();
    
    public FrmDaftarPermintaan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initUI();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//        SelectStatus();
        GetData();
        BtnEnabled(false);
        btnterima.setText("Approve");
        btntolak.setText("Reject");
    }

    private void initUI(){ 
        getContentPane().setBackground(new Color(245, 245, 245));
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }
//    private void SelectStatus(){
//        try {
//            Connection conn = konek.openkoneksi();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM tmstatus");
//            
//            cmbid_status.addItem("Pilih");
//            while(rs.next()){
//                cmbid_status.addItem(rs.getString(""));
//            }
//            konek.closekoneksi();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error " + e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private void TxtEmpty(){
        txtid.setText("");
        txtnama.setText("");
        txtunit.setText("");
        txtkode.setText("");
        txtid_barang.setText("");
        txtid_user.setText("");
        txtid_detail    .setText("");
        txtnamabarang.setText("");
        txtjumlah.setText("");
        txttanggal.setText("");
        cmbid_status.setText("Pilih");
        
    }
    
    private void BtnEnabled(boolean x){
        btnedit.setEnabled(x);
    }
    private void GetData(){
        try {
            Connection conn = konek.openkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT tmpermintaan.id, tmpermintaan.tgl, tmbarang.kode as kode_barang, tmuser.nama as nama, tmuser.unit as unit, tmpermintaan_detail.jumlah as jumlah, tmstatus.status as status FROM tmpermintaan_detail JOIN tmpermintaan ON tmpermintaan_detail.id_permintaan = tmpermintaan.id JOIN tmbarang ON tmbarang.id = tmpermintaan_detail.id_barang JOIN tmuser ON tmuser.id = tmpermintaan.id_user JOIN tmstatus ON tmstatus.id_status_permintaan = tmpermintaan.status_permintaan");
            datatable.setModel(DbUtils.resultSetToTableModel(sql));
            datatable.getColumnModel().getColumn(0).setPreferredWidth(35);
            datatable.getColumnModel().getColumn(1).setPreferredWidth(60);
            datatable.getColumnModel().getColumn(2).setPreferredWidth(60);
            datatable.getColumnModel().getColumn(3).setPreferredWidth(80);
            datatable.getColumnModel().getColumn(4).setPreferredWidth(80);
            datatable.getColumnModel().getColumn(5).setPreferredWidth(60);
            datatable.getColumnModel().getColumn(6).setPreferredWidth(60);
            

            sql.last();
            String count_rows = String.valueOf(sql.getRow());
            lblcount_rows.setText("Jumlah Data : " + count_rows);
            konek.closekoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frmuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GetData_View(){
        int row = datatable.getSelectedRow();
        String row_id = (datatable.getModel().getValueAt(row, 0).toString());
        txtid.setText(row_id);
        BtnEnabled(true);
    }
      /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttemp_username = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        lblcount_rows = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnterima = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtunit = new javax.swing.JTextField();
        txtkode = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtnamabarang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbid_status = new javax.swing.JTextField();
        btntolak = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtid = new javax.swing.JTextPane();
        lbl_action = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        txtid_barang = new javax.swing.JTextField();
        txtid_user = new javax.swing.JTextField();
        txtid_detail = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(43, 152, 240));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(182, 229, 251));
        jLabel8.setText("Daftar Permintaan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventori_barang/img/edit.png"))); // NOI18N
        btnedit.setText("Detail");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        lblcount_rows.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lblcount_rows.setText("Jumlah Data ");

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panel.setForeground(new java.awt.Color(245, 245, 245));
        panel.setEnabled(false);

        jLabel1.setText("Nama Pemohon");

        btnterima.setText("Approve");
        btnterima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterimaActionPerformed(evt);
            }
        });

        jLabel6.setText("Unit Kerja");

        jLabel9.setText("Status Permintaan");

        jLabel10.setText("Kode Barang");

        jLabel11.setText("Jumlah Barang");

        txtnama.setEnabled(false);

        txtunit.setEnabled(false);

        txtkode.setEnabled(false);

        txtjumlah.setEnabled(false);

        txttanggal.setEnabled(false);

        jLabel12.setText("Tanggal");

        txtnamabarang.setEnabled(false);

        jLabel13.setText("Nama Barang");

        cmbid_status.setEnabled(false);
        cmbid_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbid_statusActionPerformed(evt);
            }
        });

        btntolak.setText("Reject");
        btntolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntolakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btntolak, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnterima, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbid_status)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtunit)
                            .addComponent(txtnama, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtkode, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttanggal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtjumlah))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbid_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnterima)
                    .addComponent(btntolak))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventori_barang/img/reload.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtid.setBorder(null);
        txtid.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(43, 152, 240));
        txtid.setToolTipText("");
        txtid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtid.setEnabled(false);
        txtid.setFocusable(false);
        jScrollPane2.setViewportView(txtid);

        lbl_action.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lbl_action.setText("Detail Permintaan");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel7.setText("Terpilih : ");

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kode", "Nama Barang", "Jumlah"
            }
        ));
        datatable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                datatableMouseReleased(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datatableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        txtid_barang.setEnabled(false);

        txtid_user.setEnabled(false);

        txtid_detail.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnedit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(428, 428, 428))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(lbl_action)
                        .addGap(131, 131, 131)
                        .addComponent(txtid_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtid_user, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(lblcount_rows, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txttemp_username, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(139, 139, 139)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)))
                    .addGap(8, 8, 8)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid_user, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lbl_action)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(348, 348, 348)
                            .addComponent(txttemp_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblcount_rows)
                                .addComponent(jLabel7)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        String row_id = txtid.getText();
        if(!"0".equals(row_id)){
            try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet sql = stm.executeQuery("SELECT tmpermintaan.id, tmpermintaan.tgl, tmbarang.kode as kode_barang, tmpermintaan_detail.id_barang as id_barang, tmpermintaan.id_user, tmpermintaan_detail.id as id_detail, tmbarang.nama as nama_barang, tmuser.nama as nama, tmuser.unit as unit, tmpermintaan_detail.jumlah as jumlah, tmstatus.status as status FROM tmpermintaan_detail JOIN tmpermintaan ON tmpermintaan_detail.id_permintaan = tmpermintaan.id JOIN tmbarang ON tmbarang.id = tmpermintaan_detail.id_barang JOIN tmuser ON tmuser.id = tmpermintaan.id_user JOIN tmstatus ON tmstatus.id_status_permintaan = tmpermintaan.status_permintaan WHERE tmpermintaan.id='"+row_id+"'");
                if(sql.next()){
                    lbl_action.setForeground(new Color(43, 152, 240));                    
                    txtid.setText(sql.getString("id"));
                    txtnama.setText(sql.getString("nama"));
                    txtunit.setText(sql.getString("unit"));
                    txttanggal.setText(sql.getString("tgl"));
                    txtkode.setText(sql.getString("kode_barang"));
                    txtid_barang.setText(sql.getString("id_barang"));    
                    txtid_user.setText(sql.getString("id_user"));
                    txtid_detail.setText(sql.getString("id_detail"));
                    txtnamabarang.setText(sql.getString("nama_barang"));
                    txtjumlah.setText(sql.getString("jumlah"));
                    cmbid_status.setText(sql.getString("status"));
                    txtnama.requestFocus();
                }
                konek.closekoneksi();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frmuser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Terdapat kesalahan id null!");
        }
        
    }//GEN-LAST:event_btneditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GetData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableMouseClicked

    private void datatableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_datatableMouseReleased

    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        GetData_View();
    }//GEN-LAST:event_datatableKeyReleased

    private void btnterimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterimaActionPerformed
     String row_id = txtid.getText();
     String row_status = cmbid_status.getText();
     int row_jumlah = Integer.parseInt(txtjumlah.getText());
     String row_kode = txtkode.getText();
     String row_idbarang = txtid_barang.getText();
     
     
      String id, kode;
      Integer id_barang_keluar = 0, jumlah, stok, not_found, empty = 0;
        
      DefaultTableModel model = (DefaultTableModel) datatable.getModel();
      int rowCount = model.getRowCount();
     
      if(!"0".equals(row_id)){
          try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                    stm.executeUpdate("UPDATE tmpermintaan SET status_permintaan='2' WHERE id = '" + row_id + "'");
                    JOptionPane.showMessageDialog(null, "Berhasil mengubah data.");
                    btnedit.doClick();
                    konek.closekoneksi();
                    GetData();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frmuser.class.getName()).log(Level.SEVERE, null, ex);
                }
          
                not_found = 0;
                stok = 0;
                row_kode = txtkode.getText();
                row_idbarang = txtid_barang.getText();
                    //------- Mengurangi stok dengan data jumlah
                try {
                    Connection conn = konek.openkoneksi();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet sql = stm.executeQuery("SELECT stok FROM tmbarang WHERE id = '" + row_idbarang + "'");

                    sql.next();
                    sql.last();
                    if (sql.getRow() == 1){
                        stok = (sql.getInt("stok") - row_jumlah);
                    } else {
                       not_found = 1;
                    }
                    konek.closekoneksi();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmloginPetugas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(not_found == 0){
                
                        //------- Mengupdate jumlah stok barang
                    try {
                        Connection conn = konek.openkoneksi();
                        java.sql.Statement stm = conn.createStatement();
                        stm.executeUpdate("UPDATE tmbarang SET stok='" + stok + "' WHERE id = '" + row_idbarang + "'");
                        konek.closekoneksi();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Frmbarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
             }else{
            JOptionPane.showMessageDialog(null, "Terdapat kesalahan id null!");
        }
          }
      
            
    }//GEN-LAST:event_btnterimaActionPerformed

    private void cmbid_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbid_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbid_statusActionPerformed

    private void btntolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntolakActionPerformed
        // TODO add your handling code here:
     String row_id = txtid.getText();
     String row_status = cmbid_status.getText();
      if(!"0".equals(row_id)){
          try {
                Connection conn = konek.openkoneksi();
                java.sql.Statement stm = conn.createStatement();
                    stm.executeUpdate("UPDATE tmpermintaan SET status_permintaan='3' WHERE id = '" + row_id + "'");
                    JOptionPane.showMessageDialog(null, "Berhasil mengubah data.");
                    btnedit.doClick();
                    konek.closekoneksi();
                    GetData();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frmuser.class.getName()).log(Level.SEVERE, null, ex);
                }
             }else{
            JOptionPane.showMessageDialog(null, "Terdapat kesalahan id null!");
        }
    }//GEN-LAST:event_btntolakActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDaftarPermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDaftarPermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDaftarPermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDaftarPermintaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(() -> {
            FrmDaftarPermintaan dialog = new FrmDaftarPermintaan(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnterima;
    private javax.swing.JButton btntolak;
    private javax.swing.JTextField cmbid_status;
    private javax.swing.JTable datatable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_action;
    private javax.swing.JLabel lblcount_rows;
    private javax.swing.JPanel panel;
    private javax.swing.JTextPane txtid;
    private javax.swing.JTextField txtid_barang;
    private javax.swing.JTextField txtid_detail;
    private javax.swing.JTextField txtid_user;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttemp_username;
    private javax.swing.JTextField txtunit;
    // End of variables declaration//GEN-END:variables
}
