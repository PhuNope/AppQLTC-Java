package DanhMuc;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

public class ThongKe extends JPanel {
	JPanel panel;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ThongKe() {
		setLayout(null);
		setBounds(0, 0, 764, 556);
		panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 764, 557);
		add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(53, 31, 643, 235);
		panel.add(table);
	}
}
