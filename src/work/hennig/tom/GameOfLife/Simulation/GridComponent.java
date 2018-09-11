package work.hennig.tom.GameOfLife.Simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;

public class GridComponent extends JComponent {
	
	private static final long serialVersionUID = -453306072784707604L;
	
	private short width;
	private short height;
	private short cellSize;
	private List<Point> livingCells;
	
	public GridComponent(short width, short height, short cellSize) {
		this.width = width;
		this.height = height;
		this.cellSize = cellSize;
		livingCells = new LinkedList<>();
	}
	
	public void addLivingCell(short col, short row) {
		if (col < 0 || col >= width || row < 0 || row >= height) {
			throw new IllegalArgumentException();
		}
		
		livingCells.add(new Point(col, row));
	}
	
	public void clearLivingCells() {
		livingCells.clear();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width * cellSize, height * cellSize);
		g.setColor(Color.BLACK);
		for (Point cell : livingCells) {
			g.fillRect(cell.x * cellSize, cell.y * cellSize, cellSize, cellSize);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width * cellSize, height * cellSize);
	}
	
}
