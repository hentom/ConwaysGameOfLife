package work.hennig.tom.GameOfLife.Simulation;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimulationUI extends JFrame {
	
	private static final long serialVersionUID = -6454001545447725427L;

	private static final int SPACING = 10;
	
	private GameOfLife game;
	
	private short width;
	private short height;
	private short cellSize;
	
	private GridComponent pnlGrid;
	private JButton btnPlay;
	private JButton btnClear;
	
	public SimulationUI(short width, short height, short cellSize) {
		this.width = width;
		this.height = height;
		this.cellSize = cellSize;
		
		game = new GameOfLife(width, height);
		
		Locale locale = Locale.getDefault();
		ResourceBundle rb = ResourceBundle.getBundle("Strings", locale);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(new BoxLayout(pnlContent, BoxLayout.Y_AXIS));
		pnlContent.setBorder(BorderFactory.createEmptyBorder(SPACING, SPACING, SPACING, SPACING));
		
		pnlGrid = new GridComponent(width, height, cellSize);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new BoxLayout(pnlButtons, BoxLayout.X_AXIS));
		pnlButtons.setBorder(BorderFactory.createEmptyBorder(SPACING, 0, 0, 0));
		
		btnPlay = new JButton(rb.getString("play"));
		btnClear = new JButton(rb.getString("clear"));
		
		pnlButtons.add(btnPlay);
		pnlButtons.add(btnClear);
		
		pnlContent.add(pnlGrid);
		pnlContent.add(pnlButtons);
		setContentPane(pnlContent);
		
		setTitle(rb.getString("title"));
		pack();
		setResizable(false);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void update() {
		pnlGrid.clearLivingCells();
		for (short i = 0; i < width; i++) {
			for (short j = 0; j < height; j++) {
				if (game.isCellAlive(i, j)) {
					pnlGrid.addLivingCell(i, j);
				}
			}
		}
		repaint();
	}
	
	public GameOfLife getGame() {
		return game;
	}
	
	public short getCellSize() {
		return cellSize;
	}
	
	public GridComponent getPnlGrid() {
		return pnlGrid;
	}
	
	public JButton getBtnPlay() {
		return btnPlay;
	}
	
	public JButton getBtnClear() {
		return btnClear;
	}
	
}
