package searchFramework;

import graphRepresentation.GraphSucFunction;
import graphRepresentation.Grid;
import graphRepresentation.Junction.moveList;

import java.util.ArrayList;

import RobotMovement.GoBackwards;
import RobotMovement.GoFoward;
import RobotMovement.Moves;
import RobotMovement.Part2X;
import RobotMovement.RobotConfigs;
import RobotMovement.TurnLeft;
import RobotMovement.TurnRight;
import graphRepresentation.Junction;

public class ConvertDirToAct {

	public static void main(String[] args) {
		ConvertDirToAct part2 = new ConvertDirToAct();

		ArrayList<moveList> moves = part2.generateDirections();
		ArrayList<Moves> actualMoves = part2.actualMoves(moves);
		Part2X test = new Part2X(actualMoves);
		test.run();

	}

	private ArrayList<Moves> actualMoves(ArrayList<moveList> moves) {

		ArrayList<Moves> actualMoveList = new ArrayList<Moves>();

		if(moves.get(0) == Junction.moveList.GONORTH) facingNorth();
		else if(moves.get(0) == Junction.moveList.GOEAST) facingEast();
		else if(moves.get(0) == Junction.moveList.GOSOUTH) facingSouth();
		else if(moves.get(0) == Junction.moveList.GOWEST) facingWest();

		for (int i = 0; i < moves.size(); i++) {
			moveList workingMove = moves.get(i);

			// Add the actual direction object GOEASTto the actualMoveList
			if (workingMove == Junction.moveList.GONORTH) {
				//facingNorth();
				actualMoveList.add(RobotConfigs.getGONORTH());
				facingNorth();
			} else if (workingMove == Junction.moveList.GOEAST) {
				actualMoveList.add(RobotConfigs.getGOEAST());
				facingEast();
			} else if (workingMove == Junction.moveList.GOSOUTH) {
				actualMoveList.add(RobotConfigs.getGOSOUTH());
				facingSouth();
			} else if (workingMove == Junction.moveList.GOWEST) {
				actualMoveList.add(RobotConfigs.getGOWEST());
				facingWest();
			}

		}
		return actualMoveList;
	}
	private void facingNorth() {
		RobotConfigs.setGONORTH(new GoFoward());
		RobotConfigs.setGOEAST(new TurnRight());
		RobotConfigs.setGOSOUTH(new GoBackwards());
		RobotConfigs.setGOWEST(new TurnLeft());
	}

	private void facingEast() {
		RobotConfigs.setGONORTH(new TurnLeft());
		RobotConfigs.setGOEAST(new GoFoward());
		RobotConfigs.setGOSOUTH(new TurnRight());
		RobotConfigs.setGOWEST(new GoBackwards());
	}

	private void facingSouth() {
		RobotConfigs.setGONORTH(new GoBackwards());
		RobotConfigs.setGOEAST(new TurnLeft());
		RobotConfigs.setGOSOUTH(new GoFoward());
		RobotConfigs.setGOWEST(new TurnRight());
	}

	private void facingWest() {
		RobotConfigs.setGONORTH(new TurnRight());
		RobotConfigs.setGOEAST(new GoBackwards());
		RobotConfigs.setGOSOUTH(new TurnLeft());
		RobotConfigs.setGOWEST(new GoFoward());
	}

	public ArrayList<moveList> generateDirections() {
		Grid grid = new Grid();
		Junction start = grid.getJunctionFromCoord(0, 0);
		Junction goal = grid.getJunctionFromCoord(5, 5);
		GraphSucFunction suc = new GraphSucFunction();
		GenericSearch<moveList, Junction> search = new GenericSearch<Junction.moveList, Junction>(
				new BreadthFirstData<ActionStatePair<moveList, Junction>>(),
				start, suc, goal);
		ArrayList<moveList> moves = search.executeSearch();
		return moves;
		
	}

}
