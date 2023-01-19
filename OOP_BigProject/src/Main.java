import java.awt.EventQueue;

import GUI.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
			
		});
		
	}
}
