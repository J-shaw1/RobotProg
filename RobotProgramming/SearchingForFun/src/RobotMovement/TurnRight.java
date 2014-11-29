package RobotMovement;

import lejos.robotics.navigation.DifferentialPilot;


public class TurnRight implements Moves {

	DifferentialPilot pilot = RobotConfigs.getPilot();
	
	@Override
	public void move() {
		pilot.setTravelSpeed(RobotConfigs.getTurnSpeed());
		pilot.arc(0, -90);

	}
	public String toString(){
		return "right";
	}

}
