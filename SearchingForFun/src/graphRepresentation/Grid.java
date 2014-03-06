package graphRepresentation;

/**
 * Represents the grid currently in the robot lab
 * @author jgs328
 *
 */
public class Grid {

	Junction[][] grid;

	private final int width = 10;//11
	private final int height = 7;//7

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
		
		//0,1 east 1,1 west
		grid[0][1].setEast(null);
		grid[1][1].setWest(null);
		
		//0,2 north 0,3 south
		grid[0][2].setNorth(null);
		grid[0][3].setSouth(null);
		//1,0 east. 2, 0 west
		grid[1][0].setEast(null);
		grid[2][0].setWest(null);
		//2,2 North. 2,3 south
		grid[2][2].setNorth(null);
		grid[2][3].setSouth(null);
		//3,3 west  2, 3 east
		grid[2][3].setEast(null);
		grid[3][3].setWest(null);
		//1, 5 east  2,5 west
		grid[1][5].setEast(null);
		grid[2][5].setWest(null);
		//3, 6 east  4,6 west 
		grid[3][6].setEast(null);
		grid[4][6].setWest(null);
		//4,1  east  5,1 west  
		grid[4][1].setEast(null);
		grid[5][1].setWest(null);
		//4, 2 east 5, 2 west
		grid[4][2].setEast(null);
		grid[5][2].setWest(null);
		//5, 0 east  6, 0 west 
		grid[5][0].setEast(null);
		grid[6][0].setWest(null);
		//5, 2 north   5, 3 south
		grid[5][2].setNorth(null);
		grid[5][3].setSouth(null);
		//4, 4 east  5,4 west
		grid[4][4].setEast(null);
		grid[5][4].setWest(null);
		//5, 5  north   5,6 south
		grid[5][5].setNorth(null);
		grid[5][6].setSouth(null);
		//6, 4 east   7,4 west
		grid[6][4].setEast(null);
		grid[7][4].setWest(null);
		//6, 5 east   7,5 west
		grid[6][5].setEast(null);
		grid[7][5].setWest(null);
		
		

		
		
		

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
