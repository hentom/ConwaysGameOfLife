package work.hennig.tom.GameOfLife;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import work.hennig.tom.GameOfLife.Configuration.ConfigurationController;
import work.hennig.tom.GameOfLife.Configuration.ConfigurationUI;

public class Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ignored) { }
				ConfigurationUI ui = new ConfigurationUI();
				new ConfigurationController(ui);
			}
		});
	}
	
}
