package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import connection.DatabaseConnection;
import entities.Transport;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class MainFrame extends JFrame implements ActionListener {
	
	// declare variables
	private JMenuItem homeItem;
	private JMenuItem setPriceItem;
	private JMenuItem searchItem;
	private JMenuItem addItem;
	private JMenuItem updateItem;
	private JMenuItem deleteItem;
	private JMenuItem senderItem;
	private JMenuItem receiverItem;
	private JMenuItem packageItem;
	private JMenuItem revenueItem;
	private JPanel prePanel;
	private PriceSettingGUI priceFrame;
	private SearchGUI searchFrame;
	private AddGUI addFrame;
	private UpdateGUI updateFrame;
	
	DatabaseConnection dataConnect = new DatabaseConnection();
	List<Transport> transports;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		setTitle("HỆ THỐNG QUẢN LÝ ĐƠN HÀNG");
		setMinimumSize(new Dimension(1000, 650));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 599);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu homeMenu = new JMenu("Trang chủ");
		homeMenu.setBackground(new Color(255, 255, 255));
		homeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(homeMenu);
		
		homeItem = new JMenuItem("Danh sách đơn hàng");
		homeItem.addActionListener(this);
		homeItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		homeMenu.add(homeItem);
		
		setPriceItem = new JMenuItem("Thiết lập chi phí");
		setPriceItem.addActionListener(this);
		setPriceItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		homeMenu.add(setPriceItem);
		
		JMenu packageMenu = new JMenu("Quản lý đơn hàng");
		packageMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(packageMenu);
		
		searchItem = new JMenuItem("Tìm kiếm");
		searchItem.addActionListener(this);
		searchItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		packageMenu.add(searchItem);
		
		addItem = new JMenuItem("Thêm");
		addItem.addActionListener(this);
		addItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		packageMenu.add(addItem);
		
		updateItem = new JMenuItem("Sửa");
		updateItem.addActionListener(this);
		updateItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		packageMenu.add(updateItem);
		
		deleteItem = new JMenuItem("Xóa");
		deleteItem.addActionListener(this);
		deleteItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		packageMenu.add(deleteItem);
		
		JMenu customerMenu = new JMenu("Khách hàng");
		customerMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(customerMenu);
		
		senderItem = new JMenuItem("Người gửi");
		senderItem.addActionListener(this);
		senderItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		customerMenu.add(senderItem);
		
		receiverItem = new JMenuItem("Người nhận");
		receiverItem.addActionListener(this);
		receiverItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		customerMenu.add(receiverItem);
		
		JMenu statisticMenu = new JMenu("Thống kê");
		statisticMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(statisticMenu);
		
		packageItem = new JMenuItem("Đơn hàng");
		packageItem.addActionListener(this);
		packageItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		statisticMenu.add(packageItem);
		
		revenueItem = new JMenuItem("Doanh thu");
		revenueItem.addActionListener(this);
		revenueItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		statisticMenu.add(revenueItem);
		
		prePanel = new HomeGUI();
		getContentPane().add(prePanel);
		
	}

	public JPanel getPrePanel() {
		return prePanel;
	}

	public void setPrePanel(JPanel prePanel) {
		this.prePanel = prePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// show package list
		if (e.getSource() == homeItem) {
			remove(prePanel);
			prePanel = new HomeGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		// show price setting frame
		if (e.getSource() == setPriceItem) {
			if (priceFrame == null || priceFrame.isVisible() == false) {
				priceFrame = new PriceSettingGUI();
			}
			priceFrame.setVisible(true);
		}
		
		// show search frame
		if (e.getSource() == searchItem) {
			if (searchFrame == null || searchFrame.isVisible() == false) {
				searchFrame = new SearchGUI(this);
			}
			searchFrame.setVisible(true);
		}
		
		// show add frame
		if (e.getSource() == addItem) {
			if (addFrame == null || addFrame.isVisible() == false) {
				addFrame = new AddGUI(this);
			}
			addFrame.setVisible(true);
		}
		
		// show update frame
		if (e.getSource() == updateItem) {
			String input = JOptionPane.showInputDialog(this, "Nhập mã đơn hàng cần sửa", null, JOptionPane.QUESTION_MESSAGE);
			
			// check if there is nothing data input
			if (input != null && !input.isEmpty()) {
				
				// check input must be a number
				Pattern pattern = Pattern.compile("\\d*");
		        Matcher matcher = pattern.matcher(input);
		        if (matcher.matches()) {
		        	int id = Integer.parseInt(input);
		        	
		        	// check if database contain id
		        	if (dataConnect.checkById(id)) {
		        		
		        		// showing update frame
		        		remove(prePanel);
		        		prePanel = new HomeGUI();
		        		add(prePanel);
		        		revalidate();
		        		if (updateFrame == null || updateFrame.isVisible() == false) {
							updateFrame = new UpdateGUI(id, this);
						}
						updateFrame.setVisible(true);
		        	}
		        	else {
		        		JOptionPane.showMessageDialog(this, "Mã đơn hàng không đúng !", null, JOptionPane.ERROR_MESSAGE);
		        	}
		        }
		        else {
		        	JOptionPane.showMessageDialog(this, "Mã đơn hàng phải là chữ số !", null, JOptionPane.ERROR_MESSAGE);
		        }
			}
		}
		
		// delete function
		if (e.getSource() == deleteItem) {
			String input = JOptionPane.showInputDialog(this, "Nhập mã đơn hàng muốn xóa", null, JOptionPane.QUESTION_MESSAGE);
			
			// check if there is nothing data input
			if (input != null && !input.isEmpty()) {
				
				// check input must be a number
				Pattern pattern = Pattern.compile("\\d*");
		        Matcher matcher = pattern.matcher(input);
		        if (matcher.matches()) {
		        	int id = Integer.parseInt(input);
		        	
		        	// check if database contain id
		        	if (dataConnect.checkById(id)) {
		        		
		        		// delete package from database and reload frame
		        		dataConnect.deleteById(id);
		        		JOptionPane.showMessageDialog(this, "Đơn hàng mã " + input + " đã bị xóa !", null, JOptionPane.INFORMATION_MESSAGE);
		        		remove(prePanel);
		        		prePanel = new HomeGUI();
		        		add(prePanel);
		        		revalidate();
		        	}
		        	else {
		        		JOptionPane.showMessageDialog(this, "Mã đơn hàng không đúng !", null, JOptionPane.ERROR_MESSAGE);
		        	}
		        }
		        else {
		        	JOptionPane.showMessageDialog(this, "Mã đơn hàng phải là chữ số !", null, JOptionPane.ERROR_MESSAGE);
		        }
			}
		}
		
		// show sender
		if (e.getSource() == senderItem) {
			remove(prePanel);
			prePanel = new SenderGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		// show receiver
		if (e.getSource() == receiverItem) {
			remove(prePanel);
			prePanel = new ReceiverGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		// show order statistics
		if (e.getSource() == packageItem) {
			remove(prePanel);
			prePanel = new PackageGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		// show revenue statistics 
		if (e.getSource() == revenueItem) {
			remove(prePanel);
			prePanel = new RevenueGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
	}

}
