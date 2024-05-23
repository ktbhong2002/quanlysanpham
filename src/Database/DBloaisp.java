package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBloaisp {
    private Connection con;

    public DBloaisp() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//nap trinh dieu khien
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysanpham_btl", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData() throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select * from loaisp";
        kq = statement.executeQuery(sql);
        return kq;
    }
    
    public boolean KiemTra(String Maloai)
    {
        try {
            String sql = "SELECT * FROM loaisp where Maloai = '"+Maloai+"'";
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

    public void Update(String Maloai, String Tenloai) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Update loaisp set Tenloai ='" + Tenloai + "' where Maloai ='" + Maloai + "'";
        sta.executeUpdate(sql1);
    }

    public void Insert(String Maloai, String Tenloai) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert loaisp values('" + Maloai + "','" + Tenloai + "')";
        sta.executeUpdate(sql1);
    }

    public void Delete(String Maloai) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "delete from loaisp where Maloai = '" + Maloai + "'";
        sta.executeUpdate(sql);
    }

    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
