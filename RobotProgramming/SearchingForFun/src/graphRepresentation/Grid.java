package graphRepresentation;

/**
 * Represents the grid currently in the robot lab
 * @author jgs328
 *
 */
public class Grid {

	Junction[][] grid;

	private final int width = 11;
	private final int height = 7;

	/**
	 * Sets up the grid 
	 */
	public Grid() {

		grid = new Junction[width][height];

		generateGrid();

	}

	/**
	 * Sets up the grid, to the given grid in the current robot lab
	 */
	private void generateGrid() {

		// For loop to setup the junctions
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = new Junction(i,j);
			}
		}
		

		// For loop to set north
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height - 1; j++) {
				grid[i][j].setNorth(grid[i][j+1]);
			}
		}


		// For loop to set east
		for (int i = 0; i < width - 1; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j].setEast(grid[i+1][j]);
			}
		}
		

		// For loop to set south
		for (int i = 0; i < width; i++) {
			for (int j = 1; j < height; j++) {
				grid[i][j].setSouth(grid[i][j-1]);
			}
		}
		
		
		// For loop to set west
		for (int i = 1; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j].setWest(grid[i-1][j]);
			}
		}
	
		//Blocked paths
		
		//2014 Map 1///////////////////////////////////
		destroyNorthSouth(1, 3);
		destroyEasyWest(0, 4);
		destroyEasyWest(1, 4);
		destroyNorthSouth(2, 4);
		destroyNorthSouth(2, 5);
		destroyEasyWest(2, 5);
		destroyNorthSouth(4, 4);
		destroyNorthSouth(4, 5);
		destroyEasyWest(0, 2);
		destroyNorthSouth(1, 2);
		destroyEasyWest(1, 2);
		destroyNorthSouth(2, 0);
		destroyEasyWest(2, 1);
		destroyNorthSouth(2, 1);
		destroyNorthSouth(4, 0);
		destroyNorthSouth(5, 0);
		destroyNorthSouth(6, 0);
		destroyNorthSouth(4, 1);
		destroyNorthSouth(5, 1);
		destroyNorthSouth(6, 1);
		destroyNorthSouth(5, 4);
		destroyNorthSouth(6, 4);
		destroyNorthSouth(5, 5);
		destroyNorthSouth(6, 5);
		destroyEasyWest(7, 5);
		destroyNorthSouth(8, 4);
		destroyNorthSouth(8, 5);
		destroyEasyWest(8, 4);
		destroyNorthSouth(9, 3);
		destroyEasyWest(9, 4);
		destroyNorthSouth(8, 0);
		destroyEasyWest(7, 2);
		destroyNorthSouth(8, 1);
		destroyNorthSouth(9, 2);
		destroyEasyWest(8, 2);
		destroyEasyWest(9, 2);
		destroyEasyWest(4, 3);
		destroyEasyWest(5, 3);
		destroyNorthSouth(5, 2);
		////////////////////////////////////
		
		

	}
	
	private void destroyNorthSouth(int x, int y){
		grid[x][y].setNorth(null);
		grid[x][y+1].setSouth(null);
	}
	
	private void destroyEasyWest(int x, int y){
		grid[x][y].setEast(null);
		grid[x+1][y].setWest(null);
	}
	
	/**
	 * Gets the Junction a a given grid position
	 * @param x The x position of the junction to return
	 * @param y The y position of the junction to return
	 * @return The junction at the given x and y position
	 */
	public Junction getJunctionFromCoord(int x, int y){
		return grid[x][y];
	}
	

	
	
}
