package FileGiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DanhMuc.ThoiKhoaBieu;
import DanhMucBean.ChuyenManHinhController;
import DanhMucBean.DanhMucBean;
import DanhMucBean.LayTaiKhoan;

import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangChuGV extends JFrame {

	private JPanel contentPane;
	private JLabel Trangchu;
	private JPanel TrangChu;
	JPanel jpnView;
	JLabel lblQLyLop;
	JPanel QuanLiLop;
	JPanel ThongKe;
	JPanel LichHoc;
	JLabel lblLichHoc;
	JLabel lblThongKe;
	JLabel lbl_HoTen;
	private String User;
	private ChuyenManHinhController controller;	
	public void GiaoDien() {
		setBounds(100, 100, 1096, 666);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		JPanel logo = new JPanel();
		 logo.setBounds(0, -1, 310, 125);
		 contentPane.add(logo);
		 logo.setBackground(new Color(255, 127, 80));
		 logo.setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("  KHOA TH\u1EC2 CH\u1EA4T");
		 lblNewLabel.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/balltrang.png")));
		 lblNewLabel.setForeground(new Color(245, 245, 220));
		 lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		 lblNewLabel.setBounds(10, 10, 287, 100);
		 logo.add(lblNewLabel);
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(0, -1, 310, 647);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 
		 JPanel panel_2 = new JPanel();
		 panel_2.setBounds(0, 122, 310, 515);
		 panel.add(panel_2);
		 panel_2.setBackground(new Color(105, 105, 105));
		 panel_2.setLayout(null);
		 
		 TrangChu = new JPanel();
		 TrangChu.setBackground(new Color(34, 139, 34));
		 TrangChu.setBounds(35, 34, 209, 79);
		 TrangChu.setBackground(new Color(76, 175, 80));
		 panel_2.add(TrangChu);
		 TrangChu.setLayout(null);
		 
		  Trangchu = new JLabel("  TRANG CH\u1EE6");
		  Trangchu.setHorizontalAlignment(SwingConstants.LEFT);
		  Trangchu.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/iconmonstr-home-7-32 (1).png")));
		  Trangchu.setFont(new Font("Arial", Font.BOLD, 17));
		  Trangchu.setForeground(new Color(245, 255, 250));
		  
		  Trangchu.setBounds(10, 10, 206, 59);
		  TrangChu.add(Trangchu);
		  
		  QuanLiLop = new JPanel();
		  QuanLiLop.setBounds(35, 150, 209, 79);
		  QuanLiLop.setBackground(new Color(76, 175, 80));
		  panel_2.add(QuanLiLop);
		  QuanLiLop.setLayout(null);
		  
		  lblQLyLop = new JLabel("  QU\u1EA2N L\u00DD L\u1EDAP");
		  
		  lblQLyLop.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/QLY32.png")));
		  lblQLyLop.setHorizontalAlignment(SwingConstants.LEFT);
		  lblQLyLop.setForeground(new Color(245, 255, 250));
		  lblQLyLop.setFont(new Font("Arial", Font.BOLD, 17));
		  lblQLyLop.setBounds(10, 10, 164, 59);
		  QuanLiLop.add(lblQLyLop);
		  
		  LichHoc = new JPanel();
		  LichHoc.setBounds(35, 269, 209, 79);
		  LichHoc.setBackground(new Color(76, 175, 80));
		  panel_2.add(LichHoc);
		  LichHoc.setLayout(null);
		  
		  lblLichHoc = new JLabel("  L\u1ECACH H\u1ECCC");
		  lblLichHoc.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/CALENDAR.png")));
		  lblLichHoc.setHorizontalAlignment(SwingConstants.LEFT);
		  lblLichHoc.setForeground(new Color(245, 255, 250));
		  lblLichHoc.setFont(new Font("Arial", Font.BOLD, 17));
		  lblLichHoc.setBounds(10, 10, 158, 59);
		  LichHoc.add(lblLichHoc);
		  
		  ThongKe = new JPanel();
		  ThongKe.setBounds(35, 386, 209, 79);
		  ThongKe.setBackground(new Color(76, 175, 80));
		  panel_2.add(ThongKe);
		  ThongKe.setLayout(null);
		  
		  lblThongKe = new JLabel("  TH\u1ED0NG K\u00CA");
		  lblThongKe.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/ThongKe.png")));
		  lblThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		  lblThongKe.setForeground(new Color(245, 255, 250));
		  lblThongKe.setFont(new Font("Arial", Font.BOLD, 20));
		  lblThongKe.setBounds(10, 10, 176, 59);
		  ThongKe.add(lblThongKe);
		  
		  jpnView = new JPanel();
		  jpnView.setBounds(308, 72, 774, 557);
		  contentPane.add(jpnView);
	}
	public void DanhMuc() {
		controller = new ChuyenManHinhController(jpnView); 
		controller.setView(TrangChu, Trangchu);
		List<DanhMucBean> list = new ArrayList<>();
		list.add(new DanhMucBean("TrangChu", TrangChu, Trangchu));
		list.add(new DanhMucBean("QLSV", QuanLiLop, lblQLyLop));
		list.add(new DanhMucBean("ThoiKhoaBieu", LichHoc, lblLichHoc));
		list.add(new DanhMucBean("ThongKe", ThongKe, lblThongKe));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(308, -1, 774, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl_HoTen = new JLabel("H\u1ECD V\u00E0 T\u00EAn");
		lbl_HoTen.setIcon(new ImageIcon(TrangChuGV.class.getResource("/Image/iconmonstr-user-19-48.png")));
		lbl_HoTen.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_HoTen.setBounds(364, 5, 159, 56);
		panel.add(lbl_HoTen);
		
		JButton btnNewButton = new JButton("THO\u00C1T");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(627, 17, 103, 32);
		panel.add(btnNewButton);
		controller.SetEven(list);
	}
	public void SetTaiKhoanSinhVien() throws SQLException {
		String string = LayTaiKhoan.Vaitro(User);
		if(string != null) {
			lbl_HoTen.setText(string);
		}
		else {
			lbl_HoTen.setText("Khoa");
		}
	}
	public TrangChuGV(String User) throws SQLException {
		this.User = User;
		GiaoDien();
		DanhMuc();
		SetTaiKhoanSinhVien();
		
		 
		 
	}
}
