package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.List;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import connection.DatabaseConnection;
import entities.Transport;

public class HomeGUI extends JPanel {
	private JTable table;
	private DatabaseConnection databaseConnection = new DatabaseConnection();
	/**
	 * Create the panel.
	 */
	public HomeGUI() {
		System.out.println("Processing");
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			dataTest(),
			new String[] {
			"STT", "Mã đơn hàng", "Tên hàng", "Tên người gửi", "Tên người nhận", "Địa chỉ nhận", "Khoảng cách", "Hình thức", "Chi phí"}
		));
		scrollPane.setViewportView(table);

		add(scrollPane, "cell 0 0,grow");
	}

	public Object[][] dataTest()
	{
		
		List<Transport> transports = databaseConnection.testSelect();
		int i = 0;
		Object[][] objects = new Object[transports.size()][];
		Object[] object = new Object[9];
		for (Transport transport : transports)
		{
			object[0] = i+1;
			object[1] = transport.getPackageTransport().getId();
			object[2] = transport.getPackageTransport().getDescription();
			object[3] = transport.getSender().getName();
			object[4] = transport.getReceiver().getName();
			object[5] = transport.getReceiver().getAddress().getLocation();
			object[6] = transport.getDistance();
			object[7] = transport.getTransportType();
			object[8] = transport.getFee();
			objects[i++] = object;
		}

		return objects;
	}

}
