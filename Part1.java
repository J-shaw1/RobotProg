import lejos.nxt.Button;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Class for part 1, make the robot spin, and when a button is pressed it will start driving in a square.
 */
public class Part1 {

	public static void main(String[] args) {

		RegulatedMotor rightMotor = RobotConfigs.getRightmotor();

		RegulatedMotor leftMotor = RobotConfigs.getLeftmotor();

		double wheelDiameter = RobotConfigs.getWheelDiameter();
		double trackWidth = RobotConfigs.getTrackWidth();

		DifferentialPilot pilot = new DifferentialPilot(wheelDiameter,
				trackWidth, leftMotor, rightMotor, false);
		
		System.out.println("Hello world!");

		Button.waitForAnyPress();

		leftMotor.backward();
		rightMotor.forward();

		Button.waitForAnyPress();
		leftMotor.stop();
		rightMotor.stop();

		while (true) {
			pilot.travel(300);
			pilot.rotate(90);
		}

	}

}
