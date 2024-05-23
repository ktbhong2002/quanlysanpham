package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbNCC {
    private Connection con;

    public DbNCC() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//nap trinh dieu khien
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysanpham_btl", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData() throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select * from nhacungcap";
        kq = statement.executeQuery(sql);
        return kq;
    }
    
    public boolean KiemTra(String maNCC)
    {
        try {
            String sql = "SELECT * FROM nhacungcap where maNCC = '"+maNCC+"'";
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

    public void Update(String maNCC, String tenNCC) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Update nhacungcap set tenNCC ='" + tenNCC + "' where maNCC ='" + maNCC + "'";
        sta.executeUpdate(sql1);
    }

    public void Insert(String maNCC, String tenNCC) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert nhacungcap values('" + maNCC + "','" + tenNCC + "')";
        sta.executeUpdate(sql1);
    }

    public void Delete(String maNCC) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "delete from nhacungcap where maNCC = '" + maNCC + "'";
        sta.executeUpdate(sql);
    }

    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
