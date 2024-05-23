package ViewPanel;

import Database.Connect;
import Database.DBphieuxuat;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Database.UserInfo;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class ThemPhieuXuat extends javax.swing.JFrame {

    private float tongTien = 0;
    private boolean isThem = true;
    public ThemPhieuXuat (boolean isThemmoi, String maPX) {
        initComponents();
        loadTable();
        
        isThem = isThemmoi;
        
        if (isThemmoi==false) {
            loadUpdatePhieuXuat(maPX);
        }
    }
    
    private void loadUpdatePhieuXuat(String maPX){
        txtMaphieuxuat.setEnabled(false);
        txtMaphieuxuat.setText(maPX);
        
        this.tblXuatHang.removeAll();
        DefaultTableModel model = (DefaultTableModel) tblXuatHang.getModel();
        model.setRowCount(DemXuatHang(maPX));
        try {
            DBphieuxuat pt = new DBphieuxuat();
            ResultSet rs = pt.GetChitietByPhieuxuat(maPX);
            int i = 0;
            while (rs.next()) {
                this.tblXuatHang.setValueAt(rs.getString("Masp"), i, 0);
                this.tblXuatHang.setValueAt(rs.getString("Tensp"), i, 1);
                this.tblXuatHang.setValueAt(rs.getString("SoLuong"), i, 2);
                this.tblXuatHang.setValueAt(rs.getString("Gia"), i, 3);
                this.tblXuatHang.setValueAt(rs.getString("ThanhTien"), i, 4);
                
                tongTien = tongTien+Float.parseFloat(rs.getString("ThanhTien"));
                i++;
            }
            lblTongTien.setText(String.format("%,.2f", tongTien));
            pt.Close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
            System.out.println("Loi: " + ex.toString());
        }
    }
    
     public int DemXuatHang(String maPX) {
        int dem = 0;
        try {
            DBphieuxuat pn = new DBphieuxuat();
            ResultSet rs = pn.GetChitietByPhieuxuat(maPX);
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
        model.setRowCount(DemSP());
        try {
            Connect pt = new Connect();
            ResultSet rs = pt.GetData();
            int i = 0;
            while (rs.next()) {
                this.TblSanPham.setValueAt(rs.getString("MaSP"), i, 0);
                this.TblSanPham.setValueAt(rs.getString("TenSP"), i, 1);
                this.TblSanPham.setValueAt(rs.getString("SoLuong"), i, 2);
                this.TblSanPham.setValueAt(rs.getString("Gia"), i, 3);
                i++;
            }
            pt.Close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
            System.out.println("Loi: " + ex.toString());
        }
    }
    
    public int DemSP() {
        int dem = 0;
        try {
            Connect pt = new Connect();
            ResultSet rs =  pt.GetData();
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

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaphieuxuat = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSanPham = new javax.swing.JTable();
        txtQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblXuatHang = new javax.swing.JTable();
        lblTongTien = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        btnXuatHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Phiếu Xuất");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã phiếu xuất:");

        txtMaphieuxuat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaphieuxuat.setMargin(new java.awt.Insets(4, 4, 4, 4));

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete File_24px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        TblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Số lượng", "Giá"
            }
        ));
        jScrollPane1.setViewportView(TblSanPham);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng: ");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add File_24px.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        tblXuatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Số lượng", "Giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tblXuatHang);

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 0, 51));
        lblTongTien.setText("0đ");

        jLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel.setForeground(new java.awt.Color(255, 0, 0));
        jLabel.setText("Tổng tiền: ");

        btnXuatHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXuatHang.setText("Xuất hóa đơn");
        btnXuatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoa)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXuatHang)
                                .addGap(16, 16, 16))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnThem)
                        .addGap(172, 172, 172)))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(txtMaphieuxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(btnThoat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaphieuxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel)
                        .addComponent(lblTongTien)
                        .addComponent(btnXuatHang)))
                .addGap(19, 19, 19)
                .addComponent(btnThoat)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();        
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selectedRow = tblXuatHang.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblXuatHang.getModel();

        tongTien= tongTien - Float.parseFloat(model.getValueAt(selectedRow, 4).toString());
        lblTongTien.setText(String.format("%,.2f", tongTien));
        
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm xuất thành công.");
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

        int quantityInt = Integer.parseInt(txtQuantity.getText());
        int sourceSoLuongInt = Integer.parseInt(sourceTableModel.getValueAt(selectedRow, 2).toString());
        
        if (quantityInt > sourceSoLuongInt) {
            JOptionPane.showMessageDialog(this, "Số lượng hàng trong kho còn "+sourceSoLuongInt+". Vui lòng chọn lại số lượng xuất!");
            return;
        }
        
        // Lấy dữ liệu từ dòng được chọn trong bảng nguồn
        Object[] rowData = new Object[5];
        rowData[0] = sourceTableModel.getValueAt(selectedRow, 0);
        rowData[1] = sourceTableModel.getValueAt(selectedRow, 1);
        rowData[2] = txtQuantity.getText();
        rowData[3] = sourceTableModel.getValueAt(selectedRow, 3);
        rowData[4] = Integer.parseInt(txtQuantity.getText())*Float.parseFloat(rowData[3].toString());

        tongTien= tongTien+ Float.parseFloat(rowData[4].toString());
        lblTongTien.setText(String.format("%,.2f", tongTien));

        DefaultTableModel destinationTableModel = (DefaultTableModel) tblXuatHang.getModel();
        destinationTableModel.addRow(rowData);

        txtQuantity.setText("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXuatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHangActionPerformed
        // Kiểm tra xem có sản phẩm trong bảng xuất hàng không
        if (tblXuatHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm vào bảng trước khi xuất hóa đơn.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txtMaphieuxuat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu xuất.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (isThem) {
            try {
                DBphieuxuat dbPX = new DBphieuxuat();
                
                if (dbPX.KiemTra(txtMaphieuxuat.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã phiếu xuất đã tồn tại. Vui lòng nhập lại.");
                    return;
                }
                
                dbPX.Insert(txtMaphieuxuat.getText(), UserInfo.UserName);

                DefaultTableModel model = (DefaultTableModel) tblXuatHang.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    dbPX.InsertChiTiet(txtMaphieuxuat.getText(), (String) model.getValueAt(i, 0), Integer.parseInt(model.getValueAt(i, 2).toString()));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }

            JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công. Mã phiếu xuất: " + txtMaphieuxuat.getText(), "Thành công", JOptionPane.INFORMATION_MESSAGE);
            txtQuantity.setText("");
            txtMaphieuxuat.setText("");
            lblTongTien.setText("0");
            DefaultTableModel dm = (DefaultTableModel) tblXuatHang.getModel();
            while(dm.getRowCount() > 0)
            {
                dm.removeRow(0);
            }
        }else{
            try {
                DBphieuxuat dbPX = new DBphieuxuat();
                dbPX.DeleteChiTiet(txtMaphieuxuat.getText());

                DefaultTableModel model = (DefaultTableModel) tblXuatHang.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    dbPX.InsertChiTiet(txtMaphieuxuat.getText(), (String) model.getValueAt(i, 0), Integer.parseInt(model.getValueAt(i, 2).toString()));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }

            JOptionPane.showMessageDialog(this, "Phiếu xuất hóa đơn đã được cập nhật. Mã phiếu xuất: " + txtMaphieuxuat.getText(), "Thành công", JOptionPane.INFORMATION_MESSAGE);
        }
        
        loadTable();
    }//GEN-LAST:event_btnXuatHangActionPerformed

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
            java.util.logging.Logger.getLogger(ThemPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemPhieuXuat(true, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSanPham;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatHang;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblXuatHang;
    private javax.swing.JTextField txtMaphieuxuat;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
