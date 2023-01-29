package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import com.github.lgooddatepicker.components.DatePicker;

public class RevenueGUI extends JPanel implements ActionListener {
	
	private JButton confirmBtn;
	private DatePicker fromDatePicker;
	private DatePicker toDatePicker;
	private JFreeChart barChart;
	private ChartPanel chartPanel;
	
	/**
	 * Create the panel.
	 */
	public RevenueGUI() {
		setBackground(new Color(255, 255, 255));
		
		barChart = ChartFactory.createBarChart(
		         "THỐNG KÊ DOANH THU",
		         "Ngày",
		         "Tổng doanh thu",
		         null,
		         PlotOrientation.VERTICAL,
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
		
		JButton confirmBtn = new JButton("Xác nhận");
		confirmBtn.setFocusable(false);
		confirmBtn.addActionListener(this);
		confirmBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(fromDateLbl, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fromDatePicker, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(68)
					.addComponent(toDateLbl, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toDatePicker, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(125)
					.addComponent(confirmBtn, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(confirmBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(toDateLbl, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(fromDatePicker, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(fromDateLbl, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(toDatePicker, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == confirmBtn) {
			String fromDate, toDate;
			fromDate = fromDatePicker.getDate().toString();
			toDate = toDatePicker.getDate().toString();
			if (fromDate != null && toDate != null) {
				System.out.println("Từ ngày " + fromDate + " đến ngày " + toDate);
			}
		}
	}

}
