package graphRepresentation;

import java.util.ArrayList;

import searchFramework.ActionStatePair;
import Interfaces.Heuristic;

/**
 * Contains the links to other junctions
 * 
 * @author jgs328
 * 
 */
public class Junction implements Heuristic{

	public enum moveList {
		GONORTH, GOEAST, GOSOUTH, GOWEST
	}

	private final int xGoal = 10;
	private final int yGoal = 6;
	
	private Junction north;
	private Junction east;
	private Junction south;
	private Junction west;
	private int x;
	private int y;

	/**
	 * Constructor only makes sure nodes are null, nodes are setup in the
	 * constructor for the grid class
	 */
	public Junction(int x, int y) {
		north = east = south = west = null;
		this.x = x;
		this.y = y;
	}

	/**
	 * Return all the connected junctions
	 * 
	 * @return All connected junctions
	 */
	public ArrayList<ActionStatePair<moveList, Junction>> getSuccessors() {

		ArrayList<ActionStatePair<moveList, Junction>> connected = new ArrayList<ActionStatePair<moveList, Junction>>();

		if (north != null) {
			connected.add(new ActionStatePair<moveList, Junction>(
					moveList.GONORTH, north));
		}

		if (east != null) {
			connected.add(new ActionStatePair<moveList, Junction>(
					moveList.GOEAST, east));
		}

		if (south != null) {
			connected.add(new ActionStatePair<moveList, Junction>(
					moveList.GOSOUTH, south));
		}
		
		if (west != null) {
			connected.add(new ActionStatePair<moveList, Junction>(
					moveList.GOWEST, west));
		}
		return connected;
	}

	@Override
	public boolean equals(Object _that) {
		
		return this.hashCode() == _that.hashCode();
		
		//return (this.x == ((Junction) _that).getX()) && (this.y == ((Junction) _that).getY());

	}
	
	@Override
	public int hashCode(){
		return Integer.parseInt(Integer.toString(x) + Integer.toString(y));
	}
	
	public String toString(){
		return "Junction " + x + " " + y;
	}

	// Getters and setters
	public Junction getNorth() {
		return north;
	}

	public void setNorth(Junction north) {
		this.north = north;
	}

	public Junction getEast() {
		return east;
	}

	public void setEast(Junction east) {
		this.east = east;
	}

	public Junction getSouth(){
		return south;
	}

	public void setSouth(Junction south) {
		this.south = south;
	}

	public Junction getWest() {
		return west;
	}

	public void setWest(Junction west) {
		this.west = west;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

	@Override
	public int getHeuristic() {
		return Math.abs(this.x - xGoal) + Math.abs(this.y - yGoal) ;
	}
}
