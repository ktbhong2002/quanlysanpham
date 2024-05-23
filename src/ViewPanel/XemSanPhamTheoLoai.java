package ViewPanel;

import Database.DBloaisp;
import Database.Connect;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class XemSanPhamTheoLoai extends javax.swing.JPanel {

    public final void ShowDataCombo() {
        try {
            ccbLoaiSP.addItem("");

            DBloaisp lsp = new DBloaisp();
            ResultSet dsLoai = lsp.GetData();

            while (dsLoai.next()) {
                //Them du lieu vao Combobox 
                ccbLoaiSP.addItem(dsLoai.getString("Tenloai"));
            }
        } catch (Exception e) {
        }
    }
    
    public XemSanPhamTheoLoai() {
        initComponents();
        ShowDataCombo();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ccbLoaiSP = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSanPham = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("XEM SẢN PHẨM THEO LOẠI");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Chọn loại sản phẩm");

        ccbLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ccbLoaiSPItemStateChanged(evt);
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
                "Mã SP", "Tên sản phẩm", "Mã loại", "Loại SP", "Mô tả", "Giá", "Số lượng", "Xuất xứ", "Nhà cung cấp"
            }
        ));
        jScrollPane1.setViewportView(TblSanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ccbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ccbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ccbLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ccbLoaiSPItemStateChanged
        // Xử lý sự kiện khi combobox ccbMaloai thay đổi
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Thực hiện các hành động cần thiết khi combobox thay đổi, ví dụ:
            String selectedLoai = ccbLoaiSP.getSelectedItem().toString();

            try {
                this.TblSanPham.removeAll();
                DefaultTableModel model = (DefaultTableModel) TblSanPham.getModel();
                model.setRowCount(Dem(selectedLoai));
                Connect lsp = new Connect();
                ResultSet rs = selectedLoai.equals("") ? lsp.GetData() : lsp.GetDataByLoaiSP(selectedLoai);
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

                lsp.Close();

            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_ccbLoaiSPItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSanPham;
    private javax.swing.JComboBox<String> ccbLoaiSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
