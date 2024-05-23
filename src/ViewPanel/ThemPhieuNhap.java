package ViewPanel;

import Database.Connect;
import Database.DBphieunhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Database.UserInfo;

public class ThemPhieuNhap extends javax.swing.JFrame {

    private float tongTien = 0;
    private boolean isThem = true;

    public ThemPhieuNhap(boolean isThemmoi, String maPN) {
        initComponents();
        loadTable();
        isThem = isThemmoi;

        if (isThemmoi == false) {
            loadUpdatePhieuNhap(maPN);
        }
    }

    private void loadUpdatePhieuNhap(String maPN) {
        txtMaphieunhap.setEnabled(false);
        txtMaphieunhap.setText(maPN);

        this.tblNhapHang.removeAll();
        DefaultTableModel model = (DefaultTableModel) tblNhapHang.getModel();
        model.setRowCount(DemNhapHang(maPN));
        try {
            DBphieunhap pt = new DBphieunhap();
            ResultSet rs = pt.GetChitietByPhieunhap(maPN);
            int i = 0;
            while (rs.next()) {
                this.tblNhapHang.setValueAt(rs.getString("Masp"), i, 0);
                this.tblNhapHang.setValueAt(rs.getString("Tensp"), i, 1);
                this.tblNhapHang.setValueAt(rs.getString("SoLuong"), i, 2);
                this.tblNhapHang.setValueAt(rs.getString("Gia"), i, 3);
                this.tblNhapHang.setValueAt(rs.getString("ThanhTien"), i, 4);

                tongTien = tongTien + Float.parseFloat(rs.getString("ThanhTien"));
                i++;
            }
            lblTongTien.setText(String.format("%,.2f", tongTien));
            pt.Close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
            System.out.println("Loi: " + ex.toString());
        }
    }

    public int DemNhapHang(String maPN) {
        int dem = 0;
        try {
            DBphieunhap pn = new DBphieunhap();
            ResultSet rs = pn.GetChitietByPhieunhap(maPN);
            while (rs.next()) {
                dem++;
            }

            pn.Close();
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
        model.setRowCount(DemSP(""));
        try {
            Connect pt = new Connect();
            ResultSet rs = pt.GetData();
            int i = 0;
            while (rs.next()) {
                this.TblSanPham.setValueAt(rs.getString("MaSP"), i, 0);
                this.TblSanPham.setValueAt(rs.getString("TenSP"), i, 1);
                this.TblSanPham.setValueAt(rs.getString("Gia"), i, 2);
                i++;
            }
            pt.Close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
            System.out.println("Loi: " + ex.toString());
        }
    }

    public int DemSP(String tenloai) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnXoa = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        lblTongTien = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSanPham = new javax.swing.JTable();
        btnNhapHang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhapHang = new javax.swing.JTable();
        txtMaphieunhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete File_24px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 0, 51));
        lblTongTien.setText("0đ");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add File_24px.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Phiếu Nhập");

        jLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 0, 0));
        jLabel.setText("Tổng tiền: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng: ");

        TblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Giá"
            }
        ));
        jScrollPane1.setViewportView(TblSanPham);

        btnNhapHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        tblNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Số lượng", "Giá", "Thành tien"
            }
        ));
        jScrollPane2.setViewportView(tblNhapHang);

        txtMaphieunhap.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaphieunhap.setMargin(new java.awt.Insets(4, 4, 4, 4));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã phiếu nhập:");

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(txtMaphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnThem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNhapHang))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoa)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(383, 383, 383))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThoat)
                        .addGap(418, 418, 418))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(jLabel)
                        .addComponent(lblTongTien)
                        .addComponent(btnNhapHang)))
                .addGap(18, 18, 18)
                .addComponent(btnThoat)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // Xác định dòng được chọn trong bảng tblNhapHang
        int selectedRow = tblNhapHang.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa.");
            return;
        }

        // Lấy dữ liệu từ dòng được chọn
        DefaultTableModel model = (DefaultTableModel) tblNhapHang.getModel();

        tongTien = tongTien - Float.parseFloat(model.getValueAt(selectedRow, 4).toString());
        lblTongTien.setText(String.format("%,.2f", tongTien));
        // Xóa dòng được chọn từ bảng hiển thị
        model.removeRow(selectedRow);

        // Hiển thị thông báo hoặc thực hiện các bước khác theo nhu cầu của bạn
        JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm nhập thành công.");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // Lấy dòng được chọn trong bảng nguồn
        int selectedRow = TblSanPham.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng từ bảng nguồn.");
            return;
        }

        if (txtQuantity.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn số lượng.");
            return;
        }

        // Lấy model của bảng nguồn
        DefaultTableModel sourceTableModel = (DefaultTableModel) TblSanPham.getModel();

        // Lấy dữ liệu từ dòng được chọn trong bảng nguồn
        Object[] rowData = new Object[5];
        rowData[0] = sourceTableModel.getValueAt(selectedRow, 0);
        rowData[1] = sourceTableModel.getValueAt(selectedRow, 1);
        rowData[2] = txtQuantity.getText();
        rowData[3] = sourceTableModel.getValueAt(selectedRow, 2);
        rowData[4] = Integer.parseInt(txtQuantity.getText()) * Float.parseFloat(rowData[3].toString());

        tongTien = tongTien + Float.parseFloat(rowData[4].toString());
        lblTongTien.setText(String.format("%,.2f", tongTien));

        DefaultTableModel destinationTableModel = (DefaultTableModel) tblNhapHang.getModel();
        destinationTableModel.addRow(rowData);

        txtQuantity.setText("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // Kiểm tra xem có sản phẩm trong bảng xuất hàng không
        if (tblNhapHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm vào bảng trước khi nhập hàng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtMaphieunhap.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu nhập.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (isThem) {
            try {
                DBphieunhap dbPN = new DBphieunhap();
                if (dbPN.KiemTra(txtMaphieunhap.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại. Vui lòng nhập lại.");
                    return;
                }

                dbPN.Insert(txtMaphieunhap.getText(), UserInfo.UserName);

                DefaultTableModel model = (DefaultTableModel) tblNhapHang.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    dbPN.InsertChiTiet(txtMaphieunhap.getText(), (String) model.getValueAt(i, 0), Integer.parseInt(model.getValueAt(i, 2).toString()));
                }
            } catch (Exception ex) {
                Logger.getLogger(ThemPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(this, "Nhập hàng thành công. Mã phiếu nhập: " + txtMaphieunhap.getText(), "Thành công", JOptionPane.INFORMATION_MESSAGE);
            txtQuantity.setText("");
            txtMaphieunhap.setText("");
            lblTongTien.setText("0");
            DefaultTableModel dm = (DefaultTableModel) tblNhapHang.getModel();
            while (dm.getRowCount() > 0) {
                dm.removeRow(0);
            }
        } else {
            try {
                DBphieunhap dbPN = new DBphieunhap();
                dbPN.DeleteChiTiet(txtMaphieunhap.getText());

                DefaultTableModel model = (DefaultTableModel) tblNhapHang.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    dbPN.InsertChiTiet(txtMaphieunhap.getText(), (String) model.getValueAt(i, 0), Integer.parseInt(model.getValueAt(i, 2).toString()));
                }
            } catch (Exception ex) {
                Logger.getLogger(ThemPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(this, "Phiếu nhập hàng đã được cập nhật. Mã phiếu nhập: " + txtMaphieunhap.getText(), "Thành công", JOptionPane.INFORMATION_MESSAGE);
        }

        loadTable();
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();       
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemPhieuNhap(true, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSanPham;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblNhapHang;
    private javax.swing.JTextField txtMaphieunhap;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
