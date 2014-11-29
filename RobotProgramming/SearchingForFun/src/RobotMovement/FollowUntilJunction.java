package RobotMovement;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class FollowUntilJunction implements Moves {

	private static final int F_SPEED = 200;

	DifferentialPilot pilot = RobotConfigs.getPilot();
	LightSensor lsLeft = RobotConfigs.getLeftlightsensor();
	LightSensor lsRight = RobotConfigs.getRightlightsensor();

	@Override
	public void move() {

		while (true) {

			if ((lsLeft.getLightValue() < RobotConfigs.getLsLow())
					&& (lsRight.getLightValue() < RobotConfigs.getLsLow())) {
				break;
			} else {

				

				if (lsLeft.getLightValue() < RobotConfigs.getLsLow()) {
					// pilot.arc(10, 15);

					RobotConfigs.getLeftmotor().setSpeed(100);
					RobotConfigs.getRightmotor()
							.setSpeed(
									(int) RobotConfigs.getRightmotor()
											.getMaxSpeed() / 4);

				} else if (lsRight.getLightValue() < RobotConfigs.getLsLow()) {
					// pilot.arc(10, -15);
					
					RobotConfigs.getLeftmotor()
							.setSpeed(
									(int) RobotConfigs.getLeftmotor()
											.getMaxSpeed() / 4);
					RobotConfigs.getRightmotor().setSpeed(100);

				} else {
					// pilot.forward();

					RobotConfigs.getLeftmotor().setSpeed(F_SPEED);
					RobotConfigs.getRightmotor().setSpeed(F_SPEED);
					RobotConfigs.getLeftmotor().forward();
					RobotConfigs.getRightmotor().forward();

				}

			}
		}
		pilot.stop();
		pilot.travel(60);
	}

	@Override
	public String toString() {
		return "Follow line until junction";
	}
}
