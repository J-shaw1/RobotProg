import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class Part1b {

	private DifferentialPilot pilot;
	private LightSensor l1;
	private LightSensor r1;

	public Part1b() {
		super();
		this.pilot = RobotConfigs.getPilot();
		this.l1 = new LightSensor(SensorPort.S4);
		this.r1 = new LightSensor(SensorPort.S1);
	}

	public void calibrate() {

		l1.setFloodlight(true);
		r1.setFloodlight(true);

		System.out.println("Set low");
		Button.waitForAnyPress();
		l1.calibrateLow();
		r1.calibrateLow();

		System.out.println("Set high");
		Button.waitForAnyPress();
		l1.calibrateHigh();
		r1.calibrateHigh();
	}

	public void run() {

		calibrate();

		pilot.setTravelSpeed(200);

		while (true) {
			if (l1.getLightValue() < 40) {
				pilot.arc(10, 15);
			} else if (r1.getLightValue() < 40) {
				pilot.arc(10, -15);
			} else {
				pilot.forward();
			}

		}
	}

	/*
	 * SensorPort.S4.addSensorPortListener( new SensorPortListener() {
	 * 
	 * @Override public void stateChanged(SensorPort aSource, int aOldValue, int
	 * aNewValue) { // TODO Auto-generated method stub
	 * 
	 * } });
	 */

	/*
	 * while(true){
	 * 
	 * System.out.println(l1.getLightValue() + " |||  " + r1.getLightValue());
	 * 
	 * Delay.msDelay(500);
	 * 
	 * } }
	 */

	public static void main(String[] args) {
		Button.waitForAnyPress();
		Part1b test = new Part1b();
		test.run();

	}

}
