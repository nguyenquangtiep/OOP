import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import GUI.MainFrame;
import connection.DatabaseConnection;
import entities.PriceSetting;

public class Main {

	public static void main(String[] args) {
		
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}

		
		DatabaseConnection databaseConnection = new DatabaseConnection();
		enableDefaultSetting();		
		databaseConnection.updatePrice();

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
			
		});
		
	}

	public static void enableDefaultSetting()
	{
		try 
		{
			if (new File("src\\pricesetting.json").length() == 0)
			{
				PriceSetting priceSetting1 = new PriceSetting("road", "20000|5000");
				PriceSetting priceSetting2 = new PriceSetting("air", "100000|100000|200000");
				List<PriceSetting> priceSettings = new ArrayList<>();
				priceSettings.add(priceSetting1);
				priceSettings.add(priceSetting2);
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				Writer writer = new FileWriter("src\\pricesetting.json");
				gson.toJson(priceSettings, writer);	
				writer.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
