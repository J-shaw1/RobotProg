import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * The bump and turn class, using while loops to detect events
 */
public class Part2a {

	public static void main(String[] args) {
		RegulatedMotor rightMotor = RobotConfigs.getRightmotor();

		RegulatedMotor leftMotor = RobotConfigs.getLeftmotor();

		double wheelDiameter = RobotConfigs.getWheelDiameter();
		double trackWidth = RobotConfigs.getTrackWidth();

		DifferentialPilot pilot = new DifferentialPilot(wheelDiameter,
				trackWidth, leftMotor, rightMotor, false);

		TouchSensor t1 = new TouchSensor(SensorPort.S1);
		TouchSensor t2 = new TouchSensor(SensorPort.S4);
		Button.waitForAnyPress();
		while (true) {
			pilot.forward();
			if (t1.isPressed() || t2.isPressed()) {

				pilot.travel(-100);
				pilot.arc(0, 180);

			}
		}
	}
}
