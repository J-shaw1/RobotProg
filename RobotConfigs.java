import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Contains all the mesurements of our robot
 */
public class RobotConfigs {

	private static final double wheelDiameter = 56.0;
	private static final double trackWidth = 128.0;
	private static final RegulatedMotor rightMotor = Motor.A;
	private static final RegulatedMotor leftMotor = Motor.B;
	private static final DifferentialPilot pilot = new DifferentialPilot(
			wheelDiameter, trackWidth, leftMotor, rightMotor, false);

	/**
	 * Return the differential pilot
	 * @return pilot The differential pilot used to drive our robot
	 */
	public static DifferentialPilot getPilot() {
		return pilot;
	}

	/**
	 * Returns the right motor
	 * @return rightMotor The right motor
	 */
	public static RegulatedMotor getRightmotor() {
		return rightMotor;
	}

	/**
	 * Returns the left motor
	 * @return leftMotor The left motor
	 */
	public static RegulatedMotor getLeftmotor() {
		return leftMotor;
	}

	/**
	 * Returns the wheel diameter
	 * @return wheelDiameter The wheel diameter
	 */
	public static double getWheelDiameter() {
		return wheelDiameter;
	}

	/**
	 * Returns the track width
	 * @return trackWidth The track  width
	 */
	public static double getTrackWidth() {
		return trackWidth;
	}

}
