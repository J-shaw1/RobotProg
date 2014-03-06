package TestCode;

import graphRepresentation.GraphSucFunction;
import graphRepresentation.Grid;
import graphRepresentation.Junction;
import graphRepresentation.Junction.moveList;
import java.util.ArrayList;
import searchFramework.AStarData;
import searchFramework.ActionStatePair;
import searchFramework.GenericSearchAStar;



public class TestGrid {
	public static void main(String args[]){
		
		Grid grid = new Grid();
		Junction start = grid.getJunctionFromCoord(0, 0);
		Junction goal = grid.getJunctionFromCoord(7,6);
		GraphSucFunction suc = new GraphSucFunction();
		GenericSearchAStar<moveList, Junction> search = new GenericSearchAStar<moveList, Junction>(
				new AStarData<ActionStatePair<moveList, Junction>>(),
				start, suc, goal);
		ArrayList<moveList> moves = search.executeSearch();
		System.out.println(moves);
		
	}
}
