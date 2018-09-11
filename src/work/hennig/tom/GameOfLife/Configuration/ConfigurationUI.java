package work.hennig.tom.GameOfLife.Configuration;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigurationUI extends JFrame {
	
	private static final long serialVersionUID = 3138078699417227779L;

	private static final int SPACING = 10;
	
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtCellSize;
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
		txtWidth = new JTextField("50");
		
		JLabel lblHeight = new JLabel(rb.getString("height"));
		txtHeight = new JTextField("50");
		
		JLabel lblCellSize = new JLabel(rb.getString("cellSize"));
		txtCellSize = new JTextField("8");
		
		pnlSettings.add(lblWidth);
		pnlSettings.add(txtWidth);
		pnlSettings.add(lblHeight);
		pnlSettings.add(txtHeight);
		pnlSettings.add(lblCellSize);
		pnlSettings.add(txtCellSize);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new BoxLayout(pnlButtons, BoxLayout.X_AXIS));
		
		btnStart = new JButton(rb.getString("start"));
		btnCancel = new JButton(rb.getString("cancel"));
		
		pnlButtons.add(btnStart);
		pnlButtons.add(btnCancel);
		
		pnlContent.add(pnlSettings);
		pnlContent.add(pnlButtons);
		setContentPane(pnlContent);
		
		setTitle(rb.getString("title"));
		pack();
		setResizable(false);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public JTextField getTxtCellSize() {
		return txtCellSize;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
}
