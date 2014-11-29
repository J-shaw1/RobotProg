import java.util.ArrayList;

import jumble.JumbleSucFunction;
import jumble.JumbledString;
import jumble.StringMove;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;


@Test
public class TestNGJumbledString {
	
	ArrayList<StringMove> moveList;
	
	
	@BeforeMethod
	public void setup(){
		JumbledString start = new JumbledString("dansep");
		JumbledString goal = new JumbledString("sepand");
		JumbleSucFunction suc = new JumbleSucFunction();
		
		GenericSearchAStar<StringMove, JumbledString> search = new GenericSearchAStar<StringMove, JumbledString>(
				new AStarData1<ActionStatePair<StringMove, JumbledString>>(),
				start, suc, goal);
		
		
		moveList = search.executeSearch();
		
	}
	
	public void testRoute(){
		assertEquals("[swap 3 and 1, swap 1 and 0, swap 4 and 2, swap 2 and 1, swap 5 and 2]",moveList.toString());
	}
}
