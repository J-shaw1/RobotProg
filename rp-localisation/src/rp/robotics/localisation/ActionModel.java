package rp.robotics.localisation;

import rp.robotics.mapping.Heading;

/**
 * An example of an interface an action model might provide.
 * 
 * Note: you do not have to use this if you don't want to.
 * 
 * @author nah
 * 
 */
public interface ActionModel {

	public GridPositionDistribution updateAfterMove(GridPositionDistribution _dist,
			Heading _heading);

	public GridPositionDistribution pushProbs(GridPositionDistribution _from,
			Heading _heading);

	public GridPositionDistribution setZeroWall(GridPositionDistribution _from, Heading heading);

}
