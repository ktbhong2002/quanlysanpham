package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    private final Connection con;

    public Connect() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//nap trinh dieu khien
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysanpham_btl", "root", ""); //thuc hien ket noi
    }

    public ResultSet GetData() throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select s.Masp, s.Tensp, s.Maloai,s.MoTa, s.Gia, s.SoLuong,s.XuatXu, s.maNCC, l.Tenloai, p.tenNCC "
                + "from sanpham s "
                + "inner join loaisp l on s.Maloai = l.Maloai "
                + "inner join nhacungcap p on s.maNCC = p.maNCC";
        kq = statement.executeQuery(sql);
        return kq;
    }

    public ResultSet GetDataByLoaiSP(String tenloai) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select s.Masp, s.Tensp, s.Maloai,s.MoTa, s.Gia, s.SoLuong,s.XuatXu, l.Tenloai, p.tenNCC "
                + "from sanpham s "
                + "inner join loaisp l on s.Maloai = l.Maloai "
                + "inner join nhacungcap p on s.maNCC = p.maNCC"
                + " where l.Tenloai = '" + tenloai + "'";
        kq = statement.executeQuery(sql);
        return kq;
    }

    public boolean KiemTra(String MaSP) {
        try {
            String sql = "SELECT * FROM sanpham where Masp = '" + MaSP + "'";
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

    public ResultSet SearchSanPhamWithName(String tensp) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select s.Masp, s.Tensp, s.Maloai,s.MoTa, s.Gia, s.SoLuong,s.XuatXu, l.Tenloai, p.tenNCC "
                + "from sanpham s "
                + "inner join loaisp l on s.Maloai = l.Maloai "
                + "inner join nhacungcap p on s.maNCC = p.maNCC"
                + " where s.TensP like '%" + tensp + "%'";
        kq = statement.executeQuery(sql);
        return kq;
    }

    public ResultSet SearchSanPhamWithPrice(Float giaTu, Float giaDen) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "select s.Masp, s.Tensp, s.Maloai,s.MoTa, s.Gia, s.SoLuong,s.XuatXu, l.Tenloai, p.tenNCC "
                + "from sanpham s "
                + "inner join loaisp l on s.Maloai = l.Maloai "
                + "inner join nhacungcap p on s.maNCC = p.maNCC"
                + " where s.Gia >= " + giaTu + " and s.Gia <= " + giaDen;
        kq = statement.executeQuery(sql);
        return kq;
    }

    public void Update(String Masp, String TenSP, String Maloai, String MoTa, float Gia, int SoLuong, String XuatXu, String maNCC) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Update sanpham set Tensp='" + TenSP + "' where Masp ='" + Masp + "'";
        String sql2 = "Update sanpham set Maloai='" + Maloai + "' where Masp ='" + Masp + "'";
        String sql3 = "Update sanpham set MoTa='" + MoTa + "' where Masp ='" + Masp + "'";
        String sql4 = "Update sanpham set Gia=" + Gia + " where Masp ='" + Masp + "'";
        String sql5 = "Update sanpham set SoLuong=" + SoLuong + " where Masp ='" + Masp + "'";
        String sql6 = "Update sanpham set XuatXu='" + XuatXu + "' where Masp ='" + Masp + "'";
        String sql7 = "Update sanpham set maNCC='" + maNCC + "' where Masp ='" + Masp + "'";
        sta.executeUpdate(sql1);
        sta.executeUpdate(sql2);
        sta.executeUpdate(sql3);
        sta.executeUpdate(sql4);
        sta.executeUpdate(sql5);
        sta.executeUpdate(sql6);
        sta.executeUpdate(sql7);
    }

    public void Insert(String Masp, String TenSanPham, String Maloai, String MoTa, float Gia, int SoLuong, String XuatXu, String maNCC) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert sanpham values('" + Masp + "','" + TenSanPham + "','" + Maloai + "','" + MoTa + "'," + Gia + ", " + SoLuong + ", '" + XuatXu + "', '" + maNCC + "')";
        sta.executeUpdate(sql1);
    }

    public void Delete(String Masp) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "delete from sanpham where Masp = '" + Masp + "'";
        sta.executeUpdate(sql);
    }

    public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
        //System.exit(0);
    }
}
