package work.hennig.tom.GameOfLife.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;

import work.hennig.tom.GameOfLife.Simulation.GameOfLife;
import work.hennig.tom.GameOfLife.Simulation.SimulationController;
import work.hennig.tom.GameOfLife.Simulation.SimulationUI;

public class ConfigurationController implements ActionListener {
	
	private static final String actStart = "start";
	private static final String actCancel = "cancel";
	
	private ConfigurationUI ui;
	
	private JSpinner spnWidth;
	private JSpinner spnHeight;
	private JSpinner spnCellSize;
	
	public ConfigurationController(ConfigurationUI ui) {
		this.ui = ui;
		
		spnWidth = ui.getSpnWidth();
		spnHeight = ui.getSpnHeight();
		spnCellSize = ui.getSpnCellSize();
		
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
			short width = ((Integer)spnWidth.getValue()).shortValue();
			short height = ((Integer)spnHeight.getValue()).shortValue();
			short cellSize = ((Integer)spnCellSize.getValue()).shortValue();
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
