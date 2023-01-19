package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class AddGUI extends JFrame {

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
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public AddGUI() {
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
		
		receiverNameTF = new JTextField();
		receiverNameTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		receiverNameTF.setColumns(10);
		
		receiverPhoneTF = new JTextField();
		receiverPhoneTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		receiverPhoneTF.setColumns(10);
		
		receiverAddressTF = new JTextField();
		receiverAddressTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		receiverAddressTF.setColumns(10);
		
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
									.addComponent(receiverNameTF, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(receiverPhoneLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(receiverPhoneTF, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(receiverAddressLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(receiverAddressTF, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))))
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
						.addComponent(receiverNameTF, Alignment.LEADING)
						.addComponent(receiverNameLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(receiverPhoneLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(receiverPhoneTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(receiverAddressTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(receiverAddressLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JButton saveBtn = new JButton("Lưu");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton deleteBtn = new JButton("Xóa");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton cancelBtn = new JButton("Hủy");
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
							.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
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
								.addComponent(saveBtn, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
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
		
		packageNameTF = new JTextField();
		packageNameTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		packageNameTF.setColumns(10);
		
		packageWeightTF = new JTextField();
		packageWeightTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		packageWeightTF.setColumns(10);
		
		distanceTF = new JTextField();
		distanceTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		distanceTF.setColumns(10);
		
		JRadioButton roadRdbtn = new JRadioButton("Đường bộ");
		buttonGroup.add(roadRdbtn);
		roadRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton airlineRdbtn = new JRadioButton("Đường hàng không");
		buttonGroup.add(airlineRdbtn);
		airlineRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel receiveDateLbl = new JLabel("Ngày lấy hàng");
		receiveDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel sendDateLbl = new JLabel("Ngày giao hàng");
		sendDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		DateTimePicker receiveDTP = new DateTimePicker();
		receiveDTP.getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		receiveDTP.getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		DateTimePicker sendDTP = new DateTimePicker();
		sendDTP.getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
		sendDTP.getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 14));
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
											.addComponent(sendDTP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
											.addComponent(receiveDateLbl, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
											.addComponent(receiveDTP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
												.addComponent(packageNameTF, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
												.addComponent(packageWeightTF, 222, 222, 222)
												.addComponent(distanceTF, 222, 222, 222))))
									.addGap(228))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(86)
							.addComponent(roadRdbtn)
							.addGap(43)
							.addComponent(airlineRdbtn, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(packageNameTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(packageWeightTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(packageWeightLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(distanceLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(distanceTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(transferLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(roadRdbtn)
						.addComponent(airlineRdbtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(receiveDTP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(receiveDateLbl, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(sendDateLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(sendDTP, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
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
		
		senderNameTF = new JTextField();
		senderNameTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senderNameTF.setColumns(10);
		
		senderPhoneTF = new JTextField();
		senderPhoneTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senderPhoneTF.setColumns(10);
		
		senderAddressTF = new JTextField();
		senderAddressTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senderAddressTF.setColumns(10);
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
									.addComponent(senderNameTF, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(senderPhoneLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(senderPhoneTF, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(senderAddressLbl, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(senderAddressTF, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(senderLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(senderNameTF, Alignment.LEADING)
						.addComponent(senderNameLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(senderPhoneLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(senderPhoneTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(senderAddressTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(senderAddressLbl, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
