package Form;

import ViewPanel.QuanLyPhieuNhap;
import ViewPanel.QuanLyPhieuXuat;
import ViewPanel.QuanLySanPham;
import ViewPanel.TimKiemSanPham;
import ViewPanel.XemSanPhamTheoLoai;
import java.awt.Color;
import javax.swing.JOptionPane;

public class frmTrangChuNhanVien extends javax.swing.JFrame {

    public frmTrangChuNhanVien() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tab2_QLSP = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab3_XemSP = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tab4_TimSP = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tab6_DangXuat = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tab7_QLPhieuNhap = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tab8_QLPhieuXuat = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jp0 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jp1 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        jp3 = new javax.swing.JPanel();
        jp4 = new javax.swing.JPanel();
        jp5 = new javax.swing.JPanel();
        jp6 = new javax.swing.JPanel();
        jp7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang Chủ Nhân Viên");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        tab2_QLSP.setBackground(new java.awt.Color(204, 204, 255));
        tab2_QLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2_QLSPMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setText("Quản Lý Sản Phẩm");

        javax.swing.GroupLayout tab2_QLSPLayout = new javax.swing.GroupLayout(tab2_QLSP);
        tab2_QLSP.setLayout(tab2_QLSPLayout);
        tab2_QLSPLayout.setHorizontalGroup(
            tab2_QLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2_QLSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2_QLSPLayout.setVerticalGroup(
            tab2_QLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2_QLSPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tab3_XemSP.setBackground(new java.awt.Color(204, 204, 255));
        tab3_XemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3_XemSPMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setText("Xem Sản Phẩm Theo Loại");

        javax.swing.GroupLayout tab3_XemSPLayout = new javax.swing.GroupLayout(tab3_XemSP);
        tab3_XemSP.setLayout(tab3_XemSPLayout);
        tab3_XemSPLayout.setHorizontalGroup(
            tab3_XemSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3_XemSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        tab3_XemSPLayout.setVerticalGroup(
            tab3_XemSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3_XemSPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tab4_TimSP.setBackground(new java.awt.Color(204, 204, 255));
        tab4_TimSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4_TimSPMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("Tìm Kiếm Sản Phẩm");

        javax.swing.GroupLayout tab4_TimSPLayout = new javax.swing.GroupLayout(tab4_TimSP);
        tab4_TimSP.setLayout(tab4_TimSPLayout);
        tab4_TimSPLayout.setHorizontalGroup(
            tab4_TimSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4_TimSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab4_TimSPLayout.setVerticalGroup(
            tab4_TimSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4_TimSPLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tab6_DangXuat.setBackground(new java.awt.Color(204, 204, 255));
        tab6_DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab6_DangXuatMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setText("Đăng Xuất");

        javax.swing.GroupLayout tab6_DangXuatLayout = new javax.swing.GroupLayout(tab6_DangXuat);
        tab6_DangXuat.setLayout(tab6_DangXuatLayout);
        tab6_DangXuatLayout.setHorizontalGroup(
            tab6_DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab6_DangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab6_DangXuatLayout.setVerticalGroup(
            tab6_DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab6_DangXuatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Employee");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon13.png"))); // NOI18N
        jLabel8.setText("Welcome");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        tab7_QLPhieuNhap.setBackground(new java.awt.Color(204, 204, 255));
        tab7_QLPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab7_QLPhieuNhapMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel10.setText("Quản Lý Phiếu Nhập");

        javax.swing.GroupLayout tab7_QLPhieuNhapLayout = new javax.swing.GroupLayout(tab7_QLPhieuNhap);
        tab7_QLPhieuNhap.setLayout(tab7_QLPhieuNhapLayout);
        tab7_QLPhieuNhapLayout.setHorizontalGroup(
            tab7_QLPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab7_QLPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab7_QLPhieuNhapLayout.setVerticalGroup(
            tab7_QLPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab7_QLPhieuNhapLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tab8_QLPhieuXuat.setBackground(new java.awt.Color(204, 204, 255));
        tab8_QLPhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab8_QLPhieuXuatMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel11.setText("Quản Lý Phiếu Xuất");

        javax.swing.GroupLayout tab8_QLPhieuXuatLayout = new javax.swing.GroupLayout(tab8_QLPhieuXuat);
        tab8_QLPhieuXuat.setLayout(tab8_QLPhieuXuatLayout);
        tab8_QLPhieuXuatLayout.setHorizontalGroup(
            tab8_QLPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab8_QLPhieuXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab8_QLPhieuXuatLayout.setVerticalGroup(
            tab8_QLPhieuXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab8_QLPhieuXuatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab6_DangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tab2_QLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab3_XemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab4_TimSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(tab7_QLPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab8_QLPhieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab2_QLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab3_XemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab4_TimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab7_QLPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab8_QLPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab6_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/11.png"))); // NOI18N

        javax.swing.GroupLayout jp0Layout = new javax.swing.GroupLayout(jp0);
        jp0.setLayout(jp0Layout);
        jp0Layout.setHorizontalGroup(
            jp0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp0Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jp0Layout.setVerticalGroup(
            jp0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp0Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jp0);

        jp1.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.add(jp1);

        jp2.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.add(jp2);

        jp3.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jp3Layout.setVerticalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.add(jp3);

        jp4.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jp4Layout = new javax.swing.GroupLayout(jp4);
        jp4.setLayout(jp4Layout);
        jp4Layout.setHorizontalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jp4Layout.setVerticalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.add(jp4);

        jp5.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jp5Layout = new javax.swing.GroupLayout(jp5);
        jp5.setLayout(jp5Layout);
        jp5Layout.setHorizontalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jp5Layout.setVerticalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.add(jp5);

        jp6.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jp6Layout = new javax.swing.GroupLayout(jp6);
        jp6.setLayout(jp6Layout);
        jp6Layout.setHorizontalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jp6Layout.setVerticalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.add(jp6);

        javax.swing.GroupLayout jp7Layout = new javax.swing.GroupLayout(jp7);
        jp7.setLayout(jp7Layout);
        jp7Layout.setHorizontalGroup(
            jp7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jp7Layout.setVerticalGroup(
            jp7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel2.add(jp7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab2_QLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2_QLSPMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(true);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        jp6.setVisible(false);
        jp7.setVisible(false);

        tab2_QLSP.setBackground(Color.white);
        tab3_XemSP.setBackground(new Color(204, 204, 255));
        tab4_TimSP.setBackground(new Color(204, 204, 255));
        tab6_DangXuat.setBackground(new Color(204, 204, 255));
        tab7_QLPhieuNhap.setBackground(new Color(204, 204, 255));
        tab8_QLPhieuXuat.setBackground(new Color(204, 204, 255));

        jPanel2.removeAll();
        jPanel2.add(new QuanLySanPham());
        jPanel2.validate();
    }//GEN-LAST:event_tab2_QLSPMouseClicked

    private void tab3_XemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3_XemSPMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(true);
        jp4.setVisible(false);
        jp5.setVisible(false);
        jp6.setVisible(false);
        jp7.setVisible(false);

        tab3_XemSP.setBackground(Color.white);
        tab2_QLSP.setBackground(new Color(204, 204, 255));
        tab4_TimSP.setBackground(new Color(204, 204, 255));
        tab6_DangXuat.setBackground(new Color(204, 204, 255));
        tab7_QLPhieuNhap.setBackground(new Color(204, 204, 255));
        tab8_QLPhieuXuat.setBackground(new Color(204, 204, 255));

        jPanel2.removeAll();
        jPanel2.add(new XemSanPhamTheoLoai());
        jPanel2.validate();
    }//GEN-LAST:event_tab3_XemSPMouseClicked

    private void tab4_TimSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4_TimSPMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(true);
        jp5.setVisible(false);
        jp6.setVisible(false);
        jp7.setVisible(false);

        tab4_TimSP.setBackground(Color.white);
        tab2_QLSP.setBackground(new Color(204, 204, 255));
        tab3_XemSP.setBackground(new Color(204, 204, 255));
        tab6_DangXuat.setBackground(new Color(204, 204, 255));
        tab7_QLPhieuNhap.setBackground(new Color(204, 204, 255));
        tab8_QLPhieuXuat.setBackground(new Color(204, 204, 255));

        jPanel2.removeAll();
        jPanel2.add(new TimKiemSanPham());
        jPanel2.validate();
    }//GEN-LAST:event_tab4_TimSPMouseClicked

    private void tab6_DangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab6_DangXuatMouseClicked
        tab6_DangXuat.setBackground(Color.white);
        tab2_QLSP.setBackground(new Color(204, 204, 255));
        tab3_XemSP.setBackground(new Color(204, 204, 255));
        tab4_TimSP.setBackground(new Color(204, 204, 255));
        tab7_QLPhieuNhap.setBackground(new Color(204, 204, 255));
        tab8_QLPhieuXuat.setBackground(new Color(204, 204, 255));

        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất không?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
        }

    }//GEN-LAST:event_tab6_DangXuatMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jp0.setVisible(true);
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        jp6.setVisible(false);
        jp7.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    private void tab7_QLPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab7_QLPhieuNhapMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        jp6.setVisible(true);
        jp7.setVisible(false);

        tab2_QLSP.setBackground(new Color(204, 204, 255));
        tab3_XemSP.setBackground(new Color(204, 204, 255));
        tab4_TimSP.setBackground(new Color(204, 204, 255));
        tab6_DangXuat.setBackground(new Color(204, 204, 255));
        tab7_QLPhieuNhap.setBackground(Color.white);
        tab8_QLPhieuXuat.setBackground(new Color(204, 204, 255));

        jPanel2.removeAll();
        jPanel2.add(new QuanLyPhieuNhap());
        jPanel2.validate();
    }//GEN-LAST:event_tab7_QLPhieuNhapMouseClicked

    private void tab8_QLPhieuXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab8_QLPhieuXuatMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        jp6.setVisible(false);
        jp7.setVisible(true);

        tab2_QLSP.setBackground(new Color(204, 204, 255));
        tab3_XemSP.setBackground(new Color(204, 204, 255));
        tab4_TimSP.setBackground(new Color(204, 204, 255));
        tab6_DangXuat.setBackground(new Color(204, 204, 255));
        tab7_QLPhieuNhap.setBackground(new Color(204, 204, 255));
        tab8_QLPhieuXuat.setBackground(Color.white);

        jPanel2.removeAll();
        jPanel2.add(new QuanLyPhieuXuat());
        jPanel2.validate();
    }//GEN-LAST:event_tab8_QLPhieuXuatMouseClicked

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
            java.util.logging.Logger.getLogger(frmTrangChuNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTrangChuNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTrangChuNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTrangChuNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTrangChuNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jp0;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JPanel jp5;
    private javax.swing.JPanel jp6;
    private javax.swing.JPanel jp7;
    private javax.swing.JPanel tab2_QLSP;
    private javax.swing.JPanel tab3_XemSP;
    private javax.swing.JPanel tab4_TimSP;
    private javax.swing.JPanel tab6_DangXuat;
    private javax.swing.JPanel tab7_QLPhieuNhap;
    private javax.swing.JPanel tab8_QLPhieuXuat;
    // End of variables declaration//GEN-END:variables
}
