package work.hennig.tom.GameOfLife.Configuration;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigurationUI extends JFrame {
	
	private static final long serialVersionUID = 3138078699417227779L;

	private static final int SPACING = 10;
	
	private JSpinner spnWidth;
	private JSpinner spnHeight;
	private JSpinner spnCellSize;
	
	private JButton btnStart;
	private JButton btnCancel;
	
	public ConfigurationUI() {
		Locale locale = Locale.getDefault();
		ResourceBundle rb = ResourceBundle.getBundle("Strings", locale);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(new BoxLayout(pnlContent, BoxLayout.Y_AXIS));
		pnlContent.setBorder(BorderFactory.createEmptyBorder(SPACING, SPACING, SPACING, SPACING));
		
		JPanel pnlSettings = new JPanel();
		LayoutManager settingsLayout = new GridLayout(3, 2, SPACING, SPACING / 2);
		pnlSettings.setLayout(settingsLayout);
		pnlSettings.setBorder(BorderFactory.createEmptyBorder(SPACING, SPACING, SPACING, SPACING));
		
		JLabel lblWidth = new JLabel(rb.getString("width"));
		spnWidth = new JSpinner(new SpinnerNumberModel(50, 20, 500, 1));
		
		JLabel lblHeight = new JLabel(rb.getString("height"));
		spnHeight = new JSpinner(new SpinnerNumberModel(50, 20, 500, 1));
		
		JLabel lblCellSize = new JLabel(rb.getString("cellSize"));
		spnCellSize = new JSpinner(new SpinnerNumberModel(10, 1, 20, 1));
		
		pnlSettings.add(lblWidth);
		pnlSettings.add(spnWidth);
		pnlSettings.add(lblHeight);
		pnlSettings.add(spnHeight);
		pnlSettings.add(lblCellSize);
		pnlSettings.add(spnCellSize);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new BoxLayout(pnlButtons, BoxLayout.X_AXIS));
		
		btnStart = new JButton(rb.getString("start"));
		btnCancel = new JButton(rb.getString("close"));
		
		pnlButtons.add(btnStart);
		pnlButtons.add(Box.createRigidArea(new Dimension(10, 0)));
		pnlButtons.add(btnCancel);
		
		pnlContent.add(pnlSettings);
		pnlContent.add(pnlButtons);
		setContentPane(pnlContent);
		
		setTitle(rb.getString("title"));
		pack();
		setResizable(false);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public JSpinner getSpnWidth() {
		return spnWidth;
	}
	
	public JSpinner getSpnHeight() {
		return spnHeight;
	}
	
	public JSpinner getSpnCellSize() {
		return spnCellSize;
	}
	
	public JButton getBtnStart() {
		return btnStart;
	}
	
	public JButton getBtnCancel() {
		return btnCancel;
	}
	
}
