package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.DatabaseConnection;
import entities.Transport;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class SearchGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField customerTF;
	private JTextField addressTF;
	private JTextField priceTF;
	private JButton searchBtn, cancelBtn;
	
	DatabaseConnection dataConnect = new DatabaseConnection();
	MainFrame frame;
	List<Transport> transports;

	/**
	 * Create the frame.
	 */
	public SearchGUI(MainFrame frame) {
		
		this.frame = frame;
		
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
		searchBtn.setFocusable(false);
		searchBtn.addActionListener(this);
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cancelBtn = new JButton("Hủy");
		cancelBtn.setFocusable(false);
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
			String customer, address, price;
			
			customer = customerTF.getText();
			address = addressTF.getText();
			price = priceTF.getText();
			
			boolean condition1, condition2, condition3;
			condition1 = (customer.isBlank() || customer.isEmpty());
			condition2 = (address.isBlank() || address.isEmpty());
			condition3 = (price.isBlank() || price.isEmpty());
			
			float fee = 0;
			Matcher matcher = null;
			
			if (!condition3) {
				Pattern pattern = Pattern.compile("\\d*");
				matcher = pattern.matcher(price);
			}
			
			
			if (condition1 && condition2 && condition3) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập một điều kiện để tìm kiếm !", null, JOptionPane.PLAIN_MESSAGE);
			}
			else if (condition1 && condition2) {
				
			    if (matcher.matches()) {
			    	fee = Float.parseFloat(price);
			    	transports = dataConnect.findByFeeGreaterThan(fee);
					if (transports.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng theo yêu cầu !", null, JOptionPane.INFORMATION_MESSAGE);
					}
			    }
			    else {
			        JOptionPane.showMessageDialog(this, "Chi phí phải là kiểu số !", null, JOptionPane.ERROR_MESSAGE);
			    }
				
			}
			else if (condition2 && condition3) {
				transports = dataConnect.findByName(customer);
				if (transports.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng theo yêu cầu !", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (condition1 && condition3) {
				transports = dataConnect.findByAddress(address);
				if (transports.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng theo yêu cầu !", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (condition1) {
				
				if (matcher.matches()) {
			    	fee = Float.parseFloat(price);
			    	transports = dataConnect.findByAddressAndFeeGreaterThan(address, fee);
					if (transports.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng theo yêu cầu !", null, JOptionPane.INFORMATION_MESSAGE);
					}
			    }
			    else {
			        JOptionPane.showMessageDialog(this, "Chi phí phải là kiểu số !", null, JOptionPane.ERROR_MESSAGE);
			    }
			}
			else if (condition2) {
				
				if (matcher.matches()) {
			    	fee = Float.parseFloat(price);
			    	transports = dataConnect.findByNameAndFeeGreaterThan(customer, fee);
					if (transports.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng theo yêu cầu !", null, JOptionPane.INFORMATION_MESSAGE);
					}
			    }
			    else {
			        JOptionPane.showMessageDialog(this, "Chi phí phải là kiểu số !", null, JOptionPane.ERROR_MESSAGE);
			    }
			}
			else if (condition3) {
				
				transports = dataConnect.findByNameAndAddress(customer, address);
				if (transports.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng theo yêu cầu !", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				
				if (matcher.matches()) {
			    	fee = Float.parseFloat(price);
			    	transports = dataConnect.findByNameAndAddressAndFeeGreaterThan(customer, address, fee);
					if (transports.isEmpty()) {
						JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng theo yêu cầu !", null, JOptionPane.INFORMATION_MESSAGE);
					}
			    }
			    else {
			        JOptionPane.showMessageDialog(this, "Chi phí phải là kiểu số !", null, JOptionPane.ERROR_MESSAGE);
			    }
			}
			if (transports != null) {
				if (!transports.isEmpty()) {
					setVisible(false);
					frame.remove(frame.getPrePanel());
					frame.setPrePanel(new HomeGUI(transports));
					frame.getContentPane().add(frame.getPrePanel());
					frame.revalidate();
				}
			}
			
			for (Transport transport: transports) {
				System.out.println(transport);
			}
		}
		
		if (e.getSource() == cancelBtn) {
			setVisible(false);
		}
	}
}
