/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DBphieuxuat {

    private Connection con;

    public DBphieuxuat() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//nap trinh dieu khien
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysanpham_btl", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData(String maPX, String nguoiTao) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select s.MaPhieuXuat, s.NgayTaoPhieu, s.NguoiTaoPhieu "
                + "from phieuxuat s where s.MaPhieuXuat like '%" + maPX + "%' and s.NguoiTaoPhieu like '%" + nguoiTao + "%'";

        kq = statement.executeQuery(sql);
        return kq;
    }

    public ResultSet GetChitietByPhieuxuat(String maPX) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select c.Masp, s.Tensp, c.SoLuong, s.Gia, c.SoLuong*s.Gia as ThanhTien  "
                + " from chitietphieuxuat c inner join sanpham s on c.Masp = s.Masp "
                + " where c.MaPhieuXuat = '" + maPX + "'";
        kq = statement.executeQuery(sql);
        return kq;
    }

    public boolean KiemTra(String MaPhieuXuat) {
        try {
            String sql = "SELECT * FROM phieuxuat where MaPhieuXuat = '" + MaPhieuXuat + "'";
            ResultSet kq = null;
            Statement statement = this.con.createStatement();
            kq = statement.executeQuery(sql);
            if (kq.next()) {
                return true;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Connect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    public void Insert(String MaPhieuXuat, String Nguoitaophieu) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert phieuxuat values('" + MaPhieuXuat + "',NOW(),'" + Nguoitaophieu + "')";
        sta.executeUpdate(sql1);
    }

    public void InsertChiTiet(String MaPhieuXuat, String Masp, int soLuong) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert chitietphieuxuat (MaPhieuXuat, Masp, SoLuong) values('" + MaPhieuXuat + "','" + Masp + "', " + soLuong + ")";
        String sql2 = "Update sanpham set SoLuong = SoLuong - " + soLuong + " where Masp ='" + Masp + "'";
        sta.executeUpdate(sql1);
        sta.execute(sql2);
    }

    public void DeleteChiTiet(String MaPhieuXuat) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql3 = "update sanpham s "
                + " inner join chitietphieuxuat p on s.Masp = p.Masp "
                + " set s.SoLuong = s.SoLuong + p.SoLuong"
                + " where p.MaPhieuXuat = '" + MaPhieuXuat + "'";
        sta.executeUpdate(sql3);

        String sql2 = "delete from chitietphieuxuat where MaPhieuXuat = '" + MaPhieuXuat + "'";
        sta.executeUpdate(sql2);

    }

    public void Delete(String MaPhieuXuat) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "delete from phieuxuat where MaPhieuXuat = '" + MaPhieuXuat + "'";
        sta.executeUpdate(sql);

        DeleteChiTiet(MaPhieuXuat);
    }

    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
