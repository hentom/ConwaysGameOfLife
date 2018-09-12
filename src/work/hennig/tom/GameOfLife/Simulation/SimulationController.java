package work.hennig.tom.GameOfLife.Simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class SimulationController implements ActionListener, MouseListener {
	
	private static final String actPlay = "play";
	private static final String actClear = "clear";
	private static final String actTimer = "timer";
	
	private static final int updateDelay = 1000;
	
	private SimulationUI ui;
	private GameOfLife game;
	
	private GridComponent pnlGrid;
	private JButton btnPlay;
	private JButton btnClear;
	
	private Timer timer;
	
	public SimulationController(SimulationUI ui) {
		this.ui = ui;
		game = ui.getGame();
		
		pnlGrid = ui.getPnlGrid();
		btnPlay = ui.getBtnPlay();
		btnClear = ui.getBtnClear();
		timer = new Timer(updateDelay, this);
		
		btnPlay.setActionCommand(actPlay);
		btnClear.setActionCommand(actClear);
		timer.setActionCommand(actTimer);
		
		pnlGrid.addMouseListener(this);
		btnPlay.addActionListener(this);
		btnClear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		switch (act.getActionCommand()) {
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
