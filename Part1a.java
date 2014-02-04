import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Part1a {

	private DifferentialPilot pilot;
	private OpticalDistanceSensor ir;
	private double travelSpeed = 250.0;

	public Part1a() {
		super();
		this.pilot = RobotConfigs.getPilot();
		this.ir = new OpticalDistanceSensor(SensorPort.S3);
	}

	public void run() {

		while (true) {

			if (ir.getDistance() < 100) {
				pilot.setTravelSpeed(150);
				pilot.backward();
			} else if (ir.getDistance() < 150) {

				pilot.stop();
			} else {
				pilot.forward();

				double differance = ir.getDistance() - 450;

				pilot.setTravelSpeed(travelSpeed + differance / 2);
			}

			/*
			 * if (ir.getDistance() != 450) { import lejos.nxt.LightSensor;
			 * 
			 * } else { pilot.forward(); }
			 */

		}

	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		Part1a test = new Part1a();
		test.run();

	}

}
