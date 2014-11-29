package TestCode;
import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import searchFramework.ActionStatePair;
import searchFramework.BreadthFirstData;
import searchFramework.GenericSearch;
import EightPuzzle.EightPuzzle;
import EightPuzzle.EightPuzzle.PuzzleMove;
import EightPuzzle.EightPuzzleSuccessorFunction;
import static org.testng.AssertJUnit.assertEquals;

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
