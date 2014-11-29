import graph.GraphSucFunction;
import graph.Grid;
import graph.Junction;
import graph.Junction.moveList;

import java.util.ArrayList;

import jumble.StringMove;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

import rp13.search.util.ActionStatePair;


@Test
public class TestNGGraph {
	
	ArrayList<moveList> moveList;
	
	
	@BeforeMethod
	public void setup(){
		Grid grid = new Grid();
		Junction start = grid.getJunctionFromCoord(0, 0);
		Junction goal = grid.getJunctionFromCoord(10,6);
		GraphSucFunction suc = new GraphSucFunction();
		GenericSearchAStar<moveList, Junction> search = new GenericSearchAStar<moveList, Junction>(
				new AStarData1<ActionStatePair<moveList, Junction>>(),
				start, suc, goal);
		moveList = search.executeSearch();
		
	}
	
	public void testRoute(){
		assertEquals("[GONORTH, GONORTH, GONORTH, GONORTH, GONORTH, GONORTH, GOEAST, GOEAST, GOEAST, GOEAST, GOEAST, GOEAST, GOEAST, GOEAST, GOEAST, GOSOUTH, GOEAST, GONORTH]",moveList.toString());
	}
}
