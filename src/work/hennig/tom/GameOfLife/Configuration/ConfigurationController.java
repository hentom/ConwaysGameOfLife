package work.hennig.tom.GameOfLife.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import work.hennig.tom.GameOfLife.Simulation.GameOfLife;
import work.hennig.tom.GameOfLife.Simulation.SimulationController;
import work.hennig.tom.GameOfLife.Simulation.SimulationUI;

public class ConfigurationController implements ActionListener {
	
	private static final String actStart = "start";
	private static final String actCancel = "cancel";
	
	private ConfigurationUI ui;
	
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtCellSize;
	
	public ConfigurationController(ConfigurationUI ui) {
		this.ui = ui;
		
		txtWidth = ui.getTxtWidth();
		txtHeight = ui.getTxtHeight();
		txtCellSize = ui.getTxtCellSize();
		
		JButton btnStart = ui.getBtnStart();
		JButton btnCancel = ui.getBtnCancel();
		
		btnStart.setActionCommand(actStart);
		btnCancel.setActionCommand(actCancel);
		
		btnStart.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent act) {
		switch (act.getActionCommand()) {
		case actStart:
			// TODO: more checks
			short width = Short.parseShort(txtWidth.getText());
			short height = Short.parseShort(txtHeight.getText());
			short cellSize = Short.parseShort(txtCellSize.getText());
			GameOfLife game = new GameOfLife(width, height);
			SimulationUI simUI = new SimulationUI(game, cellSize);
			new SimulationController(simUI);
			break;
		case actCancel:
			ui.dispose();
			break;
		}
	}
	
}
