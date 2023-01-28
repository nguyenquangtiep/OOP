package GUI;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.Address;
import entities.Package;
import entities.Receiver;
import entities.Sender;
import entities.Transport;

public class UpdateGUI extends AddGUI {

	private static MainFrame frame;
	private JPanel contentPane;
	private int id;

	/**
	 * Create the frame.
	 */
	public UpdateGUI(int id) {
		super(frame);
		this.id = id;
		setTitle("Sửa đơn hàng");
	}
	
	public void showInfo() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
}
