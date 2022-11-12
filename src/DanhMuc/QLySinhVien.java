package DanhMuc;

import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Connetion.connection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;



public class QLySinhVien extends JPanel {
	JPanel panel;
	private JTextField txt_MaLop;
	private JTable table;
	private DefaultTableModel tableModel;
	JComboBox cbx_TenLop, cbx_MonHoc, cbx_ChuyenNganh, cbx_Khoa, cbx_KhuVucHoc, cbx_GiangVien;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
			
	
	public QLySinhVien() throws SQLException {
		setLayout(null);
		setBounds(0, 0, 764, 596);
		panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 764, 557);
		add(panel);
		panel.setLayout(null);
		
		GiaoDien();
		setColumnTable();
		SetCombobox(cbx_TenLop, "LopHoc", 2);
		SetCombobox(cbx_Khoa, "KhoaSV", 1);
		SetCombobox(cbx_ChuyenNganh, "ChuyenNganh", 2);
		SetCombobox(cbx_GiangVien, "GiangVien", 2);
		SetCombobox(cbx_KhuVucHoc, "KhuVucHoc", 2);
		SetCombobox(cbx_MonHoc, "MonHocTheChat1", 2);
		
		JButton btn_Them = new JButton("THÊM");
		btn_Them.setFont(new Font("Arial", Font.BOLD, 12));
		btn_Them.setBounds(274, 318, 110, 26);
		panel.add(btn_Them);
		btn_Them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertDuLieu();
			}
		});
	}
	
	public void GiaoDien() {
		JLabel lblNewLabel = new JLabel("M\u00E3 L\u1EDBp");
		lblNewLabel.setBounds(31, 34, 103, 20);
		panel.add(lblNewLabel);
		
		JLabel lblTnLp = new JLabel("T\u00EAn L\u1EDBp");
		lblTnLp.setBounds(31, 75, 69, 20);
		panel.add(lblTnLp);
		
		JLabel lblMnHc = new JLabel("M\u00F4n H\u1ECDc");
		lblMnHc.setBounds(31, 115, 69, 20);
		panel.add(lblMnHc);
		
		JLabel lblChuynNgnh = new JLabel("Chuy\u00EAn Ng\u00E0nh");
		lblChuynNgnh.setBounds(31, 155, 103, 20);
		panel.add(lblChuynNgnh);
		
		JLabel lblKhoa = new JLabel("Kh\u00F3a");
		lblKhoa.setBounds(31, 197, 103, 20);
		panel.add(lblKhoa);
		
		JLabel lblKhuVcHc = new JLabel("Khu V\u1EF1c H\u1ECDc");
		lblKhuVcHc.setBounds(31, 239, 137, 20);
		panel.add(lblKhuVcHc);
		
		JLabel lblGingVin = new JLabel("Gi\u1EA3ng Vi\u00EAn");
		lblGingVin.setBounds(31, 287, 103, 20);
		panel.add(lblGingVin);
		
		JButton btnNewButton = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton.setBounds(523, 34, 110, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_1.setBounds(523, 75, 110, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_2.setBounds(523, 115, 110, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_3.setBounds(523, 155, 110, 21);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_4.setBounds(523, 197, 110, 21);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_5.setBounds(523, 239, 110, 21);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Ch\u1EC9nh S\u1EEDa");
		btnNewButton_6.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_6.setBounds(523, 287, 110, 21);
		panel.add(btnNewButton_6);
		
		cbx_TenLop = new JComboBox();
		cbx_TenLop.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_TenLop.setBounds(208, 75, 243, 21);
		panel.add(cbx_TenLop);
		
		cbx_MonHoc = new JComboBox();
		cbx_MonHoc.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_MonHoc.setBounds(208, 115, 243, 21);
		panel.add(cbx_MonHoc);
		
		cbx_ChuyenNganh = new JComboBox();
		cbx_ChuyenNganh.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_ChuyenNganh.setBounds(208, 155, 243, 21);
		panel.add(cbx_ChuyenNganh);
		
		cbx_Khoa = new JComboBox();
		cbx_Khoa.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_Khoa.setBounds(208, 197, 243, 21);
		panel.add(cbx_Khoa);
		
		cbx_KhuVucHoc = new JComboBox();
		cbx_KhuVucHoc.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_KhuVucHoc.setBounds(208, 239, 243, 21);
		panel.add(cbx_KhuVucHoc);
		
		cbx_GiangVien = new JComboBox();
		cbx_GiangVien.setFont(new Font("Arial", Font.BOLD, 12));
		cbx_GiangVien.setBounds(208, 287, 243, 21);
		panel.add(cbx_GiangVien);
		
		txt_MaLop = new JTextField();
		txt_MaLop.setFont(new Font("Arial", Font.BOLD, 12));
		txt_MaLop.setBounds(208, 35, 243, 19);
		panel.add(txt_MaLop);
		txt_MaLop.setColumns(10);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.BOLD, 11));
		table.setBounds(31, 355, 695, 177);
		panel.add(table);
	}
	public void setColumnTable() throws SQLException {
		String[] arr = {"Mã Lớp Học", "Tên Lớp Học", "Tên Môn Học", "Chuyên Ngành", "Khóa", "Khu Vực Học", "Giáo Viên"};
		tableModel = new DefaultTableModel(arr, 0);
		table.removeAll();
		ResultSet rSet = view("QuanLyLop");
		
		
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
		table.setModel(tableModel);
		
	}
	
	
	public void SetCombobox(JComboBox aBox, String TableName, int i) {
		try {
			ResultSet rs = view(TableName);
			while(rs.next()) {
				aBox.addItem(rs.getString(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet view(String tableName) throws SQLException{
		Connection conn = connection.getConnection();
        ResultSet result = null;
        String sql = "SELECT * FROM " + tableName;;
        Statement statement = conn.createStatement();
        result = statement.executeQuery(sql);
       return result;
    }
	
	
	
	public void InsertDuLieu() {
		Connection conn = connection.getConnection();
		String sqlString = "INSERT INTO QuanLyLop(MaLop, TenLop, MonHoc, MaMH, Khoa, ChuyenNganh, GiangVien, MaGV, KhuVucHoc) " 
						+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	try {
			PreparedStatement pStatement = conn.prepareStatement(sqlString);
			
			ResultSet aSet = view1("QuanLyLop", "MaLop", txt_MaLop.getText());
			if(aSet == null) {
				pStatement.setString(1, txt_MaLop.getText());
				pStatement.setString(2, cbx_TenLop.getSelectedItem().toString());
				pStatement.setString(3, cbx_MonHoc.getSelectedItem().toString());
				pStatement.setInt(5, Integer.valueOf(cbx_Khoa.getSelectedItem().toString()));
				pStatement.setString(6, cbx_ChuyenNganh.getSelectedItem().toString());
				pStatement.setString(7, cbx_GiangVien.getSelectedItem().toString());
				pStatement.setString(9, cbx_KhuVucHoc.getSelectedItem().toString());
				ResultSet resultSet = view1("MonHocTheChat1", "TenMonHoc", cbx_MonHoc.getSelectedItem().toString());
				pStatement.setString(4, resultSet.getString(1));
				ResultSet resultSet2 = view1("GiangVien", "TenGV", cbx_GiangVien.getSelectedItem().toString());
				pStatement.setString(8, resultSet2.getString(1));
				
				pStatement.executeUpdate();
			}
			else {
				JOptionPane.showMessageDialog(panel, "Trùng Mã Lớp");
			}
		}catch (SQLException e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			setColumnTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ResultSet view1(String tableName, String Cot, String DauVao) throws SQLException{
		Connection conn = connection.getConnection();
        ResultSet result = null;
        String sql = "SELECT * FROM " + tableName + " Where " + Cot + " = ?" ;
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setNString(1, DauVao);
        result = preparedStatement.executeQuery();
        if(result.next()) {
        	return result;
        }
        else {
			return null;
		}
    }
	
}
