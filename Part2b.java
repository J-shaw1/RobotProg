import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;

public class Part2b {

	private final static DifferentialPilot pilot = RobotConfigs.getPilot();

	public static void main(String[] args) {

		SensorPortListener sensor = new Listener(pilot);

		SensorPort.S1.addSensorPortListener(sensor);
		SensorPort.S4.addSensorPortListener(sensor);

		Button.waitForAnyPress();
		pilot.forward();
		Button.waitForAnyPress();
	}
}