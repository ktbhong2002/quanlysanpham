package ViewPanel;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TimKiemSanPham extends javax.swing.JPanel {

    private void setTheoTen() {
        txtTenSP.setEnabled(true);
        txtGiaTu.setEnabled(false);
        txtGiaDen.setEnabled(false);
        rdbTheoGia.setSelected(false);
    }

    private void setTheoGia() {
        txtTenSP.setEnabled(false);
        txtGiaTu.setEnabled(true);
        txtGiaDen.setEnabled(true);
        rdbTheoTen.setSelected(false);
    }

    public TimKiemSanPham() {
        initComponents();
        loadTable();
        txtTenSP.setEnabled(false);
        txtGiaTu.setEnabled(false);
        txtGiaDen.setEnabled(false);
    }

    public int Dem(String tenloai) {
        int dem = 0;
        try {
            Connect pt = new Connect();
            ResultSet rs = tenloai.equals("") ? pt.GetData() : pt.GetDataByLoaiSP(tenloai);
            while (rs.next()) {
                dem++;
            }

            pt.Close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ClassNotFoundException: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
        }
        return dem;
    }

    public int DemTheoTen(String tensp) {
        int dem = 0;
        try {
            Connect pt = new Connect();
            ResultSet rs = pt.SearchSanPhamWithName(tensp);
            while (rs.next()) {
                dem++;
            }

            pt.Close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ClassNotFoundException: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
        }
        return dem;
    }

    public int DemTheoGia(Float giaTu, Float giaDen) {
        int dem = 0;
        try {
            Connect pt = new Connect();
            ResultSet rs = pt.SearchSanPhamWithPrice(giaTu, giaDen);
            while (rs.next()) {
                dem++;
            }

            pt.Close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ClassNotFoundException: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
        }
        return dem;
    }

    private void loadTable() {
        this.TblSanPham.removeAll();
        DefaultTableModel model = (DefaultTableModel) TblSanPham.getModel();
        model.setRowCount(Dem(""));
        try {
            Connect pt = new Connect();
            ResultSet rs = pt.GetData();
            int i = 0;
            while (rs.next()) {
                this.TblSanPham.setValueAt(rs.getString("MaSP"), i, 0);
                this.TblSanPham.setValueAt(rs.getString("TenSP"), i, 1);
                this.TblSanPham.setValueAt(rs.getString("Maloai"), i, 2);
                this.TblSanPham.setValueAt(rs.getString("Tenloai"), i, 3);
                this.TblSanPham.setValueAt(rs.getString("MoTa"), i, 4);
                this.TblSanPham.setValueAt(rs.getString("Gia"), i, 5);
                this.TblSanPham.setValueAt(rs.getString("SoLuong"), i, 6);
                this.TblSanPham.setValueAt(rs.getString("XuatXu"), i, 7);
                this.TblSanPham.setValueAt(rs.getString("tenNCC"), i, 8);
                i++;
            }
            pt.Close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
            System.out.println("Loi: " + ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdbTheoTen = new javax.swing.JRadioButton();
        txtTenSP = new javax.swing.JTextField();
        txtGiaTu = new javax.swing.JTextField();
        txtGiaDen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSanPham = new javax.swing.JTable();
        rdbTheoGia = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên Sản Phẩm");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Từ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Đến");

        rdbTheoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbTheoTen.setText("Theo tên");
        rdbTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTheoTenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("TÌM KIẾM SẢN PHẨM");

        btnTimkiem.setBackground(new java.awt.Color(255, 255, 153));
        btnTimkiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search Property_24px.png"))); // NOI18N
        btnTimkiem.setText("Tìm Kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        TblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Mã loại", "Tên loại", "Mô tả", "Giá", "Số lượng ", "Xuất xứ", "Nhà cung cấp"
            }
        ));
        jScrollPane1.setViewportView(TblSanPham);

        rdbTheoGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbTheoGia.setText("Theo giá");
        rdbTheoGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTheoGiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(443, 443, 443)
                .addComponent(btnTimkiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(390, 390, 390))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbTheoGia)
                            .addComponent(rdbTheoTen)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGiaTu)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel4)
                                        .addGap(30, 30, 30)
                                        .addComponent(txtGiaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(rdbTheoTen)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(rdbTheoGia)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGiaDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtGiaTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnTimkiem)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdbTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTheoTenActionPerformed
        if (rdbTheoTen.isSelected()) {
            loadTable();
            txtGiaTu.setText("");
            txtGiaDen.setText("");
            setTheoTen();
        }
    }//GEN-LAST:event_rdbTheoTenActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        if (rdbTheoTen.isSelected() == true) {
            String tenSP = txtTenSP.getText().trim();
            if (tenSP.length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập từ khóa tên sản phẩm", "Chưa nhập thông tin cần thiết", JOptionPane.WARNING_MESSAGE);
                txtTenSP.requestFocus();
                return;
            }
            try {
                this.TblSanPham.removeAll();
                DefaultTableModel model = (DefaultTableModel) TblSanPham.getModel();
                model.setRowCount(DemTheoTen(tenSP));
                Connect tsp = new Connect();
                ResultSet rs = tsp.SearchSanPhamWithName(tenSP);
                int i = 0;
                while (rs.next()) {
                    this.TblSanPham.setValueAt(rs.getString("MaSP"), i, 0);
                    this.TblSanPham.setValueAt(rs.getString("TenSP"), i, 1);
                    this.TblSanPham.setValueAt(rs.getString("Maloai"), i, 2);
                    this.TblSanPham.setValueAt(rs.getString("Tenloai"), i, 3);
                    this.TblSanPham.setValueAt(rs.getString("MoTa"), i, 4);
                    this.TblSanPham.setValueAt(rs.getString("Gia"), i, 5);
                    this.TblSanPham.setValueAt(rs.getString("SoLuong"), i, 6);
                    this.TblSanPham.setValueAt(rs.getString("XuatXu"), i, 7);
                    this.TblSanPham.setValueAt(rs.getString("tenNCC"), i, 8);
                    i++;
                }
                tsp.Close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (rdbTheoGia.isSelected() == true) {
            String giaTu = txtGiaTu.getText().trim();
            String giaDen = txtGiaDen.getText().trim();

            if (giaTu.length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập giá từ", "Chưa nhập thông tin cần thiết", JOptionPane.WARNING_MESSAGE);
                txtGiaTu.requestFocus();
                return;
            }

            if (giaDen.length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập giá đến", "Chưa nhập thông tin cần thiết", JOptionPane.WARNING_MESSAGE);
                txtGiaDen.requestFocus();
                return;
            }

            try {
                this.TblSanPham.removeAll();
                DefaultTableModel model = (DefaultTableModel) TblSanPham.getModel();
                model.setRowCount(DemTheoGia(Float.parseFloat(giaTu), Float.parseFloat(giaDen)));
                Connect tsp = new Connect();
                ResultSet rs = tsp.SearchSanPhamWithPrice(Float.parseFloat(giaTu), Float.parseFloat(giaDen));
                int i = 0;
                while (rs.next()) {
                    this.TblSanPham.setValueAt(rs.getString("MaSP"), i, 0);
                    this.TblSanPham.setValueAt(rs.getString("TenSP"), i, 1);
                    this.TblSanPham.setValueAt(rs.getString("Maloai"), i, 2);
                    this.TblSanPham.setValueAt(rs.getString("Tenloai"), i, 3);
                    this.TblSanPham.setValueAt(rs.getString("MoTa"), i, 4);
                    this.TblSanPham.setValueAt(rs.getString("Gia"), i, 5);
                    this.TblSanPham.setValueAt(rs.getString("SoLuong"), i, 6);
                    this.TblSanPham.setValueAt(rs.getString("XuatXu"), i, 7);
                    this.TblSanPham.setValueAt(rs.getString("tenNCC"), i, 8);
                    i++;
                }
                tsp.Close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void rdbTheoGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTheoGiaActionPerformed
        if (rdbTheoGia.isSelected()) {
            loadTable();
            txtTenSP.setText("");
            setTheoGia();
        }
    }//GEN-LAST:event_rdbTheoGiaActionPerformed

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
            java.util.logging.Logger.getLogger(TimKiemSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimKiemSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimKiemSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimKiemSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimKiemSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSanPham;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbTheoGia;
    private javax.swing.JRadioButton rdbTheoTen;
    private javax.swing.JTextField txtGiaDen;
    private javax.swing.JTextField txtGiaTu;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
