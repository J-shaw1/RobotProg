import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Part3 {

	public static void main(String[] args) {

		DifferentialPilot pilot = RobotConfigs.getPilot();

		UltrasonicSensor uSensor = new UltrasonicSensor(SensorPort.S2);

		TouchSensor t1 = new TouchSensor(SensorPort.S1);
		TouchSensor t2 = new TouchSensor(SensorPort.S4);
		Button.waitForAnyPress();
		uSensor.continuous();

		while (true) {
			pilot.forward();

			System.out.println(uSensor.getDistance());

			if (uSensor.getDistance() > 75) {
				pilot.arc(10, 30);
				pilot.travel(120);
			}

			if (uSensor.getDistance() < 15) {
				pilot.arc(-8, -20);

				while (uSensor.getDistance() < 5
						|| uSensor.getDistance() == 255) {
					pilot.travel(-50);
				}
			}

			if (t1.isPressed()) {
				pilot.travel(-75);
				pilot.arc(0, 52);
			}

			if (t2.isPressed()) {
				pilot.travel(-75);
				pilot.arc(0, -52);
			}

			if (t1.isPressed() || t2.isPressed() && uSensor.getDistance() < 7) {
				pilot.arc(0, 180);
				pilot.travel(120);
				pilot.arc(0, 60);
			}
		}
	}
}
