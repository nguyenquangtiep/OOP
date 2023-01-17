package GUI;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class SenderGUI extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SenderGUI() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã người gửi", "Tên người gửi", "Số điện thoại", "Tổng số hàng đã gửi"
			}
		));
		scrollPane.setViewportView(table);

	}

}
