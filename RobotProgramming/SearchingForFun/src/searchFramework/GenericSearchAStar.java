package searchFramework;


import java.util.ArrayList;
import java.util.List;
import Interfaces.Heuristic;
import Interfaces.SortedAgenda;
import Interfaces.SuccessorFunction;

public class GenericSearchAStar<ActionT, StateT extends Heuristic> {

	private SortedAgenda<ActionStatePair<ActionT, StateT>> agenda;
	private ActionStatePair<ActionT, StateT> startState;
	private EqualityGoalTest<StateT> goal;
	private ArrayList<ActionT> actions = new ArrayList<ActionT>();
	private SuccessorFunction<ActionT, StateT> next;
	private ActionStatePair<ActionT, StateT> currState;
	private ArrayList<StateT> explored = new ArrayList<StateT>();

	/**
	 * Constructor for the search
	 * 
	 * @param agendextends Comparable
	 *            What type of agenda to use
	 * @param startState
	 *            The start state
	 * @param next
	 *            The successor function
	 * @param goal
	 *            The goal state
	 */
	public GenericSearchAStar(SortedAgenda<ActionStatePair<ActionT, StateT>> agenda,
			StateT startState, 
			SuccessorFunction<ActionT, StateT> next,
			StateT goal) {
		this.agenda = agenda;
		this.startState = new ActionStatePair<ActionT, StateT>(null, startState);
		this.next = next;
		this.goal = new EqualityGoalTest<StateT>(goal);
	}

	private ArrayList<ActionT> generatePath() {
		while (currState.getParent() != null) {
			actions.add(0, currState.getAction());
			currState = currState.getParent();
		}
		return actions;
	}

	public ArrayList<ActionT> executeSearch() {

		agenda.push(startState);

		int k = 0;

		while (!agenda.isEmpty()) {

			currState = agenda.pop();

			// System.out.println(currState);
			// Button.waitForAnyPress();
			// Delay.msDelay(500);

			// if we find goal statenext.getSuccessors(currState.getState(), successors);
			k++;
			if (goal.isGoal(currState.getState())) {
				System.out.println("found goal");
				System.out.println("States:" + k);
				return generatePath();

			} else {

				List<ActionStatePair<ActionT, StateT>> successors = new ArrayList<ActionStatePair<ActionT, StateT>>();

				next.getSuccessors(currState.getState(), successors);
				
				boolean flag = false;
				
				for(int i = 0; i < successors.size(); i++){		
								
					flag = false;
					
					for(int j = 0; j < explored.size(); j++){
						
						int tempE = explored.get(j).hashCode();
						int tempS = successors.get(i).getState().hashCode();
						if(tempE ==  tempS) {
							flag = true;
							break;
						}
					}
					
					if(!flag){
						successors.get(i).setParent(currState);
						agenda.push(successors.get(i));
						explored.add(successors.get(i).getState());
					}
					agenda.sort();
					
				}
			}

		}

		return null;

	}

}
