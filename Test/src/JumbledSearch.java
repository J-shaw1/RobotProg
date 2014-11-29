

import java.util.ArrayList;

import jumble.JumbleSucFunction;
import jumble.JumbledString;
import jumble.StringMove;
import rp13.search.util.ActionStatePair;


public class JumbledSearch {

	public static void main(String[] args) {
		
		JumbledString start = new JumbledString("inkc");
		JumbledString goal = new JumbledString("nick");
		JumbleSucFunction suc = new JumbleSucFunction();
		
		GenericSearchAStar<StringMove, JumbledString> search = new GenericSearchAStar<StringMove, JumbledString>(
				new AStarData1<ActionStatePair<StringMove, JumbledString>>(),
				start, suc, goal);
		
		
		ArrayList<StringMove> moves = search.executeSearch();
		System.out.println(moves);
		
		
	}

}
