package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import com.github.lgooddatepicker.components.DateTimePicker;

import connection.DatabaseConnection;
import entities.Address;
import entities.Receiver;
import entities.Sender;
import entities.Transport;
import entities.Package;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField senderNameTF;
	private JTextField senderPhoneTF;
	private JTextField senderAddressTF;
	private JTextField receiverNameTF;
	private JTextField receiverPhoneTF;
	private JTextField receiverAddressTF;
	private JTextField packageNameTF;
	private JTextField packageWeightTF;
	private JTextField distanceTF;
	private JRadioButton roadRdbtn, airlineRdbtn;
	private JButton saveBtn, deleteBtn, cancelBtn;
	private DateTimePicker receiveDTP, sendDTP;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	Sender sender;
	Receiver receiver;
	Package packageTransport;
	Transport transport;
	DatabaseConnection dataConnect = new DatabaseConnection();
	MainFrame frame;

	/**
	 * Create the frame.
	 */
	public AddGUI(MainFrame frame) {
		
		this.frame = frame;
		
		setTitle("Thêm đơn hàng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setName("");
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("");
		
		JLabel receiverAddressLbl = new JLabel("Địa chỉ giao hàng");
		receiverAddressLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setReceiverNameTF(new JTextField());
		getReceiverNameTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getReceiverNameTF().setColumns(10);
		
		setReceiverPhoneTF(new JTextField());
		getReceiverPhoneTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getReceiverPhoneTF().setColumns(10);
		
		setReceiverAddressTF(new JTextField());
		getReceiverAddressTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getReceiverAddressTF().setColumns(10);
		
		JLabel receiverLabel = new JLabel("Thông tin người nhận");
		receiverLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel receiverNameLbl = new JLabel("Tên người nhận");
		receiverNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel receiverPhoneLbl = new JLabel("Số điện thoại");
		receiverPhoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(receiverNameLbl, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(getReceiverNameTF(), GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(receiverPhoneLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(getReceiverPhoneTF(), GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(receiverAddressLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(getReceiverAddressTF(), GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(receiverLabel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(receiverLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(getReceiverNameTF(), Alignment.LEADING)
						.addComponent(receiverNameLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(receiverPhoneLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(getReceiverPhoneTF(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(getReceiverAddressTF(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(receiverAddressLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		
		setSaveBtn(new JButton("Lưu"));
		getSaveBtn().addActionListener(this);
		getSaveBtn().setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setDeleteBtn(new JButton("Xóa"));
		getDeleteBtn().addActionListener(this);
		getDeleteBtn().setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setCancelBtn(new JButton("Hủy"));
		getCancelBtn().addActionListener(this);
		getCancelBtn().setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(getSaveBtn(), GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(getDeleteBtn(), GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getCancelBtn(), GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(getSaveBtn(), GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(getCancelBtn(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addComponent(getDeleteBtn(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
							.addGap(25)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JLabel packageLabel = new JLabel("Thông tin đơn hàng");
		packageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel packageNameLbl = new JLabel("Tên hàng");
		packageNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel packageWeightLbl = new JLabel("Cân nặng (kg)");
		packageWeightLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel distanceLabel = new JLabel("Khoảng cách (km)");
		distanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel transferLabel = new JLabel("Hình thức vận chuyển");
		transferLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setPackageNameTF(new JTextField());
		getPackageNameTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getPackageNameTF().setColumns(10);
		
		setPackageWeightTF(new JTextField());
		getPackageWeightTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getPackageWeightTF().setColumns(10);
		
		setDistanceTF(new JTextField());
		getDistanceTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getDistanceTF().setColumns(10);
		
		setRoadRdbtn(new JRadioButton("Đường bộ"));
		getButtonGroup().add(getRoadRdbtn());
		getRoadRdbtn().setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		setAirlineRdbtn(new JRadioButton("Đường hàng không"));
		getButtonGroup().add(getAirlineRdbtn());
		getAirlineRdbtn().setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel receiveDateLbl = new JLabel("Ngày lấy hàng");
		receiveDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel sendDateLbl = new JLabel("Ngày giao hàng");
		sendDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setReceiveDTP(new DateTimePicker());
		getReceiveDTP().getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getReceiveDTP().getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		setSendDTP(new DateTimePicker());
		getSendDTP().getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getSendDTP().getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(packageLabel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(transferLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addComponent(sendDateLbl, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
											.addComponent(getSendDTP(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
											.addComponent(receiveDateLbl, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
											.addComponent(getReceiveDTP(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel_2.createSequentialGroup()
													.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
														.addComponent(packageWeightLbl, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
														.addComponent(packageNameLbl, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
												.addGroup(gl_panel_2.createSequentialGroup()
													.addComponent(distanceLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
													.addGap(18)))
											.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addComponent(getPackageNameTF(), GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
												.addComponent(getPackageWeightTF(), 222, 222, 222)
												.addComponent(getDistanceTF(), 222, 222, 222))))
									.addGap(228))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(86)
							.addComponent(getRoadRdbtn())
							.addGap(43)
							.addComponent(getAirlineRdbtn(), GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(packageLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(packageNameLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(getPackageNameTF(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(getPackageWeightTF(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(packageWeightLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(distanceLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(getDistanceTF(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(transferLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(getRoadRdbtn())
						.addComponent(getAirlineRdbtn(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(getReceiveDTP(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(receiveDateLbl, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(sendDateLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(getSendDTP(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel senderLabel = new JLabel("Thông tin người gửi");
		senderLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel senderNameLbl = new JLabel("Tên người gửi");
		senderNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel senderPhoneLbl = new JLabel("Số điện thoại");
		senderPhoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel senderAddressLbl = new JLabel("Địa chỉ lấy hàng");
		senderAddressLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		setSenderNameTF(new JTextField());
		getSenderNameTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getSenderNameTF().setColumns(10);
		
		setSenderPhoneTF(new JTextField());
		getSenderPhoneTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getSenderPhoneTF().setColumns(10);
		
		setSenderAddressTF(new JTextField());
		getSenderAddressTF().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getSenderAddressTF().setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(senderLabel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(senderNameLbl, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(getSenderNameTF(), GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(senderPhoneLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(getSenderPhoneTF(), GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(senderAddressLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(getSenderAddressTF(), GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(senderLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(getSenderNameTF(), Alignment.LEADING)
						.addComponent(senderNameLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(senderPhoneLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(getSenderPhoneTF(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(getSenderAddressTF(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(senderAddressLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getSaveBtn()) {
			String senderName, senderPhone, senderAddress, receiverName, receiverPhone, receiverAddress,
			packageName, packageWeight, distance, transportType = null, receiveTime, receiveDate, sendDate, sendTime;
			senderName = getSenderNameTF().getText();
			senderPhone = getSenderPhoneTF().getText();
			senderAddress = getSenderAddressTF().getText();
			receiverName = getReceiverNameTF().getText();
			receiverPhone = getReceiverPhoneTF().getText();
			receiverAddress = getReceiverAddressTF().getText();
			packageName = getPackageNameTF().getText();
			packageWeight = getPackageWeightTF().getText();
			distance = getDistanceTF().getText();
			if (getRoadRdbtn().isSelected()) {
				transportType = "road";
			}
			else if (getAirlineRdbtn().isSelected()) {
				transportType = "air";
			}
			receiveTime = getReceiveDTP().getTimePicker().toString();
			receiveDate = getReceiveDTP().getDatePicker().toString();
			sendDate = getSendDTP().getDatePicker().toString();
			sendTime = getSendDTP().getTimePicker().toString();
			
			Pattern pattern = Pattern.compile("\\d*");
	        Matcher matcher1, matcher2;
	        matcher1 = pattern.matcher(packageWeight);
	        matcher2 = pattern.matcher(distance);
			
			if (senderName.isEmpty() || senderName.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Tên người gửi !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (senderPhone.isEmpty() || senderPhone.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Số điện thoại người gửi !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (senderAddress.isEmpty() || senderAddress.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Địa chỉ lấy hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (receiverName.isEmpty() || receiverName.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Tên người nhận !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (receiverPhone.isEmpty() || receiverPhone.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Số điện thoại người nhận !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (receiverAddress.isEmpty() || receiverAddress.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Địa chỉ giao hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (packageName.isEmpty() || packageName.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Tên gói hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (packageWeight.isEmpty() || packageWeight.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Số cân nặng của gói hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (distance.isEmpty() || distance.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Khoảng cách gửi !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (transportType == null) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Loại hình vận chuyển !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (receiveDate.isEmpty() || receiveDate.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày lấy hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (receiveTime.isEmpty() || receiveTime.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Thời gian lấy hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (sendDate.isEmpty() || sendDate.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Ngày giao hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (sendTime.isEmpty() || sendTime.isBlank()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Thời gian giao hàng !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (!matcher1.matches()){
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Cân nặng là kiểu số !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (!matcher2.matches()){
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Khoảng cách là kiểu số !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				sender = new Sender(0, senderName, senderPhone, new Address(0, senderAddress));
				receiver = new Receiver(0, receiverName, receiverPhone, new Address(0, receiverAddress));
				packageTransport = new Package(0, packageName, Float.parseFloat(packageWeight));
				transport = new Transport(sender, receiver, 0, transportType, receiveDate+" "+receiveTime+":00",
						sendDate+" "+sendTime+":00", "On Going", Float.parseFloat(distance), packageTransport);
				dataConnect.addTransport(sender, receiver, packageTransport, transport);
				setVisible(false);
				frame.remove(frame.getPrePanel());
				frame.setPrePanel(new HomeGUI());
				frame.add(frame.getPrePanel());
				frame.revalidate();
			}
		}
		
		if (e.getSource() == getDeleteBtn()) {
			getSenderNameTF().setText(null);
			getSenderPhoneTF().setText(null);
			getSenderAddressTF().setText(null);
			getReceiverNameTF().setText(null);
			getReceiverPhoneTF().setText(null);
			getReceiverAddressTF().setText(null);
			getPackageNameTF().setText(null);
			getPackageWeightTF().setText(null);
			getDistanceTF().setText(null);
			getReceiveDTP().getDatePicker().setText(null);
			getReceiveDTP().getTimePicker().setText(null);
			getSendDTP().getDatePicker().setText(null);
			getSendDTP().getTimePicker().setText(null);
			getButtonGroup().clearSelection();
		}
		
		if (e.getSource() == getCancelBtn()) {
			setVisible(false);
		}
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}

	public JTextField getSenderNameTF() {
		return senderNameTF;
	}

	public void setSenderNameTF(JTextField senderNameTF) {
		this.senderNameTF = senderNameTF;
	}

	public JTextField getSenderPhoneTF() {
		return senderPhoneTF;
	}

	public void setSenderPhoneTF(JTextField senderPhoneTF) {
		this.senderPhoneTF = senderPhoneTF;
	}

	public JTextField getSenderAddressTF() {
		return senderAddressTF;
	}

	public void setSenderAddressTF(JTextField senderAddressTF) {
		this.senderAddressTF = senderAddressTF;
	}

	public JTextField getReceiverNameTF() {
		return receiverNameTF;
	}

	public void setReceiverNameTF(JTextField receiverNameTF) {
		this.receiverNameTF = receiverNameTF;
	}

	public JTextField getReceiverPhoneTF() {
		return receiverPhoneTF;
	}

	public void setReceiverPhoneTF(JTextField receiverPhoneTF) {
		this.receiverPhoneTF = receiverPhoneTF;
	}

	public JTextField getReceiverAddressTF() {
		return receiverAddressTF;
	}

	public void setReceiverAddressTF(JTextField receiverAddressTF) {
		this.receiverAddressTF = receiverAddressTF;
	}

	public JTextField getPackageNameTF() {
		return packageNameTF;
	}

	public void setPackageNameTF(JTextField packageNameTF) {
		this.packageNameTF = packageNameTF;
	}

	public JTextField getPackageWeightTF() {
		return packageWeightTF;
	}

	public void setPackageWeightTF(JTextField packageWeightTF) {
		this.packageWeightTF = packageWeightTF;
	}

	public JTextField getDistanceTF() {
		return distanceTF;
	}

	public void setDistanceTF(JTextField distanceTF) {
		this.distanceTF = distanceTF;
	}

	public JRadioButton getRoadRdbtn() {
		return roadRdbtn;
	}

	public void setRoadRdbtn(JRadioButton roadRdbtn) {
		this.roadRdbtn = roadRdbtn;
	}

	public JRadioButton getAirlineRdbtn() {
		return airlineRdbtn;
	}

	public void setAirlineRdbtn(JRadioButton airlineRdbtn) {
		this.airlineRdbtn = airlineRdbtn;
	}

	public DateTimePicker getReceiveDTP() {
		return receiveDTP;
	}

	public void setReceiveDTP(DateTimePicker receiveDTP) {
		this.receiveDTP = receiveDTP;
	}

	public DateTimePicker getSendDTP() {
		return sendDTP;
	}

	public void setSendDTP(DateTimePicker sendDTP) {
		this.sendDTP = sendDTP;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(JButton cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
}
