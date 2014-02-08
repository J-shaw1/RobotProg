import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class CorrectLeft implements Behavior, SensorPortListener {

	private LightSensor leftLightSensor = RobotConfigs.getLeftlightsensor();
	private LightSensor rightLightSensor = RobotConfigs.getRightlightsensor();
	private DifferentialPilot pilot = RobotConfigs.getPilot();
	private boolean suppressFlag;

	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean takeControl() {

		return (rightLightSensor.getLightValue() < 20);

	}

	@Override
	public void action() {

		RobotConfigs.getLeftmotor().setSpeed(
				(int) RobotConfigs.getLeftmotor().getMaxSpeed() / 3);
		RobotConfigs.getRightmotor().setSpeed(100);
		RobotConfigs.getLeftmotor().forward();
		RobotConfigs.getRightmotor().forward();

		while (!suppressFlag && pilot.isMoving()
				&& (rightLightSensor.getLightValue() < 20)) {
			Thread.yield();
		}
		suppressFlag = false;		
		
	}

	@Override
	public void suppress() {
		suppressFlag = true;
	}

}
