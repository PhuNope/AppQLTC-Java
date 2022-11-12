package DanhMucBean;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connetion.connection;
import information.NguoiDung;

public class LayTaiKhoan {
	public static String Vaitro (String User) throws SQLException {
		String sqlString = "Select TenSV From SInhVien_Information" + " WHERE MaSV = ?"; 
		Connection conn = connection.getConnection();
		PreparedStatement aStatement= conn.prepareStatement(sqlString);
		aStatement.setString(1, User );
		ResultSet rSet = aStatement.executeQuery();
		if(rSet.next()) {
			System.out.println(rSet.getString("TenSV"));
			return rSet.getString("TenSV");
		}
		else {
			
		}
		return null;
	}
}
