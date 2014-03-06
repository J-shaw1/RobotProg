package RobotMovement;

import lejos.robotics.navigation.DifferentialPilot;

public class GoFoward implements Moves {

	DifferentialPilot pilot = RobotConfigs.getPilot();

	@Override
	public void move() {
		pilot.setTravelSpeed(RobotConfigs.getTurnSpeed());
		pilot.travel(50);
	}

	public String toString() {
		return "Forward";
	}

}
