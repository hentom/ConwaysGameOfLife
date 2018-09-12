package work.hennig.tom.GameOfLife.Simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class GridComponent extends JComponent {
	
	private static final long serialVersionUID = -453306072784707604L;
	
	private short width;
	private short height;
	private short cellSize;
	private boolean livingCells[][];
	
	public GridComponent(short width, short height, short cellSize) {
		this.width = width;
		this.height = height;
		this.cellSize = cellSize;
		livingCells = new boolean[width][height];
		
		setSize(getPreferredSize());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void addLivingCell(short col, short row) {
		if (col < 0 || col >= width || row < 0 || row >= height) {
			throw new IllegalArgumentException();
		}
		
		livingCells[col][row] = true;
	}
	
	public void clearLivingCells() {
		for (short i = 0; i < width; i++) {
			Arrays.fill(livingCells[i], false);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width * cellSize, height * cellSize);
		g.setColor(Color.BLACK);
		for (short i = 0; i < width; i++) {
			for (short j = 0; j < height; j++) {
				if (livingCells[i][j]) {
					g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
				}
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width * cellSize, height * cellSize);
	}
	
	@Override
	public Dimension getMaximumSize() {
		return new Dimension(width * cellSize, height * cellSize);
	}
	
}
