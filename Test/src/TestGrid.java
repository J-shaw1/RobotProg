import graph.GraphSucFunction;
import graph.Grid;
import graph.Junction;
import graph.Junction.moveList;

import java.util.ArrayList;

import rp13.search.util.ActionStatePair;



public class TestGrid {
	public static void main(String args[]){
		
		Grid grid = new Grid();
		Junction start = grid.getJunctionFromCoord(0, 0);
		Junction goal = grid.getJunctionFromCoord(10,6);
		GraphSucFunction suc = new GraphSucFunction();
		GenericSearchAStar<moveList, Junction> search = new GenericSearchAStar<moveList, Junction>(
				new AStarData1<ActionStatePair<moveList, Junction>>(),
				start, suc, goal);
		ArrayList<moveList> moves = search.executeSearch();
		System.out.println(moves);
		
	}
}
