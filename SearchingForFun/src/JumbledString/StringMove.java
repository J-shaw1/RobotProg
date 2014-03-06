package JumbledString;

/**
 * Represents a move on the jumbled string
 * 
 * @author txr398
 * 
 */
public class StringMove {

	int i;
	int j;

	/**
	 * Sets up the move
	 * 
	 * @param i
	 *            First letter to swap
	 * @param j
	 *            Second letter to swap
	 */
	public StringMove(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public String toString(){
		return "swap " + i + " and " + j;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
