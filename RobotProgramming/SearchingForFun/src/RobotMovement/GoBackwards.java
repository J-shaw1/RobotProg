package RobotMovement;

import lejos.robotics.navigation.DifferentialPilot;


public class GoBackwards implements Moves {

	DifferentialPilot pilot = RobotConfigs.getPilot();
	
	@Override
	public void move() {
		pilot.setTravelSpeed(RobotConfigs.getTurnSpeed());
		pilot.arc(0, 180);
	}
	
	@Override
	public String toString() {
		return "Backwards";
	}

}
