package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class HomeGUI extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public HomeGUI() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã đơn hàng", "Tên hàng", "Tên người gửi", "Tên người nhận", "Địa chỉ nhận", "Khoảng cách", "Hình thức", "Chi phí"
			}
		));
		scrollPane.setViewportView(table);

	}

}
