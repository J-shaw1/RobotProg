package graphRepresentation;

import graphRepresentation.Junction.moveList;

import java.util.ArrayList;
import java.util.List;

import searchFramework.ActionStatePair;
import Interfaces.SuccessorFunction;

public class GraphSucFunction implements SuccessorFunction<moveList, Junction> {

	@Override
	public void getSuccessors(Junction _state,
			List<ActionStatePair<moveList, Junction>> _successors) {
		ArrayList<ActionStatePair<moveList, Junction>> moves = _state
				.getSuccessors();
		for (int i = 0; i < moves.size(); i++) {

			_successors.add(moves.get(i));
		}
	}
}
