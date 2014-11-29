import java.util.ArrayList;

import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;

public class EightPuzzleSearch {

	public static void main(String[] args) {
		EightPuzzle puzzle = EightPuzzle.randomEightPuzzle();

		puzzle.makeMove(EightPuzzle.PuzzleMove.UP);

		System.out.println(puzzle);
		EightPuzzle puzzle2 = EightPuzzle.orderedEightPuzzle();

		GenericSearch<PuzzleMove, EightPuzzle> search = new GenericSearch<PuzzleMove, EightPuzzle>(
				new BreadthFirstData<ActionStatePair<PuzzleMove, EightPuzzle>>(),
				puzzle, new EightPuzzleSuccessorFunction(), puzzle2);

		ArrayList<PuzzleMove> moveList = search.executeSearch();
		System.out.println(moveList);
	}
}
