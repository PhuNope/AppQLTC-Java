package information;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Connetion.*;

public class NguoiDungDao  {
	public static NguoiDung CheckLogin(String TK, String MK) throws SQLException {
		String sqlString = "Select TaiKhoan, MatKhau, VaiTro From TaiKhoan1" + " WHERE TaiKhoan = ? and MatKhau = ?"; 
		Connection conn = connection.getConnection();
		PreparedStatement aStatement= conn.prepareStatement(sqlString);
		aStatement.setString(1, TK);
		aStatement.setString(2, MK);
		ResultSet rSet = aStatement.executeQuery();
		if(rSet.next()) {
			NguoiDung aDung = new NguoiDung();
			aDung.setUser(TK);
			aDung.setVaiTro(rSet.getString("VaiTro"));
			return aDung;
		}
		return null;
	}
}
