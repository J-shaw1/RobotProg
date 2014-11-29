package TestCode;

import graphRepresentation.GraphSucFunction;
import graphRepresentation.Grid;
import graphRepresentation.Junction;
import graphRepresentation.Junction.moveList;

import java.util.ArrayList;

import searchFramework.AStarData;
import searchFramework.ActionStatePair;
import searchFramework.BreadthFirstData;
import searchFramework.GenericSearch;
import searchFramework.GenericSearchAStar;



public class TestGrid {
	
	public TestGrid(int x1, int y1, int x2, int y2){
		Grid grid = new Grid();
		Junction start = grid.getJunctionFromCoord(x1, y1);
		Junction goal = grid.getJunctionFromCoord(x2,y2);
		GraphSucFunction suc = new GraphSucFunction();
		GenericSearch<moveList, Junction> search = new GenericSearch<moveList, Junction>(
				new BreadthFirstData<ActionStatePair<moveList, Junction>>(),
				start, suc, goal);
		ArrayList<moveList> moves = search.executeSearch();
		
		Junction goal2 = grid.getJunctionFromCoord(x2,y2);
		GenericSearch<moveList, Junction> search2 = new GenericSearch<moveList, Junction>(
				new BreadthFirstData<ActionStatePair<moveList, Junction>>(),
				goal, suc, goal2);
		
		moves.addAll(search2.executeSearch());
		
	}
	
	public static void main(String args[]){
		
		Grid grid = new Grid();
		Junction start = grid.getJunctionFromCoord(0, 0);
		Junction goal = grid.getJunctionFromCoord(3,3);
		GraphSucFunction suc = new GraphSucFunction();
		GenericSearch<moveList, Junction> search = new GenericSearch<moveList, Junction>(
				new BreadthFirstData<ActionStatePair<moveList, Junction>>(),
				start, suc, goal);
		ArrayList<moveList> moves = search.executeSearch();
		System.out.println(moves);
		
	}
}
