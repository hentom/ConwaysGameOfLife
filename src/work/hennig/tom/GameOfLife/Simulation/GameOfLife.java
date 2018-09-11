package work.hennig.tom.GameOfLife.Simulation;

public class GameOfLife {
	
	private short width;
	private short height;
	private boolean grid[][];
	private byte neighborCount[][];
	private boolean cellChanged[][];
	
	public GameOfLife(short width, short height) {
		this.width = width;
		this.height = height;
		grid = new boolean[width][height];
		neighborCount = new byte[width][height];
		cellChanged = new boolean[width][height];
	}
	
	public short getWidth() {
		return width;
	}
	
	public short getHeight() {
		return height;
	}
	
	public boolean isCellAlive(short col, short row) {
		if (col < 0 || col >= width || row < 0 || row >= height) {
			throw new IllegalArgumentException();
		}
		return grid[col][row];
	}
	
	public void toggleCellState(short col, short row) {
		if (col < 0 || col >= width || row < 0 || row >= height) {
			throw new IllegalArgumentException();
		}
		
		if (grid[col][row]) {
			decrementNeighbors(col, row);
		} else {
			incrementNeighbors(col, row);
		}
		
		grid[col][row] = !grid[col][row];
	}
	
	public void clearCellStates() {
		for (short i = 0; i < width; i++) {
			for (short j = 0; j < height; j++) {
				grid[i][j] = false;
				neighborCount[i][j] = 0;
			}
		}
	}
	
	public void simulateTimeStep() {
		for (short i = 0; i < width; i++) {
			for (short j = 0; j < height; j++) {
				cellChanged[i][j] = false;
				if (grid[i][j]) {
					if (neighborCount[i][j] < 2 || neighborCount[i][j] > 3) {
						grid[i][j] = false;
						cellChanged[i][j] = true;
					}
				} else {
					if (neighborCount[i][j] == 3) {
						grid[i][j] = true;
						cellChanged[i][j] = true;
					}
				}
			}
		}
		
		for (short i = 0; i < width; i++) {
			for (short j = 0; j < height; j++) {
				if (cellChanged[i][j]) {
					if (grid[i][j]) {
						incrementNeighbors(i, j);
					} else {
						decrementNeighbors(i, j);
					}
				}
			}
		}
	}
	
	private void incrementNeighbors(short col, short row) {
		if (row == 0) {
			if (col != 0) {
				neighborCount[col-1][row]++;
				neighborCount[col-1][row+1]++;
			}
			if (col != width - 1) {
				neighborCount[col+1][row]++;
				neighborCount[col+1][row+1]++;
			}
			neighborCount[col][row+1]++;
		} else if (row == height - 1) {
			if (col != 0) {
				neighborCount[col-1][row-1]++;
				neighborCount[col-1][row]++;
			}
			if (col != width - 1) {
				neighborCount[col+1][row-1]++;
				neighborCount[col+1][row]++;
			}
			neighborCount[col][row-1]++;
		} else {
			if (col != 0) {
				neighborCount[col-1][row-1]++;
				neighborCount[col-1][row]++;
				neighborCount[col-1][row+1]++;
			}
			if (col != width - 1) {
				neighborCount[col+1][row-1]++;
				neighborCount[col+1][row]++;
				neighborCount[col+1][row+1]++;
			}
			neighborCount[col][row-1]++;
			neighborCount[col][row+1]++;
		}
	}
	
	private void decrementNeighbors(short col, short row) {
		if (row == 0) {
			if (col != 0) {
				neighborCount[col-1][row]--;
				neighborCount[col-1][row+1]--;
			}
			if (col != width - 1) {
				neighborCount[col+1][row]--;
				neighborCount[col+1][row+1]--;
			}
			neighborCount[col][row+1]--;
		} else if (row == height - 1) {
			if (col != 0) {
				neighborCount[col-1][row-1]--;
				neighborCount[col-1][row]--;
			}
			if (col != width - 1) {
				neighborCount[col+1][row-1]--;
				neighborCount[col+1][row]--;
			}
			neighborCount[col][row-1]--;
		} else {
			if (col != 0) {
				neighborCount[col-1][row-1]--;
				neighborCount[col-1][row]--;
				neighborCount[col-1][row+1]--;
			}
			if (col != width - 1) {
				neighborCount[col+1][row-1]--;
				neighborCount[col+1][row]--;
				neighborCount[col+1][row+1]--;
			}
			neighborCount[col][row-1]--;
			neighborCount[col][row+1]--;
		}
	}
	
}
