package game_package;

import javax.swing.JFrame;

public class Panel extends JFrame {

	public void window() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("UNIVERSIDAD CENTRAL DEL ECUADOR");
		setResizable(false);
		setLocation(290, 120);
		setSize(900, 700);

		PanelGame pg = new PanelGame();
		add(pg);

		setVisible(true);
	}

}