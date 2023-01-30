package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.List;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import connection.DatabaseConnection;
import entities.Receiver;
import entities.Transport;

public class ReceiverGUI extends JPanel {
	private JTable table;
	private DatabaseConnection databaseConnection = new DatabaseConnection();

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
			testData(),
			new String[] {
				"STT", "Mã người nhận", "Tên người nhận", "Số điện thoại", "Tổng số hàng đã nhận", "Tổng chi phí"
			}
		));
		scrollPane.setViewportView(table);
	}

	@SuppressWarnings("unchecked")
	public Object[][] testData()
	{
		Object[][] objectAncestor = databaseConnection.testSelect();
		List<Receiver> receivers = (List<Receiver>)objectAncestor[0][2];
		List<Transport> transports = (List<Transport>)objectAncestor[0][0];
		int i = 0; double total = 0;
		Object[][] objects = new Object[receivers.size()][6];
		List<Integer> packageReceiveList;
		for (Receiver receiver : receivers)
		{
			objects[i][0] = i+1;
			objects[i][1] = receiver.getId();
			objects[i][2] = receiver.getName();
			objects[i][3] = receiver.getPhoneNumber();
			packageReceiveList = receiver.getPackageReceive();
			objects[i][4] = packageReceiveList.size();
			for (int packageid : packageReceiveList)
				for (Transport transport : transports)
				{
					if (packageid == transport.getPackageTransport().getId())
					{
						total+=transport.getFee();
					}
				}
			objects[i++][5] = new BigDecimal(total);
			total=0;
		}

		return objects;
	}

}
