package DanhMuc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Connetion.connection;
import DanhMucBean.SetLichHoc;
import information.LichHoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;

public class ThoiKhoaBieu extends JPanel {
	JPanel panel;
	private JTable tb_LopHoc;
	private JTable tb_LichHoc;
	private DefaultTableModel tableModel;
	JButton btnNewButton;
	/**
	 * Create the panel.
	 */
	public ThoiKhoaBieu() {
		GiaoDien();
		try {
			setColumnTable();
			setColumnTable1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertDuLieu();
			}
		});
	}
	
	public void setColumnTable() throws SQLException {
		String[] arr = {"Mã Lớp Học", "Tên Lớp Học", "Tên Môn Học", "Chuyên Ngành", "Khóa", "Khu Vực Học", "Giáo Viên"};
		tableModel = new DefaultTableModel(arr, 0);
		tb_LopHoc.removeAll();
		ResultSet rSet = view("QuanLyLop", "GiangVien");
		
		
		tableModel.addRow(arr);          
		while(rSet.next()){ 
            Vector<String> vec = new Vector<String>();
            vec.add(rSet.getString(1));
            vec.add(rSet.getString(2));
            vec.add(rSet.getString(3));
            vec.add(rSet.getString(6));
            vec.add(rSet.getString(5));
            vec.add(rSet.getString(9));
            vec.add(rSet.getString(7));
            tableModel.addRow(vec); 
		}
		tb_LopHoc.setModel(tableModel);
	}
	public void setColumnTable1() throws SQLException {
		String[] arr = {"Mã Lớp Học", "Tên Lớp Học", "Giảng Viên", "Thời Gian Học", "Sĩ Số"};
		tableModel = new DefaultTableModel(arr, 0);
		tb_LichHoc.removeAll();
		ResultSet rSet = view("TKB", "GiangVien");
		tableModel.addRow(arr);          
		while(rSet.next()){ 
            Vector<String> vec = new Vector<String>();
            vec.add(rSet.getString(1));
            vec.add(rSet.getString(2));
            vec.add(rSet.getString(3));
            vec.add(rSet.getString(4));
            vec.add(rSet.getString(5));
            tableModel.addRow(vec); 
		}
		tb_LichHoc.setModel(tableModel);
	}
	
	public ResultSet view(String tableName, String Column) throws SQLException{
		Connection conn = connection.getConnection();
        ResultSet result = null;
        String sql = "SELECT * FROM " + tableName + " order by " + Column;
        Statement statement = conn.createStatement();
        result = statement.executeQuery(sql);
       return result;
    }

	public void InsertDuLieu() {
		Connection conn = connection.getConnection();
		String sqlString = "INSERT INTO TKB(MaLop, TenLop, GiangVien, LichHoc, SiSo) " 
						+ " VALUES(?, ?, ?, ?, ?)";
		String deleString = "Delete FROM TKB";
		try {
			Statement statement1 = conn.createStatement();
			statement1.executeUpdate(deleString);
			PreparedStatement statement = conn.prepareStatement(sqlString);
			List<LichHoc> list = SetLichHoc.lichHocs();
			ResultSet rSet;
			rSet = view("QuanLyLop", "GiangVien");
			int i = 0;
			while(rSet.next()) {
				if(i <= list.size()) {
					statement.setString(1, rSet.getString(1));
					statement.setNString(2, rSet.getNString(2));
					statement.setNString(3, rSet.getNString(7));
					statement.setNString(4, list.get(i).toString());
					statement.setInt(5, 75);
					statement.executeUpdate();
					i++;
				}
				else {
					i = 0;
				}
			}
			
			
			setColumnTable1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void GiaoDien() {

		setLayout(null);
		setBounds(0, 0, 764, 558);
		panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 764, 557);
		add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("S\u1EAFp X\u1EBFp L\u1ECBch H\u1ECDc ");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(270, 252, 205, 35);
		panel.add(btnNewButton);
		
		tb_LopHoc = new JTable();
		tb_LopHoc.setBounds(80, 10, 597, 213);
		panel.add(tb_LopHoc);
		
		tb_LichHoc = new JTable();
		tb_LichHoc.setBounds(80, 320, 597, 213);
		panel.add(tb_LichHoc);
	}
}
