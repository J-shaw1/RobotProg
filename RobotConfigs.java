import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;


public class RobotConfigs {

	private static final double wheelDiameter = 56.0;
	private static final double trackWidth = 128.0;
	private static final RegulatedMotor rightMotor = Motor.A;
	private static final RegulatedMotor leftMotor = Motor.B;
	private static final DifferentialPilot pilot = new DifferentialPilot(wheelDiameter,
			trackWidth, leftMotor, rightMotor, false);
	
	
	public static DifferentialPilot getPilot() {
		return pilot;
	}


	public static double getWheeldiameter() {
		return wheelDiameter;
	}


	public static double getTrackwidth() {
		return trackWidth;
	}


	public static RegulatedMotor getRightmotor() {
		return rightMotor;
	}


	public static RegulatedMotor getLeftmotor() {
		return leftMotor;
	}
}
