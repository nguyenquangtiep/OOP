package GUI;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import connection.DatabaseConnection;
import entities.Address;
import entities.Package;
import entities.Receiver;
import entities.Sender;
import entities.Transport;


// Update function
public class UpdateGUI extends AddGUI {

	// declare variables
	private int id;
	DatabaseConnection dataConnect = new DatabaseConnection();
	Transport transport;
	Sender sender;
	Receiver receiver;
	Package packageTransport;

	/**
	 * Create the frame.
	 */
	public UpdateGUI(int id, MainFrame frame) {
		super(frame); // inheritance
		this.id = id;
		setTitle("Sửa đơn hàng");
		showInfo();
	}
	
	
	// method showing information from database
	public void showInfo() {
		
		// get data
		transport = dataConnect.getById(id);
		sender = transport.getSender();
		receiver = transport.getReceiver();
		packageTransport = transport.getPackageTransport();
		
		getSenderNameTF().setText(sender.getName());
		getSenderPhoneTF().setText(sender.getPhoneNumber());
		getSenderAddressTF().setText(sender.getAddress().getLocation());
		
		getReceiverNameTF().setText(receiver.getName());
		getReceiverPhoneTF().setText(receiver.getPhoneNumber());
		getReceiverAddressTF().setText(receiver.getAddress().getLocation());
		
		getPackageNameTF().setText(packageTransport.getDescription());
		getPackageWeightTF().setText(String.valueOf(packageTransport.getWeight()));
		
		getDistanceTF().setText(String.valueOf(transport.getDistance()));
		
		String transportType = transport.getTransportType();
		
		if (transportType.equalsIgnoreCase("road")) {
			getRoadRdbtn().setSelected(true);
		}
		else if (transportType.equalsIgnoreCase("air")) {
			getAirlineRdbtn().setSelected(true);
		}
		
		// format the date and time in the form "dd/MM/yyyy" and "hh:mm"
		String[] send = transport.getReceiveDateEstimation().split("[- :]");
		String[] receive = transport.getSendDate().split("[- :]");
		
		String sendDate = send[0]+"-"+send[1]+"-"+send[2];
		String sendTime = send[3]+":"+send[4];
		
		String receiveDate = receive[0]+"-"+receive[1]+"-"+receive[2];
		String receiveTime = receive[3]+":"+receive[4];
		
		// convert the formatted date to LocalDate and LocalTime
		getReceiveDTP().getDatePicker().setDate(LocalDate.parse(receiveDate));
		getReceiveDTP().getTimePicker().setTime(LocalTime.parse(receiveTime));
		getSendDTP().getDatePicker().setDate(LocalDate.parse(sendDate));
		getSendDTP().getTimePicker().setTime(LocalTime.parse(sendTime));
	}

	
	// override the same method from super class
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// save data after update
		if (e.getSource() == getSaveBtn()) {
			
			// declare variables
			String senderName, senderPhone, senderAddress, receiverName, receiverPhone, receiverAddress,
			packageName, packageWeight, distance, transportType = null, receiveTime, receiveDate, sendDate, sendTime;
			
			// get data in the frame
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
			
			// check the input must be a number
	        boolean weightFlag = false, distanceFlag = false;
	        float distanceF = 0, weightF = 0;
	        
	        try {
	        	weightF = Float.parseFloat(packageWeight);
	        }
	        catch (Exception ex) {
	        	weightFlag = true;
	        }
	        
	        try {
	        	distanceF = Float.parseFloat(distance);
	        }
	        catch (Exception ex) {
	        	distanceFlag = true;
	        }
			
	        // handle exception
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
			else if (weightFlag){
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Cân nặng là kiểu số !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if (distanceFlag){
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Khoảng cách là kiểu số !", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				sender = new Sender(0, senderName, senderPhone, new Address(0, senderAddress));
				receiver = new Receiver(0, receiverName, receiverPhone, new Address(0, receiverAddress));
				packageTransport = new Package(id, packageName, weightF);
				transport = new Transport(sender, receiver, 0, transportType, receiveDate+" "+receiveTime+":00",
						sendDate+" "+sendTime+":00", "On Going", distanceF, packageTransport);
				
				// update data and reload frame
				dataConnect.updateTransport(sender, receiver, packageTransport, transport);
				setVisible(false);
				getFrame().remove(getFrame().getPrePanel());
				getFrame().setPrePanel(new HomeGUI());
				getFrame().add(getFrame().getPrePanel());
				getFrame().revalidate();
			}
		}
		
		// clear all data in frame
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
		
		// close the update frame
		if (e.getSource() == getCancelBtn()) {
			setVisible(false);
		}
	}
}
