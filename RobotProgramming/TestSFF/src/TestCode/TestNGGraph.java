package TestCode;

import graphRepresentation.GraphSucFunction;
import graphRepresentation.Grid;
import graphRepresentation.Junction;
import java.util.ArrayList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import graphRepresentation.Junction.moveList;
import searchFramework.AStarData;
import searchFramework.ActionStatePair;
import searchFramework.GenericSearchAStar;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class TestNGGraph {
	
	ArrayList<moveList> moveList;
	
	
	@BeforeMethod
	public void setup(){
		Grid grid = new Grid();
		Junction start = grid.getJunctionFromCoord(0, 0);
		Junction goal = grid.getJunctionFromCoord(7,6);
		GraphSucFunction suc = new GraphSucFunction();
		GenericSearchAStar<moveList, Junction> search = new GenericSearchAStar<moveList, Junction>(
				new AStarData<ActionStatePair<moveList, Junction>>(),
				start, suc, goal);
		moveList = search.executeSearch();
		
	}
	
	public void testRoute(){
		assertEquals("[GONORTH, GONORTH, GOEAST, GONORTH, GONORTH, GONORTH, GONORTH, GOEAST, GOEAST, GOSOUTH, GOEAST, GONORTH, GOEAST, GOEAST, GOEAST]",moveList.toString());
	}
}
