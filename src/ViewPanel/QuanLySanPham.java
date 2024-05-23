package ViewPanel;

import Database.Connect;
import Database.DBloaisp;
import Database.DbNCC;
import Database.KiemTra;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLySanPham extends javax.swing.JPanel {

    private boolean isAddSelected = false;
    private boolean isUpdateSelected = false;

    public QuanLySanPham() {
        initComponents();
        loadTable();
        setReadOnly();
        ShowDataCombo();
        ShowDataComboNCC();
    }

    public void Show_Detail() {

        int i = TblSanPham.getSelectedRow();

        txtMaSP.setText((String) TblSanPham.getValueAt(i, 0));
        txtTenSP.setText((String) TblSanPham.getValueAt(i, 1));
        txtMaloai.setText((String) TblSanPham.getValueAt(i, 2));
        txtMoTa.setText((String) TblSanPham.getValueAt(i, 4));
        txtGia.setText((String) TblSanPham.getValueAt(i, 5));
        txtSoLuong.setText((String) TblSanPham.getValueAt(i, 6));
        txtXuatXu.setText((String) TblSanPham.getValueAt(i, 7));

        for (int k = 0; k < cbbLoaiSP.getItemCount(); k++) {
            var item = (ComboItem) cbbLoaiSP.getItemAt(k);
            if (item.getValue().equalsIgnoreCase((String) TblSanPham.getValueAt(i, 3))) {
                cbbLoaiSP.setSelectedIndex(k);
                break;
            }
        }
        for (int m = 0; m < cbbNCC.getItemCount(); m++) {
            var item = (ComboItem) cbbNCC.getItemAt(m);
            if (item.getValue().equalsIgnoreCase((String) TblSanPham.getValueAt(i, 8))) {
                cbbNCC.setSelectedIndex(m);
                break;
            }
        }

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

    public final void ShowDataCombo() {
        try {

            DBloaisp lsp = new DBloaisp();
            ResultSet dsLoai = lsp.GetData();

            while (dsLoai.next()) {
                //Them du lieu vao Combobox 
                cbbLoaiSP.addItem(new ComboItem(dsLoai.getString("Maloai"), dsLoai.getString("Tenloai")));
            }
        } catch (Exception e) {
        }
    }

    public final void ShowDataComboNCC() {
        try {

            DbNCC nCC = new DbNCC();
            ResultSet dsNCC = nCC.GetData();

            while (dsNCC.next()) {
                //Them du lieu vao Combobox 
                cbbNCC.addItem(new ComboItem(dsNCC.getString("maNCC"), dsNCC.getString("tenNCC")));
            }
        } catch (Exception e) {
        }
    }

    private void setReadOnly() {
        txtMaSP.setEnabled(false);
        txtTenSP.setEnabled(false);
        txtMaloai.setEnabled(false);
        txtMoTa.setEnabled(false);
        txtGia.setEnabled(false);
        txtSoLuong.setEnabled(false);
        txtXuatXu.setEnabled(false);
        cbbLoaiSP.setEnabled(false);
        cbbNCC.setEnabled(false);

        btnLuu.setEnabled(false);
        btnKLuu.setEnabled(false);
    }

    private void setEditable() {
        txtMaSP.setEnabled(true);
        txtTenSP.setEnabled(true);
        txtMaloai.setEnabled(true);
        txtMoTa.setEnabled(true);
        txtGia.setEnabled(true);
        txtSoLuong.setEnabled(true);
        txtXuatXu.setEnabled(true);
        cbbLoaiSP.setEnabled(true);
        cbbNCC.setEnabled(true);

        btnLuu.setEnabled(true);
        btnKLuu.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblSanPham = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtXuatXu = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaloai = new javax.swing.JTextField();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbNCC = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKLuu = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        TblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Mã loại", "Tên loại", "Mô tả", "Giá", "Số lượng", "Xuất xứ", "Nhà cung cấp"
            }
        ));
        TblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblSanPham);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("QUẢN LÝ SẢN PHẨM");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã sản phẩm:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mô tả:");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        txtMoTa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMoTa.setEnabled(false);
        txtMoTa.setMaximumSize(new java.awt.Dimension(50, 50));
        jScrollPane2.setViewportView(txtMoTa);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Đơn giá:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Xuất xứ:");

        txtMaSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaSP.setEnabled(false);
        txtMaSP.setMargin(new java.awt.Insets(4, 4, 4, 4));

        txtTenSP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTenSP.setEnabled(false);
        txtTenSP.setMargin(new java.awt.Insets(4, 4, 4, 4));

        txtXuatXu.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtXuatXu.setEnabled(false);
        txtXuatXu.setMargin(new java.awt.Insets(4, 4, 4, 4));

        txtGia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtGia.setEnabled(false);
        txtGia.setMargin(new java.awt.Insets(4, 4, 4, 4));

        txtSoLuong.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSoLuong.setEnabled(false);
        txtSoLuong.setMargin(new java.awt.Insets(4, 4, 4, 4));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mã loại:");

        txtMaloai.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaloai.setEnabled(false);
        txtMaloai.setMargin(new java.awt.Insets(4, 4, 4, 4));

        cbbLoaiSP.setBackground(new java.awt.Color(242, 242, 242));
        cbbLoaiSP.setEditable(true);
        cbbLoaiSP.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        cbbLoaiSP.setMinimumSize(new java.awt.Dimension(11, 26));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Loại SP:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("NCC:");

        cbbNCC.setBackground(new java.awt.Color(242, 242, 242));
        cbbNCC.setEditable(true);
        cbbNCC.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        cbbNCC.setMinimumSize(new java.awt.Dimension(11, 26));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMaloai, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(txtGia)
                            .addComponent(txtXuatXu)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbNCC, 0, 380, Short.MAX_VALUE)
                            .addComponent(cbbLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(204, 255, 204));
        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(51, 51, 0));
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
        btnLuu.setEnabled(false);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKLuu.setBackground(new java.awt.Color(255, 153, 153));
        btnKLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnKLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Do Not Disturb_24px.png"))); // NOI18N
        btnKLuu.setText("K. Lưu");
        btnKLuu.setEnabled(false);
        btnKLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnKLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(395, 395, 395)
                            .addComponent(jLabel8)
                            .addGap(0, 406, Short.MAX_VALUE))
                        .addComponent(jScrollPane1))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(249, 249, 249))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel8)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblSanPhamMouseClicked
        Show_Detail();
    }//GEN-LAST:event_TblSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        isAddSelected = true;
        isUpdateSelected = false;
        setEditable();
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtMaloai.setText("");
        txtMoTa.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        txtXuatXu.setText("");
        cbbLoaiSP.setSelectedItem("");
        cbbNCC.setSelectedItem("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String Masp = txtMaSP.getText();
            setEditable();
            txtMaSP.setText("");
            txtTenSP.setText("");
            txtMaloai.setText("");
            txtMoTa.setText("");
            txtGia.setText("");
            txtSoLuong.setText("");
            txtXuatXu.setText("");
            cbbLoaiSP.setSelectedItem("");
            cbbNCC.setSelectedItem("");
            if (!Masp.isEmpty()) {
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Connect pt = new Connect();
                    pt.Delete(Masp);
                    loadTable();
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
        setEditable();
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtMaloai.setText("");
        txtMoTa.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        txtXuatXu.setText("");
        cbbLoaiSP.setSelectedItem("");
        cbbNCC.setSelectedItem("");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try {
            String MaSP = txtMaSP.getText();
            String TenSP = txtTenSP.getText();
            String Maloai = ((ComboItem) cbbLoaiSP.getSelectedItem()).getKey();
            String Mota = txtMoTa.getText();
            String Gia = txtGia.getText();
            String Soluong = txtSoLuong.getText();
            String XuatXu = txtXuatXu.getText();
            String maNCC = ((ComboItem) cbbNCC.getSelectedItem()).getKey();
            
            if (MaSP.isEmpty() || TenSP.isEmpty() || Maloai.isEmpty() ||Mota.isEmpty() || Gia.isEmpty() || Soluong.isEmpty() || XuatXu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
                return;
            }
            
            if (!KiemTra.isInteger(Soluong)) {
                 JOptionPane.showMessageDialog(null, "Bạn phải nhập số.");
                return;
            }
            
            if (!KiemTra.isFloat(Gia)) {
                 JOptionPane.showMessageDialog(null, "Bạn phải nhập số.");
                return;
            }
            
            
            Connect pt = new Connect();

            if (isUpdateSelected ) {
                pt.Update(MaSP, TenSP, Maloai, Mota, Float.parseFloat(Gia), Integer.parseInt(Soluong), XuatXu, maNCC);
                JOptionPane.showMessageDialog(null, "Sửa thành công.");
            } else {
                if (pt.KiemTra(txtMaSP.getText())) {
                    JOptionPane.showMessageDialog(null, "Trùng mã SP. Vui lòng nhập lại.");
                } else {
                    pt.Insert(MaSP, TenSP, Maloai, Mota, Float.parseFloat(Gia), Integer.parseInt(Soluong), XuatXu, maNCC);
                    JOptionPane.showMessageDialog(null, "Thêm thành công.");
                }
            }

            loadTable();
            setReadOnly();

            isAddSelected = false;
            isUpdateSelected = false;

            txtMaSP.setText("");
            txtTenSP.setText("");
            txtMaloai.setText("");
            txtMoTa.setText("");
            txtGia.setText("");
            txtSoLuong.setText("");
            txtXuatXu.setText("");
            cbbLoaiSP.setSelectedItem("");
            cbbNCC.setSelectedItem("");

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
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtMaloai.setText("");
        txtMoTa.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        txtXuatXu.setText("");
        cbbLoaiSP.setSelectedItem("");
        cbbNCC.setSelectedItem("");
    }//GEN-LAST:event_btnKLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblSanPham;
    private javax.swing.JButton btnKLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<ComboItem> cbbLoaiSP;
    private javax.swing.JComboBox<ComboItem> cbbNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaloai;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
