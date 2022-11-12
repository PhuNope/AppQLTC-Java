package DanhMuc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class DangKyLichHoc extends JPanel {

	/**
	 * Create the panel.
	 */
	public DangKyLichHoc() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 764, 630);
		add(panel_1);
		panel_1.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 764, 630);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ch\u00E1o M\u1EEBng \u0111\u1EBFn v\u1EDBi free fire");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 764, 596);
		panel.add(lblNewLabel);
	}

}
