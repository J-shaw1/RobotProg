
import graphRepresentation.Junction.moveList;
import java.util.ArrayList;
import RobotMovement.Moves;
import RobotMovement.Part2X;
import searchFramework.ConvertDirToAct;


public class TestGrid {
	public TestGrid(int i, int j, int k, int l) {
	ConvertDirToAct part2 = new ConvertDirToAct();
		
		ArrayList<moveList> moves = part2.generateDirections(i,j,k,l);
		//Beep
		//moves.addAll(part2.generateDirections(4, 5, 0, 4));
		ArrayList<Moves> actualMoves = part2.actualMoves(moves);
		Part2X test = new Part2X(actualMoves);
		test.run();
	}

	public static void main(String args[]){

		
		ConvertDirToAct part2 = new ConvertDirToAct();
		
		ArrayList<moveList> moves = part2.generateDirections(0,0,4,4);
		//Beep
		//moves.addAll(part2.generateDirections(4, 5, 0, 4));
		ArrayList<Moves> actualMoves = part2.actualMoves(moves);
		Part2X test = new Part2X(actualMoves);
		test.run();
		
	}
}
