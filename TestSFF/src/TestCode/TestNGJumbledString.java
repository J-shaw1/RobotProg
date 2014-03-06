package TestCode;
import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import searchFramework.AStarData;
import searchFramework.ActionStatePair;
import searchFramework.GenericSearchAStar;
import JumbledString.JumbleSucFunction;
import JumbledString.JumbledString;
import JumbledString.StringMove;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class TestNGJumbledString {
	
	ArrayList<StringMove> moveList;
	
	
	@BeforeMethod
	public void setup(){
		JumbledString start = new JumbledString("dansep");
		JumbledString goal = new JumbledString("sepand");
		JumbleSucFunction suc = new JumbleSucFunction();
		
		GenericSearchAStar<StringMove, JumbledString> search = new GenericSearchAStar<StringMove, JumbledString>(
				new AStarData<ActionStatePair<StringMove, JumbledString>>(),
				start, suc, goal);
		
		
		moveList = search.executeSearch();
		
	}
	
	public void testRoute(){
		assertEquals("[swap 3 and 1, swap 1 and 0, swap 4 and 2, swap 2 and 1, swap 5 and 2]",moveList.toString());
	}
}
