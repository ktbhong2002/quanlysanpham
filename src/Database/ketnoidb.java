package Database;

import java.sql.*;
import javax.swing.JOptionPane;

public class ketnoidb {

    private final Connection conn;

    public ketnoidb() throws ClassNotFoundException, SQLException {
        //01. Nạp trình điều khiển
        Class.forName("com.mysql.cj.jdbc.Driver");
        //02. Tạo kết nối
        String url = "jdbc:mysql://localhost:3306/quanlysanpham_btl";//Đường dẫn vào Data Base
        this.conn = DriverManager.getConnection(url, "root", "");
        //Kiểm tra xem kết nối với MySQL thành công chưa?
        if (conn != null) {
            System.out.println("Kết nối thành công.");
        }
    }

    public ResultSet getData(String tbName) throws SQLException {
        ResultSet rs = null;
        //03. Tạo đối tượng Statement()để thực thi lênh SQL
        Statement ts = this.conn.createStatement();
        String sql = "select * from " + tbName;
        //04. Thực thi lệnh sql, Kết quả trả về được lưu trong rs
        rs = ts.executeQuery(sql);
        return rs;

    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        ketnoidb kn = new ketnoidb();
        ResultSet rs = null;
        rs = kn.getData("user");
        //05. Xử lý dữ liệu lấy về.
        while (rs.next()) {//Duyệt theo từng hàng của rs
            System.out.print(rs.getString("ID") + "   ");//1
            System.out.print(rs.getString("Username") + "   ");
            System.out.print(rs.getString("Password") + "   ");
            System.out.print(rs.getString("CapBac") + "   ");
            System.out.println("");
        }
    }
}
