package JumbledString;

import java.util.List;

import searchFramework.ActionStatePair;
import Interfaces.SuccessorFunction;

public class JumbleSucFunction implements
		SuccessorFunction<StringMove, JumbledString> {

	@Override
	public void getSuccessors(JumbledString _state,
			List<ActionStatePair<StringMove, JumbledString>> _successors) {

		for (int i = 0; i < _state.getLength(); i++) {
			for (int j = i; j >= 0; j--) {

				if (i != j) {
					
					//System.out.println("Adding successor " + i + " " + j);

					StringMove tempMove = new StringMove(i, j);
					JumbledString tempString = new JumbledString(_state.toString());
					tempString.swap(tempMove);

					ActionStatePair<StringMove, JumbledString> tempPair = new ActionStatePair<StringMove, JumbledString>(
							tempMove, tempString);
					
					_successors.add(tempPair);
				}
			}
		}

	}

}
