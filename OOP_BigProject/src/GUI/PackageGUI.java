package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.lgooddatepicker.components.DatePicker;

import connection.DatabaseConnection;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;

public class PackageGUI extends JPanel implements ActionListener {
	
	private DatabaseConnection dataConnect = new DatabaseConnection();
	private JFreeChart barChart;
	private ChartPanel chartPanel;
	private DatePicker fromDatePicker;
	private DatePicker toDatePicker;
	private JButton confirmBtn;
	private List<String[]> count;

	/**
	 * Create the panel.
	 */
	public PackageGUI() {
		setBackground(new Color(255, 255, 255));
		
		barChart = ChartFactory.createBarChart(
		         "THỐNG KÊ ĐƠN HÀNG",
		         "Ngày",
		         "Tổng số đơn hàng",
		         null,
		         PlotOrientation.HORIZONTAL,
		         false, false, false);
		chartPanel = new ChartPanel(barChart);
		
		JLabel fromDateLbl = new JLabel("Từ ngày");
		fromDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel toDateLbl = new JLabel("Đến ngày");
		toDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		fromDatePicker = new DatePicker();
		fromDatePicker.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		toDatePicker = new DatePicker();
		toDatePicker.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		confirmBtn = new JButton("Xác nhận");
		confirmBtn.addActionListener(this);
		confirmBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(fromDateLbl, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fromDatePicker, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(75)
					.addComponent(toDateLbl, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toDatePicker, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(114)
					.addComponent(confirmBtn, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
					.addGap(12))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(confirmBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addComponent(toDatePicker, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addComponent(toDateLbl, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addComponent(fromDatePicker, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(fromDateLbl, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == confirmBtn) {
			String fromDate, toDate;
			fromDate = fromDatePicker.toString();
			toDate = toDatePicker.toString();
			if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
				
//				String[] s1 = fromDate.split("[- :]");
//				fromDate = s1[2]+"-"+s1[1]+"-"+s1[0];
//				
//				String[] s2 = toDate.split("[- :]");
//				toDate = s2[2]+"-"+s2[1]+"-"+s2[0];
				
				count = dataConnect.countTransportPerDayBetween(fromDate, toDate);
				
				for (int i = 0; i < count.size(); i++) {
					System.out.println(count.get(i)[0] + " and " + count.get(i)[1]);
				}
				
				System.out.println("Từ ngày [" + fromDate + "] đến ngày [" + toDate + "]");
			}
			
		}
	}
	
	
}
