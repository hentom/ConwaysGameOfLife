package work.hennig.tom.GameOfLife.Simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SimulationController implements ActionListener, ChangeListener, MouseListener {
	
	private static final String actPlay = "play";
	private static final String actClear = "clear";
	private static final String actTimer = "timer";
	
	private static final int UPDATE_DELAY = 1000;
	
	private SimulationUI ui;
	private GameOfLife game;
	
	private GridComponent pnlGrid;
	private JSlider sldSpeed;
	private JButton btnPlay;
	private JButton btnClear;
	
	private Timer timer;
	
	public SimulationController(SimulationUI ui) {
		this.ui = ui;
		game = ui.getGame();
		
		pnlGrid = ui.getPnlGrid();
		sldSpeed = ui.getSldSpeed();
		btnPlay = ui.getBtnPlay();
		btnClear = ui.getBtnClear();
		timer = new Timer(UPDATE_DELAY / SimulationUI.INITIAL_SPEED, this);
		
		btnPlay.setActionCommand(actPlay);
		btnClear.setActionCommand(actClear);
		timer.setActionCommand(actTimer);
		
		pnlGrid.addMouseListener(this);
		sldSpeed.addChangeListener(this);
		btnPlay.addActionListener(this);
		btnClear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case actPlay:
			if (timer.isRunning()) {
				timer.stop();
				btnPlay.setText(ui.getStrPlay());
			} else {
				timer.start();
				btnPlay.setText(ui.getStrPause());
			}
			break;
		case actClear:
			if (timer.isRunning()) {
				timer.stop();
				btnPlay.setText(ui.getStrPlay());
			}
			game.clearCellStates();
			ui.update();
			break;
		case actTimer:
			game.simulateTimeStep();
			ui.update();
			break;
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent c) {
		if (timer.isRunning()) {
			timer.stop();
			timer = new Timer(UPDATE_DELAY / sldSpeed.getValue(), this);
			timer.setActionCommand(actTimer);
			timer.setInitialDelay(0);
			timer.start();
		} else {
			timer = new Timer(UPDATE_DELAY / sldSpeed.getValue(), this);
			timer.setActionCommand(actTimer);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			short col = (short) (e.getX() / ui.getCellSize());
			short row = (short) (e.getY() / ui.getCellSize());
			game.toggleCellState(col, row);
			ui.update();
		}
	}

	@Override
	public void mouseEntered(MouseEvent ignored) { }

	@Override
	public void mouseExited(MouseEvent ignored) { }

	@Override
	public void mousePressed(MouseEvent ignored) { }

	@Override
	public void mouseReleased(MouseEvent ignored) { }
	
}
