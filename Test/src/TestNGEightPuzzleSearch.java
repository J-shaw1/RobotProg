import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;


@Test
public class TestNGEightPuzzleSearch {
	
	ArrayList<PuzzleMove> moveList;
	
	
	@BeforeMethod
	public void setup(){
		EightPuzzle puzzle = EightPuzzle.orderedEightPuzzle();

		puzzle.makeMove(EightPuzzle.PuzzleMove.UP);
		puzzle.makeMove(EightPuzzle.PuzzleMove.UP);

		EightPuzzle puzzle2 = EightPuzzle.orderedEightPuzzle();

		GenericSearch<PuzzleMove, EightPuzzle> search = new GenericSearch<PuzzleMove, EightPuzzle>(
				new BreadthFirstData<ActionStatePair<PuzzleMove, EightPuzzle>>(),
				puzzle, new EightPuzzleSuccessorFunction(), puzzle2);

		moveList = search.executeSearch();
		
	}
	
	public void testRoute(){
		assertEquals("[DOWN, DOWN]",moveList.toString());
	}
}
