package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ReceiverGUI extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ReceiverGUI() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã người nhận", "Tên người nhận", "Số điện thoại", "Tổng số hàng đã nhận", "Tổng chi phí"
			}
		));
		scrollPane.setViewportView(table);

	}

}
