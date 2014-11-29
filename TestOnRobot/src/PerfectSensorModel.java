

import rp.robotics.localisation.ActionModel;
import rp.robotics.localisation.GridPositionDistribution;
import rp.robotics.mapping.Heading;

public class PerfectSensorModel {

	public GridPositionDistribution updateReading(
			GridPositionDistribution _from, ActionModel actionModel,
			Heading heading) {		
		
		//GridPositionDistribution to = new GridPositionDistribution(_from);

		if (heading == Heading.PLUS_X) {
			_from = pushSensorPlusX(actionModel, _from);
		} else if (heading == Heading.PLUS_Y) {
			_from = pushSensorPlusY(actionModel, _from);
		} else if (heading == Heading.MINUS_X) {
			_from = pushSensorMinusX(actionModel, _from);
		} else if (heading == Heading.MINUS_Y) {
			_from = pushSensorMinusY(actionModel, _from);
		}
		return _from;

	}

	private GridPositionDistribution pushSensorPlusX(ActionModel actionModel, GridPositionDistribution _from) {
		boolean[] bools = TestDistanceWall.getDistancesBool();
		if(bools[0]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_X);
		}
		
		if(bools[1]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_Y);
		}
		
		if(bools[2]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_X);
		}
		if(bools[3]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_Y);
		}
		
		return _from;
	}

	private GridPositionDistribution pushSensorPlusY(ActionModel actionModel, GridPositionDistribution _from) {
		boolean[] bools = TestDistanceWall.getDistancesBool();
		if(bools[0]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_Y);
		}
		
		if(bools[1]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_X);
		}
		
		if(bools[2]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_Y);
		}
		if(bools[3]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_X);
		}
		return _from;
	}

	private GridPositionDistribution pushSensorMinusX(ActionModel actionModel, GridPositionDistribution _from) {
		boolean[] bools = TestDistanceWall.getDistancesBool();
		if(bools[0]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_X);
		}
		
		if(bools[1]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_Y);
		}
		
		if(bools[2]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_X);
		}
		if(bools[3]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_Y);
		}
		return _from;
	}

	private GridPositionDistribution pushSensorMinusY(ActionModel actionModel, GridPositionDistribution _from) {
		boolean[] bools = TestDistanceWall.getDistancesBool();
		if(bools[0]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_Y);
		}
		
		if(bools[1]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_X);
		}
		
		if(bools[2]){
			_from = actionModel.pushProbs(_from, Heading.PLUS_Y);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.PLUS_Y);
		}
		if(bools[3]){
			_from = actionModel.pushProbs(_from, Heading.MINUS_X);
		}
		else{
			_from = actionModel.setZeroWall(_from, Heading.MINUS_X);
		}
		return _from;
	}

}
