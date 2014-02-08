import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class Part2X {

	private DifferentialPilot pilot;
	private LightSensor l1;
	private LightSensor r1;

	public Part2X() {
		super();
		this.pilot = RobotConfigs.getPilot();
		this.l1 = RobotConfigs.getLeftlightsensor();
		this.r1 = RobotConfigs.getRightlightsensor();
	}

	public void run() {

		RobotConfigs.calibrate();

		pilot.setTravelSpeed(200);
		
		System.out.println(RobotConfigs.getRightmotor().getMaxSpeed());
		
		while (true) {
			if((l1.getLightValue() < 70) && (r1.getLightValue() < 70)){
				pilot.arc(RobotConfigs.getTrackwidth()/2, 90);
			}
			else if (l1.getLightValue() < 70) {
				//pilot.arc(10, 15);
				
				RobotConfigs.getLeftmotor().setSpeed(100);
				RobotConfigs.getRightmotor().setSpeed((int) RobotConfigs.getRightmotor().getMaxSpeed());
				
				
			} else if (r1.getLightValue() < 70) {
				//pilot.arc(10, -15);
				

				RobotConfigs.getLeftmotor().setSpeed((int) RobotConfigs.getLeftmotor().getMaxSpeed());
				RobotConfigs.getRightmotor().setSpeed(100);
				
			} else {
				//pilot.forward();
				

				RobotConfigs.getLeftmotor().setSpeed(100);
				RobotConfigs.getRightmotor().setSpeed(100);
				RobotConfigs.getLeftmotor().forward();
				RobotConfigs.getRightmotor().forward();
				
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
		Part2X test = new Part2X();
		test.run();

	}
	
	
}
