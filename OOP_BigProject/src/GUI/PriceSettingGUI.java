package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PriceSettingGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField roadDistanceTF;
	private JTextField roadWeightTF;
	private JTextField airlineDistanceTF;
	private JTextField airlineWeightTF;
	private JButton saveBtn, cancelBtn;

	/**
	 * Create the frame.
	 */
	public PriceSettingGUI() {
		setTitle("THIẾT LẬP CHI PHÍ");
		setResizable(false);
		setBounds(100, 100, 643, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel roadLabel = new JLabel("Vận chuyển đường bộ");
		roadLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel airlineLabel = new JLabel("Vận chuyển đường hàng không");
		airlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel roadDistanceLbl = new JLabel("Chi phí trên 1 km khoảng cách");
		roadDistanceLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel roadWeightLbl = new JLabel("Chi phí trên 1 kg cân nặng");
		roadWeightLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel airlineDistanceLbl = new JLabel("Chi phí trên 1 km khoảng cách");
		airlineDistanceLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel airlineWeightLbl = new JLabel("Chi phí trên 1 kg cân nặng");
		airlineWeightLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		roadDistanceTF = new JTextField();
		roadDistanceTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roadDistanceTF.setColumns(10);
		
		roadWeightTF = new JTextField();
		roadWeightTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roadWeightTF.setColumns(10);
		
		airlineDistanceTF = new JTextField();
		airlineDistanceTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		airlineDistanceTF.setColumns(10);
		
		airlineWeightTF = new JTextField();
		airlineWeightTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		airlineWeightTF.setColumns(10);
		
		saveBtn = new JButton("Lưu");
		saveBtn.addActionListener(this);
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cancelBtn = new JButton("Hủy");
		cancelBtn.addActionListener(this);
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(roadLabel, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
								.addComponent(airlineLabel, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(airlineWeightLbl, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(airlineWeightTF, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(airlineDistanceLbl, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(airlineDistanceTF, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(roadWeightLbl, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(roadWeightTF, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(roadDistanceLbl, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(roadDistanceTF, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(roadLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(roadDistanceTF)
						.addComponent(roadDistanceLbl, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(roadWeightLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(roadWeightTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(airlineLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(airlineDistanceLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(airlineDistanceTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(airlineWeightTF, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(airlineWeightLbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == saveBtn) {
			
		}
		
		if (e.getSource() == cancelBtn) {
			
		}
	}
}
