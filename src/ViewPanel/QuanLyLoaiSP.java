package ViewPanel;

import Database.DBloaisp;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyLoaiSP extends javax.swing.JPanel {

    private boolean isAddSelected = false;
    private boolean isUpdateSelected = false;

    public QuanLyLoaiSP() {
        initComponents();
        loadTable();
        setReadOnly();
    }

    public void setReadOnly() {
        btnLuu.setEnabled(false);
        btnKLuu.setEnabled(false);
        txtMaloai.setEnabled(false);
        txtTenloai.setEnabled(false);
    }

    private void setEditable() {
        btnLuu.setEnabled(true);
        btnKLuu.setEnabled(true);
        txtMaloai.setEnabled(true);
        txtTenloai.setEnabled(true);
    }

    public void Show_Detail() {

        int i = tblLoaiSP.getSelectedRow();

        txtMaloai.setText((String) tblLoaiSP.getValueAt(i, 0));
        txtTenloai.setText((String) tblLoaiSP.getValueAt(i, 1));

    }

    public int Dem() {
        int dem = 0;
        try {
            DBloaisp pt = new DBloaisp();
            ResultSet rs = pt.GetData();
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
        this.tblLoaiSP.removeAll();
        DefaultTableModel model = (DefaultTableModel) tblLoaiSP.getModel();
        model.setRowCount(Dem());
        try {
            DBloaisp pt = new DBloaisp();
            ResultSet rs = pt.GetData();
            int i = 0;
            while (rs.next()) {
                this.tblLoaiSP.setValueAt(rs.getString("Maloai"), i, 0);
                this.tblLoaiSP.setValueAt(rs.getString("Tenloai"), i, 1);
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

        jLabel3 = new javax.swing.JLabel();
        txtMaloai = new javax.swing.JTextField();
        txtTenloai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKLuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoaiSP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tên Loại:");

        txtMaloai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtTenloai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnThem.setBackground(new java.awt.Color(204, 255, 204));
        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add File_24px.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 204, 153));
        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete File_24px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 204));
        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit File_24px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(128, 185, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_24px.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKLuu.setBackground(new java.awt.Color(255, 153, 153));
        btnKLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnKLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Do Not Disturb_24px.png"))); // NOI18N
        btnKLuu.setText("Không Lưu");
        btnKLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKLuuActionPerformed(evt);
            }
        });

        tblLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Loại", "Tên Loại"
            }
        ));
        tblLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoaiSP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("DANH MỤC LOẠI SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã Loại:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnThem)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(44, 44, 44)
                                .addComponent(btnSua)
                                .addGap(39, 39, 39)
                                .addComponent(btnLuu)
                                .addGap(49, 49, 49)
                                .addComponent(btnKLuu))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnKLuu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        isAddSelected = true;
        isUpdateSelected = false;
        setEditable();
        txtMaloai.setText("");
        txtTenloai.setText("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String Maloai = txtMaloai.getText();
            setEditable();

            if (!Maloai.isEmpty()) {
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    DBloaisp pt = new DBloaisp();
                    pt.Delete(Maloai);
                    loadTable();

                    txtMaloai.setText("");
                    txtTenloai.setText("");

                    setReadOnly();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn mã sản phẩm cần xóa.");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ClassNotFoundException: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        isAddSelected = false;
        isUpdateSelected = true;
        btnLuu.setEnabled(true);
        btnKLuu.setEnabled(true);
        txtTenloai.setEnabled(true);
        txtMaloai.setText("");
        txtTenloai.setText("");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try {
            String Maloai = txtMaloai.getText();
            String Tenloai = txtTenloai.getText();

            DBloaisp pt = new DBloaisp();
            if (isUpdateSelected && !Maloai.isEmpty() && !Tenloai.isEmpty()) {
                pt.Update(Maloai, Tenloai);
                JOptionPane.showMessageDialog(null, "Sửa thành công.");
            } else {
                if (pt.KiemTra(txtMaloai.getText())) {
                    JOptionPane.showMessageDialog(null, "Trùng mã sản phẩm. Vui lòng nhập lại.");
                    txtMaloai.requestFocus();
                } else {
                    if (isAddSelected && !Maloai.isEmpty() && !Tenloai.isEmpty()) {
                        pt.Insert(Maloai, Tenloai);
                        JOptionPane.showMessageDialog(null, "Thêm thành công.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Nhập đầy đủ mã loại và tên loại.");                        
                    }
                }
            }
            loadTable();
            setReadOnly();

            isAddSelected = false;
            isUpdateSelected = false;

            txtMaloai.setText("");
            txtTenloai.setText("");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ClassNotFoundException: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR SQLException: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKLuuActionPerformed
        isAddSelected = false;
        isUpdateSelected = false;
        setReadOnly();
        txtMaloai.setText("");
        txtTenloai.setText("");
    }//GEN-LAST:event_btnKLuuActionPerformed

    private void tblLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSPMouseClicked
        Show_Detail();
    }//GEN-LAST:event_tblLoaiSPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLoaiSP;
    private javax.swing.JTextField txtMaloai;
    private javax.swing.JTextField txtTenloai;
    // End of variables declaration//GEN-END:variables
}
