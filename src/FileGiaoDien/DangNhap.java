package FileGiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import information.NguoiDung;
import information.NguoiDungDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tbx_DangNhap;
	private JTextField tbx_MatKhau;
	private JButton btnDangNhap;
	private JLabel lbl_ThongBao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void GiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 548);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0102NG NH\u1EACP ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setBounds(33, 13, 251, 83);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0110\u0103ng Nh\u1EADp");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(43, 106, 128, 32);
		contentPane.add(lblNewLabel_1);
		
		tbx_DangNhap = new JTextField();
		tbx_DangNhap.setFont(new Font("Arial", Font.PLAIN, 15));
		tbx_DangNhap.setBounds(181, 101, 239, 46);
		contentPane.add(tbx_DangNhap);
		tbx_DangNhap.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(38, 182, 133, 32);
		contentPane.add(lblNewLabel_1_1);
		
		tbx_MatKhau = new JTextField();
		tbx_MatKhau.setFont(new Font("Arial", Font.PLAIN, 15));
		tbx_MatKhau.setColumns(10);
		tbx_MatKhau.setBounds(181, 177, 239, 46);
		contentPane.add(tbx_MatKhau);
		
		lbl_ThongBao = new JLabel("");
		lbl_ThongBao.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ThongBao.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_ThongBao.setForeground(new Color(255, 0, 0));
		lbl_ThongBao.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 26));
		lbl_ThongBao.setBounds(23, 279, 491, 59);
		contentPane.add(lbl_ThongBao);
		
		btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 14));
		btnDangNhap.setBackground(Color.WHITE);
		btnDangNhap.setBounds(224, 246, 142, 36);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(DangNhap.class.getResource("/Image/898581532-9b1b3e4fd6bcb985f65cf9d32e33db845b1227b6d850048164ff081f5a11a952-d.jpg")));
		lblNewLabel_3.setBounds(0, 0, 986, 511);
		contentPane.add(lblNewLabel_3);
	}
	
	public void DieuKienDangNhap() {
		
		
		btnDangNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					NguoiDung aDung = NguoiDungDao.CheckLogin(tbx_DangNhap.getText(), tbx_MatKhau.getText());
					if(aDung != null) {
						if(aDung.getVaiTro().equals("HS")){
							SinhVien fSinhVien = new SinhVien(aDung.getUser());
							fSinhVien.setVisible(true);
						}
						else {
							TrangChuGV fChuGV = new TrangChuGV(aDung.getUser());
							fChuGV.setVisible(true);
						}
					}
					
					else {
						lbl_ThongBao.setText("Sai TK Hoac MK");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		} );
		
	}
	
	public DangNhap() {
		GiaoDien();
		DieuKienDangNhap();
		
	}
}