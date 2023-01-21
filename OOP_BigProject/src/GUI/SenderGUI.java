package GUI;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import connection.DatabaseConnection;
import entities.Sender;

public class SenderGUI extends JPanel {
	private JTable table;
	private DatabaseConnection databaseConnection = new DatabaseConnection();

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
			testData(),
			new String[] {
				"STT", "Mã người gửi", "Tên người gửi", "Số điện thoại", "Tổng số hàng đã gửi"
			}
		));
		scrollPane.setViewportView(table);

	}

	@SuppressWarnings("unchecked")
	public Object[][] testData()
	{
		List<Sender> senders = (List<Sender>)databaseConnection.testSelect()[0][1];
		int i=0;
		Object[][] objects = new Object[senders.size()][5];
		for (Sender sender : senders)
		{
			objects[i][0] = i+1;
			objects[i][1] = sender.getId();
			objects[i][2] = sender.getName();
			objects[i][3] = sender.getPhoneNumber();
			objects[i++][4] = sender.getPackageSend().size();
		}

		return  objects;
	}

}
