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
		add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			dataTest(),
			new String[] {
			"STT", "Mã đơn hàng", "Tên hàng", "Tên người gửi", "Tên người nhận", "Địa chỉ nhận", 
			"Ngày giao hàng", "Thời gian", "Khoảng cách", "Hình thức", "Chi phí"}
		));
		scrollPane.setViewportView(table);

		
	}

	@SuppressWarnings("unchecked")
	public Object[][] dataTest()
	{
		List<Transport> transports = (List<Transport>)databaseConnection.testSelect()[0][0];
		int i = 0;
		Object[][] objects = new Object[transports.size()][9];
		for (Transport transport : transports)
		{
			objects[i][0] = i+1;
			objects[i][1] = transport.getPackageTransport().getId();
			objects[i][2] = transport.getPackageTransport().getDescription();
			objects[i][3] = transport.getSender().getName();
			objects[i][4] = transport.getReceiver().getName();
			objects[i][5] = transport.getReceiver().getAddress().getLocation();
			objects[i][6] = transport.getDistance();
			objects[i][7] = transport.getTransportType();
			objects[i++][8] = transport.getFee();
		}

		return objects;
	}

}
