package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBnhanvien {

    private Connection con;

    public DBnhanvien() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//nap trinh dieu khien
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysanpham_btl", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData() throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select * from nhanvien where capBac = 'Nhân viên' ";
        kq = statement.executeQuery(sql);
        return kq;
    }
    
    public boolean KiemTra(String MaNV)
    {
        try {
            String sql = "SELECT * FROM nhanvien where MaNV = '"+MaNV+"'";
            ResultSet kq = null;
            Statement statement = this.con.createStatement();
            kq=statement.executeQuery(sql);
            if(kq.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Connect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    public void Update(String MaNV, String TenNV, String Username, String Password) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Update nhanvien set TenNV ='" + TenNV + "' where MaNV ='" + MaNV + "'";
        String sql2 = "Update nhanvien set Username ='" + Username + "' where MaNV ='" + MaNV + "'";
        String sql3 = "Update nhanvien set Password ='" + Password + "' where MaNV ='" + MaNV + "'";
        sta.executeUpdate(sql1);
        sta.executeUpdate(sql2);
        sta.executeUpdate(sql3);
    }

    public void Insert(String MaNV, String TenNV, String Username, String Password) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert nhanvien values('" + MaNV + "','" + TenNV + "','" + Username + "','" + Password + "', 'Nhân viên')";
        sta.executeUpdate(sql1);
    }

    public void Delete(String MaNV) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "delete from nhanvien where MaNV = '" + MaNV + "'";
        sta.executeUpdate(sql);
    }

    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
