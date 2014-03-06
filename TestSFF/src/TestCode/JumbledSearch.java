package TestCode;


import java.util.ArrayList;

import searchFramework.AStarData;
import searchFramework.ActionStatePair;
import searchFramework.GenericSearchAStar;
import JumbledString.JumbleSucFunction;
import JumbledString.JumbledString;
import JumbledString.StringMove;

public class JumbledSearch {

	public static void main(String[] args) {
		
		JumbledString start = new JumbledString("ltsolonggtshhriiinlsea");
		JumbledString goal = new JumbledString("hellothisisalongstring");
		JumbleSucFunction suc = new JumbleSucFunction();
		
		GenericSearchAStar<StringMove, JumbledString> search = new GenericSearchAStar<StringMove, JumbledString>(
				new AStarData<ActionStatePair<StringMove, JumbledString>>(),
				start, suc, goal);
		
		
		ArrayList<StringMove> moves = search.executeSearch();
		System.out.println(moves);
		
		
	}

}
