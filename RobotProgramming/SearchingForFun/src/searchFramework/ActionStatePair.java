/**
 * 
 */
package searchFramework;

import Interfaces.Heuristic;

/**
 * A class to store an action and the state it has produced together.
 * 
 * @author nah
 * 
 */
public class ActionStatePair<ActionT, StateT extends Heuristic> implements Comparable<ActionStatePair<ActionT, StateT>>{//implements Comparable<ActionStatePair<ActionT, StateT>>{

	private int hValue;
	
	private final ActionT m_action;
	private final StateT m_state;
	private ActionStatePair<ActionT, StateT> parent;

	public ActionStatePair<ActionT, StateT> getParent() {
		return parent;
	}

	public void setParent(ActionStatePair<ActionT, StateT> parent) {
		this.parent = parent;
	}

	/**ActionStatePair<PuzzleMove, EightPuzzle>
	 * Construct the pair from input values.
	 * 
	 * @param _action
	 * @param _state
	 */
	public ActionStatePair(ActionT _action, StateT _state) {
		m_action = _action;
		m_state = _state;
		parent = null;
		hValue = _state.getHeuristic();
		//System.out.println("Adding H value: " + hValue);
	}

	/**
	 * Get action.
	 * 
	 * @return
	 */
	public ActionT getAction() {
		return m_action;
	}

	/**
	 * Get state.
	 * 
	 * @return
	 */
	public StateT getState() {
		return m_state;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(m_state);
		if (m_action != null) {
			sb.append("\n -> \n");
			sb.append(m_action);
		}

		return sb.toString();
	}

	@Override
	public int compareTo(ActionStatePair<ActionT, StateT> o) {
		return this.hValue - o.gethValue();
	}

	public int gethValue() {
		return hValue;
	}

	public void sethValue(int hValue) {
		this.hValue = hValue;
	}

	/*
	@Override
	public int compareTo(Object o) {
		StateT state = this.getState();
		StateT otherState = (StateT) o;
		
		return ( (Comparable<StateT>) state).compareTo(otherState);
	}*/

	

}
