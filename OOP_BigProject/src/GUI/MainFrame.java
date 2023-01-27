package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class MainFrame extends JFrame implements ActionListener {
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

	/**
	 * Create the frame.
	 */
	public MainFrame() {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == homeItem) {
			remove(prePanel);
			prePanel = new HomeGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		if (e.getSource() == setPriceItem) {
			if (priceFrame == null || priceFrame.isVisible() == false) {
				priceFrame = new PriceSettingGUI();
			}
			priceFrame.setVisible(true);
		}
		
		if (e.getSource() == searchItem) {
			if (searchFrame == null || searchFrame.isVisible() == false) {
				searchFrame = new SearchGUI();
			}
			searchFrame.setVisible(true);
		}
		
		if (e.getSource() == addItem) {
			if (addFrame == null || addFrame.isVisible() == false) {
				addFrame = new AddGUI();
			}
			addFrame.setVisible(true);
		}
		
		if (e.getSource() == updateItem) {
			String input = JOptionPane.showInputDialog(this, "Nhập mã đơn hàng cần sửa", null, JOptionPane.QUESTION_MESSAGE);
			if (input != null && !input.isEmpty()) {
				if (updateFrame == null || updateFrame.isVisible() == false) {
					updateFrame = new UpdateGUI();
				}
				updateFrame.setVisible(true);
			}
		}
		
		if (e.getSource() == deleteItem) {
			String input = JOptionPane.showInputDialog(this, "Nhập mã đơn hàng muốn xóa", null, JOptionPane.QUESTION_MESSAGE);
			if (input != null && !input.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Đơn hàng mã " + input + " đã bị xóa !", null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if (e.getSource() == senderItem) {
			remove(prePanel);
			prePanel = new SenderGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		if (e.getSource() == receiverItem) {
			remove(prePanel);
			prePanel = new ReceiverGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		if (e.getSource() == packageItem) {
			remove(prePanel);
			prePanel = new PackageGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
		
		if (e.getSource() == revenueItem) {
			remove(prePanel);
			prePanel = new RevenueGUI();
			getContentPane().add(prePanel);
			revalidate();
		}
	}

}
