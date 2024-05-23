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
public class DBBaoCao {
     private Connection con;

    public DBBaoCao() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//nap trinh dieu khien
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysanpham_btl", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData(String thang) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select T.MaPhieuXuat, T.NgayTaoPhieu, SUM(T.ThanhTien) as Tong " +
                        " from " +
                        "    (select cp.MaPhieuXuat, p.NgayTaoPhieu, (cp.SoLuong*s.Gia) as ThanhTien" +
                        "    from chitietphieuxuat cp " +
                        "    inner join sanpham s on cp.Masp = s.Masp" +
                        "    inner join phieuxuat p on cp.MaPhieuXuat = p.MaPhieuXuat" +
                        "    where DATE_FORMAT(p.NgayTaoPhieu, '%m/%Y') = '"+thang+"') as T" +
                        " group by T.MaPhieuXuat, T.NgayTaoPhieu";
        
        kq = statement.executeQuery(sql);
        return kq;
    }
    
    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
