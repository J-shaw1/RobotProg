package TestCode;
import java.util.ArrayList;

import searchFramework.ActionStatePair;
import searchFramework.BreadthFirstData;
import searchFramework.GenericSearch;
import EightPuzzle.EightPuzzle;
import EightPuzzle.EightPuzzle.PuzzleMove;
import EightPuzzle.EightPuzzleSuccessorFunction;

public class EightPuzzleSearch {

	public static void main(String[] args) {
		EightPuzzle puzzle = EightPuzzle.randomEightPuzzle();

		System.out.println(puzzle);
		EightPuzzle puzzle2 = EightPuzzle.orderedEightPuzzle();

		GenericSearch<PuzzleMove, EightPuzzle> search = new GenericSearch<PuzzleMove, EightPuzzle>(
				new BreadthFirstData<ActionStatePair<PuzzleMove, EightPuzzle>>(),
				puzzle, new EightPuzzleSuccessorFunction(), puzzle2);

		ArrayList<PuzzleMove> moveList = search.executeSearch();
		System.out.println(moveList);
	}
}
