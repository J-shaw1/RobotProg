package JumbledString;

import Interfaces.Heuristic;

public class JumbledString implements Heuristic{

	//Current state of the string
	private final char[] goal = "sepand".toCharArray();
	private char[] state;
	
	/**
	 * Constructor turn the given string in to the char array
	 * @param _string A string to be stored in the state an as array
	 */
	public JumbledString(String _string) {
		state = _string.toCharArray();
	}
	
	/**
	 * Constructor to initialise the state from a char array
	 * @param _chars The char array to set the state equal to
	 */
	public JumbledString(char[] _chars){
		this.state = _chars;
	}
	
	/**
	 * Performs a swap between two given indexed in a StringMove type
	 * @param move Contains the two positions to swap
	 */
	public void swap(StringMove move){
		
		int i = move.getI();
		int j = move.getJ();
		
		char temp = state[i];
		state[i] = state[j];
		state[j] = temp;
		
	}
	
	@Override
	public JumbledString clone(){
		
		JumbledString returner = new JumbledString(this.state.toString());
		return returner;
		
	}
	public char[] getCharArray(){
		return state;
	}
	public char getState(int i) {
		return state[i];
	}

	public void setState(char c, int i) {
		this.state[i] = c;
	}

	public String toString(){
		String temp = "";
		for(int i = 0; i < state.length; i++){
			temp = temp + state[i];
		}
		
		return temp;
	}
	
	public int hashCode(){
		return state.hashCode();
	}
	
	@Override
	public boolean equals(Object _state){
		JumbledString testJS = (JumbledString)_state;
		char[] test = testJS.getCharArray();
		for (int i = 0; i < state.length; i++) {
			if(state[i] != test[i]){
				return false;
			}
		}
		return true;
	}
	
	public int getLength() {
		return state.length;
	}

	@Override
	public int getHeuristic() {
		int total = state.length;
		for (int i = 0; i < state.length; i++) {
			if(state[i] == goal[i]){
				total--;
			}
		}
		return total;
	}

}
