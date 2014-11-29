
import rp.robotics.localisation.ActionModel;
import rp.robotics.localisation.GridPositionDistribution;
import rp.robotics.mapping.Heading;

/**
 * Example structure for an action model that should move the probabilities 1
 * cell in the requested direction. In the case where the move would take the
 * robot into an obstacle or off the map, this model assumes the robot stayed in
 * one place. This is the same as the model presented in Robot Programming
 * Lecture 14.
 * 
 * Note that this class doesn't actually do this, instead it shows you a
 * <b>possible</b> structure for your action model.
 * 
 * @author nah
 * 
 */
public class PerfectActionModel implements ActionModel {

	@Override
	public GridPositionDistribution updateAfterMove(
			GridPositionDistribution _from, Heading _heading) {

		// Create the new distribution that will result from applying the action
		// modgetDistancesBool()el
		GridPositionDistribution to = new GridPositionDistribution(_from);

		// Move the probability in the correct direction for the action
		if (_heading == Heading.PLUS_X) {
			movePlusX(_from, to);
		} else if (_heading == Heading.PLUS_Y) {
			movePlusY(_from, to);
		} else if (_heading == Heading.MINUS_X) {
			moveMinusX(_from, to);
		} else if (_heading == Heading.MINUS_Y) {
			moveMinusY(_from, to);
		}
		to.normalise();
		return to;
	}

	/**
	 * Move probabilities from _from one cell in the plus x direction into _to
	 * 
	 * @param _from
	 * @param _to
	 */
	private void movePlusX(GridPositionDistribution _from,
			GridPositionDistribution _to) {
		float tim = 0;

		// iterate through points updating as appropriate
		for (int y = 0; y < _to.getGridHeight(); y++) {

			for (int x = 0; x < _to.getGridWidth(); x++) {

				// make sure to respect obstructed grid points
				if (!_to.isObstructed(x, y)) {

					// Put the value of the current junction prob = joe
					float joe = _from.getProbability(x, y);

					// Check that you can make the transition to the next point
					if (_to.getGridMap().isValidTransition(x, y, x + 1, y)) {

						// Set the current prob of tim, starts off at 0
						_to.setProbability(x, y, tim);

						// So on the next loop round tim has the value of the
						// previous junction prob
						tim = joe;

						// If we can not make the transition
					} else {

						// Set the current if you cannot move to the right to
						// sum of tim and joe
						_to.setProbability(x, y, tim + joe);

						// restart tim to 0, so that it starts as zero again on
						// the other side of the wall
						tim = 0;

					}
				}
			}
		}
	}

	private void movePlusY(GridPositionDistribution _from,
			GridPositionDistribution _to) {
		float tim = 0;

		// iterate through points updating as appropriate
		for (int x = 0; x < _to.getGridWidth(); x++) {

			for (int y = 0; y < _to.getGridHeight(); y++) {

				// make sure to respect obstructed grid points
				if (!_to.isObstructed(x, y)) {

					// Put the value of the current junction prob = joe
					float joe = _from.getProbability(x, y);

					// Check that you can make the transition to the next point
					if (_to.getGridMap().isValidTransition(x, y, x, y + 1)) {

						// Set the current prob of tim, starts off at 0
						_to.setProbability(x, y, tim);
						// iterate through points updating as appropriate
						// So on the next loop round tim has the value of the
						// previous junction prob
						tim = joe;

						// If we can not make the transition
					} else {

						// Set the current if you cannot move to the right to
						// sum of tim and joe
						_to.setProbability(x, y, tim + joe);

						// restart tim to 0, so that it starts as zero again on
						// the other side of the wall
						tim = 0;

					}
				}
			}
		}
	}

	private void moveMinusX(GridPositionDistribution _from,
			GridPositionDistribution _to) {
		float tim = 0;

		// iterate through points updating as appropriate
		for (int y = _to.getGridHeight() - 1; y >= 0; y--) {

			for (int x = _to.getGridWidth() - 1; x >= 0; x--) {

				// make sure to respect obstructed grid points
				if (!_to.isObstructed(x, y)) {

					// Put the value of the current junction prob = joe
					float joe = _from.getProbability(x, y);

					// Check that you can make the transition to the next point
					if (_to.getGridMap().isValidTransition(x, y, x - 1, y)) {

						// Set the current prob of tim, starts off at 0
						_to.setProbability(x, y, tim);

						// So on the next loop round tim has the value of the
						// previous junction prob
						tim = joe;

						// If we can not make the transition
					} else {

						// Set the current if you cannot move to the right to
						// sum of tim and joe
						_to.setProbability(x, y, tim + joe);

						// restart tim to 0, so that it starts as zero again on
						// the other side of the wall
						tim = 0;

					}
				}
			}
		}
	}

	private void moveMinusY(GridPositionDistribution _from,
			GridPositionDistribution _to) {
		float tim = 0;

		// iterate through points updating as appropriate

		for (int x = _to.getGridWidth() - 1; x >= 0; x--) {

			for (int y = _to.getGridHeight() - 1; y >= 0; y--) {

				// make sure to respect obstructed grid points
				if (!_to.isObstructed(x, y)) {

					// Put the value of the current junction prob = joe
					float joe = _from.getProbability(x, y);

					// Check that you can make the transition to the next point
					if (_to.getGridMap().isValidTransition(x, y, x, y - 1)) {
						// Set the current prob of tim, starts off at 0
						_to.setProbability(x, y, tim);

						// So on the next loop round tim has the value of the
						// previous junction prob
						tim = joe;

						// If we can not make the transition
					} else {

						// Set the current if you cannot move to the right to
						// sum of tim and joe
						_to.setProbability(x, y, tim + joe);

						// restart tim to 0, so that it starts as zero again on
						// the other side of the wall
						tim = 0;

					}
				}
			}
		}
	}

	@Override
	public GridPositionDistribution pushProbs(GridPositionDistribution _from,
			Heading _heading) {

		// Create the new distribution that will result from applying the action
		// model
		GridPositionDistribution to = new GridPositionDistribution(_from);

		// Move the probability in the correct direction for the action
		if (_heading == Heading.PLUS_X) {
			pushPlusX(_from, to);
		} else if (_heading == Heading.PLUS_Y) {
			pushPlusY(_from, to);
		} else if (_heading == Heading.MINUS_X) {
			pushMinusX(_from, to);
		} else if (_heading == Heading.MINUS_Y) {
			pushMinusY(_from, to);
		}

		to.normalise();
		return to;
	}

	private void pushPlusX(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		// iterate through points updating as appropriate
		for (int y = 0; y < _to.getGridHeight(); y++) {

			float total = 0;

			for (int x = 0; x < _to.getGridWidth(); x++) {

				if (!_to.isObstructed(x, y)) {

					total += _from.getProbability(x, y);
					_to.setProbability(x, y, 0);

					if (!_to.getGridMap().isValidTransition(x, y, x + 1, y)) {
						_to.setProbability(x, y, total);
						total = 0;
					}
				}
			}
		}
	}

	private void pushPlusY(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		for (int x = 0; x < _to.getGridWidth(); x++) {

			float total = 0;

			for (int y = 0; y < _to.getGridHeight(); y++) {

				if (!_to.isObstructed(x, y)) {

					total += _from.getProbability(x, y);
					_to.setProbability(x, y, 0);

					if (!_to.getGridMap().isValidTransition(x, y, x, y + 1)) {
						_to.setProbability(x, y, total);
						total = 0;
					}
				}
			}
		}
	}

	private void pushMinusX(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		for (int y = _to.getGridHeight() - 1; y >= 0; y--) {
			float total = 0;
			for (int x = _to.getGridWidth() - 1; x >= 0; x--) {

				total += _from.getProbability(x, y);
				_to.setProbability(x, y, 0);

				if (!_to.getGridMap().isValidTransition(x, y, x - 1, y)) {
					_to.setProbability(x, y, total);
					total = 0;
				}
			}
		}
	}

	private void pushMinusY(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		for (int x = _to.getGridWidth() - 1; x >= 0; x--) {
			float total = 0;
			for (int y = _to.getGridHeight() - 1; y >= 0; y--) {

				if (!_to.isObstructed(x, y)) {

					total += _from.getProbability(x, y);
					_to.setProbability(x, y, 0);

					if (!_to.getGridMap().isValidTransition(x, y, x, y - 1)) {
						_to.setProbability(x, y, total);
						total = 0;
					}
				}
			}
		}
	}

	@Override
	public GridPositionDistribution setZeroWall(GridPositionDistribution _from,
			Heading _heading) {

		// Create the new distribution that will result from applying the action
		// model
		GridPositionDistribution to = new GridPositionDistribution(_from);

		// Move the probability in the correct direction for the action
		if (_heading == Heading.PLUS_X) {
			zeroPlusX(_from, to);
		} else if (_heading == Heading.PLUS_Y) {
			zeroPlusY(_from, to);
		} else if (_heading == Heading.MINUS_X) {
			zeroMinusX(_from, to);
		} else if (_heading == Heading.MINUS_Y) {
			zeroMinusY(_from, to);
		}

		to.normalise();
		return to;

	}

	private void zeroPlusX(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		for (int y = 0; y < _to.getGridHeight(); y++) {
			for (int x = 0; x < _to.getGridWidth(); x++) {
				if (!_to.isObstructed(x, y)) {
					if (!_to.getGridMap().isValidTransition(x, y, x + 1, y)) {
						_to.setProbability(x, y, 0);
					}
				}
			}
		}

	}

	private void zeroPlusY(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		for (int x = 0; x < _to.getGridWidth(); x++) {
			for (int y = 0; y < _to.getGridHeight(); y++) {

				if (!_to.isObstructed(x, y)) {
					if (!_to.getGridMap().isValidTransition(x, y, x, y + 1)) {
						_to.setProbability(x, y, 0);
					}
				}
			}
		}

	}

	private void zeroMinusX(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		for (int y = _to.getGridHeight() - 1; y >= 0; y--) {
			for (int x = _to.getGridWidth() - 1; x >= 0; x--) {
				if (!_to.isObstructed(x, y)) {
					if (!_to.getGridMap().isValidTransition(x, y, x - 1, y)) {
						_to.setProbability(x, y, 0);
					}
				}
			}
		}

	}

	private void zeroMinusY(GridPositionDistribution _from,
			GridPositionDistribution _to) {

		for (int x = _to.getGridWidth() - 1; x >= 0; x--) {
			for (int y = _to.getGridHeight() - 1; y >= 0; y--) {
				if (!_to.isObstructed(x, y)) {
					if (!_to.getGridMap().isValidTransition(x, y, x, y - 1)) {
						_to.setProbability(x, y, 0);
					}
				}
			}
		}

	}

}
