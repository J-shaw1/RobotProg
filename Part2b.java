import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * The class for part 2, using event driven programming
 */
public class Part2b {

	private final static DifferentialPilot pilot = RobotConfigs.getPilot();

	public static void main(String[] args) {

		SensorPortListener sensor = new Listener(pilot);

		//Add the listener to the sensor port
		SensorPort.S1.addSensorPortListener(sensor);
		SensorPort.S4.addSensorPortListener(sensor);

		Button.waitForAnyPress();
		pilot.forward();
		Button.waitForAnyPress();
	}
}