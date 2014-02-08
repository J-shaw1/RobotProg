import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Foward implements Behavior, SensorPortListener {

	private LightSensor leftLightSensor = RobotConfigs.getLeftlightsensor();
	private LightSensor rightLightSensor = RobotConfigs.getRightlightsensor();
	private DifferentialPilot pilot = RobotConfigs.getPilot();
	private boolean suppressFlag = false;

	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean takeControl() {

		return (leftLightSensor.getLightValue() > 70)
				&& (rightLightSensor.getLightValue() > 70);
	}

	@Override
	public void action() {
		
		RobotConfigs.getLeftmotor().setSpeed(300);
		RobotConfigs.getRightmotor().setSpeed(300);
		RobotConfigs.getLeftmotor().forward();
		RobotConfigs.getRightmotor().forward();
		
		while(!suppressFlag){
			Thread.yield();
		}
		suppressFlag = false;

	}

	@Override
	public void suppress() {
		suppressFlag = true;

	}

}
