package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField customerTF;
	private JTextField addressTF;
	private JTextField priceTF;
	private JButton searchBtn, cancelBtn;

	/**
	 * Create the frame.
	 */
	public SearchGUI() {
		setTitle("Tìm kiếm đơn hàng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 727, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel customerLabel = new JLabel("Tên khách hàng");
		customerLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel addressLabel = new JLabel("Địa chỉ nhận hàng");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel priceLabel = new JLabel("Chi phí lớn hơn");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		customerTF = new JTextField();
		customerTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		customerTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addressTF.setColumns(10);
		
		priceTF = new JTextField();
		priceTF.setFont(new Font("Tahoma", Font.PLAIN, 19));
		priceTF.setColumns(10);
		
		searchBtn = new JButton("Tìm kiếm");
		searchBtn.addActionListener(this);
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cancelBtn = new JButton("Hủy");
		cancelBtn.addActionListener(this);
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(priceTF, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(addressTF, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(customerLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(customerTF, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(122)
							.addComponent(searchBtn, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(99)
							.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(customerLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(customerTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(addressTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(priceTF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(searchBtn, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchBtn) {
			
		}
		
		if (e.getSource() == cancelBtn) {
			setVisible(false);
		}
	}
}
