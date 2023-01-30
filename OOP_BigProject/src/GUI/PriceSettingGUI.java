package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import connection.DatabaseConnection;
import entities.PriceSetting;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.awt.event.ActionEvent;

public class PriceSettingGUI extends JFrame implements ActionListener {

	private DatabaseConnection databaseConnection = new DatabaseConnection();
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
		saveBtn.setFocusable(false);
		saveBtn.addActionListener(this);
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
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
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == saveBtn) 
		{
			String s[] = new String[4];
			s[0] = roadDistanceTF.getText();
			s[1] = roadWeightTF.getText();
			s[2] = airlineDistanceTF.getText();
			s[3] = airlineWeightTF.getText();
			
			// Nếu một trong các ô chứa kí tự không phải chữ số --> return true
			boolean containCharacterThatIsNotNumber = false;
			for (String sTemp : s)
			{
				if (containCharacterThatIsNotNumber(sTemp))
				{
					System.out.println("Khong duoc phep chua ki tu khong phai chu so");
					containCharacterThatIsNotNumber = true;
				}
			}

			// Nếu các ô chỉ chứa chữ số hoặc không có gì --> tiếp tục kiểm tra null
			if (!containCharacterThatIsNotNumber)
			{
				List<PriceSetting> priceSettings = readFile();
				PriceSetting priceSetting1 = priceSettings.get(0);
				PriceSetting priceSetting2 = priceSettings.get(1);
				
				if (!isNull(s[0])) priceSetting1.setPriceSetting
				(s[0] + "|" + priceSetting1.getPriceSetting().split("[|]")[1]);

				if (!isNull(s[1])) priceSetting1.setPriceSetting
				(priceSetting1.getPriceSetting().split("[|]")[0] + "|" + s[1]);

				if (!isNull(s[2])) priceSetting2.setPriceSetting
				(s[2] + "|" + priceSetting2.getPriceSetting().split("[|]")[1] + "|" + priceSetting2.getPriceSetting().split("[|]")[2]);

				if (!isNull(s[3])) priceSetting2.setPriceSetting
				(priceSetting2.getPriceSetting().split("[|]")[0] + "|" + s[3] + "|" + priceSetting2.getPriceSetting().split("[|]")[2]);

				System.out.println(priceSetting1.getPriceSetting() + ":" + priceSetting2.getPriceSetting());
				writeFile(priceSettings);
				databaseConnection.updatePrice();
			}
			
			setVisible(false);
		}
		
		if (e.getSource() == cancelBtn) {
			PriceSettingGUI.this.dispose();
		}
	}

	public boolean isNull(String s)
	{
		if (s.length() == 0)
		{
			return true;
		}
		return false;
	}

	public boolean containCharacterThatIsNotNumber(String s)
	{
		char[] sAlphabet = s.toLowerCase().toCharArray();
		for (char c : sAlphabet)
		{
			if (c < '0' || '9' < c)
			{
				return true;
			}
		}
		return false;
	}

	public List<PriceSetting> readFile()
	{
		try 
		{
			Gson gson = new Gson();
			Reader reader = Files.newBufferedReader(Paths.get("src\\pricesetting.json"));
			List<PriceSetting> priceSettings = gson.fromJson(reader, new TypeToken<List<PriceSetting>>() {}.getType());
			reader.close();
			return priceSettings;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return null;
	}

	public void writeFile(List<PriceSetting> priceSettings)
	{
		try 
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = new FileWriter("src\\pricesetting.json");
			gson.toJson(priceSettings, writer);
			writer.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
