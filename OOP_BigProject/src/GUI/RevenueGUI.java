package GUI;

import java.awt.Color;
import java.awt.Font;

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

public class RevenueGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public RevenueGUI() {
setBackground(new Color(255, 255, 255));
		
		JFreeChart barChart = ChartFactory.createBarChart(
		         "THỐNG KÊ DOANH THU",
		         "Ngày",
		         "Tổng doanh thu",
		         null,
		         PlotOrientation.VERTICAL,
		         true, true, false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setZoomInFactor(1.0);
		
		JLabel fromDateLbl = new JLabel("Từ ngày");
		fromDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel toDateLbl = new JLabel("Đến ngày");
		toDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		DatePicker fromDatePicker = new DatePicker();
		
		DatePicker toDatePicker = new DatePicker();
		
		JButton confirmtBtn = new JButton("Xác nhận");
		confirmtBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(fromDateLbl, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fromDatePicker, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addComponent(toDateLbl, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(toDatePicker, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addComponent(confirmtBtn, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(confirmtBtn, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(toDateLbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(fromDatePicker, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(fromDateLbl, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(toDatePicker, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(27)
					.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

}
