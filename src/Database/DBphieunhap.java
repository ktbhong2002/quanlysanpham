package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBphieunhap {
    private Connection con;

    public DBphieunhap() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//nap trinh dieu khien
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysanpham_btl", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData(String maPN, String nguoiTao) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select s.MaPhieuNhap, s.NgayTaoPhieu, s.NguoiTaoPhieu "
                + "from phieunhap s where s.MaPhieuNhap like '%"+maPN+"%' and s.NguoiTaoPhieu like '%"+nguoiTao+"%'";
        kq = statement.executeQuery(sql);
        return kq;
    }
    
    public ResultSet GetChitietByPhieunhap(String maPN) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select c.Masp, s.Tensp, c.SoLuong, s.Gia, c.SoLuong*s.Gia as ThanhTien  "
                + " from chitietphieunhap c inner join sanpham s on c.Masp = s.Masp "
                + " where c.MaPhieuNhap = '"+maPN+"'";
        kq = statement.executeQuery(sql);
        return kq;
    }
    
    public boolean KiemTra(String MaPhieuNhap)
    {
        try {
            String sql = "SELECT * FROM phieunhap where MaPhieuNhap = '"+MaPhieuNhap+"'";
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

//    public void Update(String MaPhieuNhap, String MaNCC, String Nguoitaophieu) throws SQLException {
//        Statement sta = this.con.createStatement();
//        String sql1 = "Update phieunhap set maNCC ='" + MaNCC + "', NguoiTaoPhieu ='" + Nguoitaophieu + "'  where MaPhieuNhap ='" + MaPhieuNhap + "'";
//        sta.executeUpdate(sql1);
//    }

    public void Insert(String MaPhieuNhap, String Nguoitaophieu) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert phieunhap values('" + MaPhieuNhap + "',NOW(),'" + Nguoitaophieu + "')";
        sta.executeUpdate(sql1);
    }
    
    public void InsertChiTiet(String MaPhieuNhap, String Masp, int soLuong) throws SQLException{
        Statement sta = this.con.createStatement();
        String sql1 = "Insert chitietphieunhap (MaPhieuNhap, Masp, SoLuong) values('" + MaPhieuNhap + "','" + Masp + "', "+soLuong+")";
        String sql2 = "Update sanpham set SoLuong = SoLuong + "+soLuong+" where Masp ='"+Masp +"'"; 
        sta.executeUpdate(sql1);
        sta.execute(sql2);
    }
    
     public void DeleteChiTiet(String MaPhieuNhap) throws SQLException {
        Statement sta = this.con.createStatement();
        
         String sql3 = "update sanpham s "
                + " inner join chitietphieunhap p on s.Masp = p.Masp "
                + " set s.SoLuong = s.SoLuong - p.SoLuong"
                + " where p.MaPhieuNhap = '" + MaPhieuNhap + "'";
        sta.executeUpdate(sql3);
        
        String sql2 = "delete from chitietphieunhap where MaPhieuNhap = '" + MaPhieuNhap + "'";
        sta.executeUpdate(sql2);
    }

    public void Delete(String MaPhieuNhap) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "delete from phieunhap where MaPhieuNhap = '" + MaPhieuNhap + "'";
        sta.executeUpdate(sql);
        
        DeleteChiTiet(MaPhieuNhap);
    }

    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
