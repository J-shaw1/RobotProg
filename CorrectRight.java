import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;


public class CorrectRight implements Behavior, SensorPortListener {

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
		
		return (leftLightSensor.getLightValue() < 20);
		
	}

	@Override
	public void action() {
		
		RobotConfigs.getRightmotor().setSpeed((int) RobotConfigs.getRightmotor().getMaxSpeed()/3);
		RobotConfigs.getLeftmotor().setSpeed(100);
		RobotConfigs.getLeftmotor().forward();
		RobotConfigs.getRightmotor().forward();
		
		
		while(!suppressFlag && pilot.isMoving() && (leftLightSensor.getLightValue() < 20)){
			Thread.yield();
		}
		suppressFlag = false;
	}

	@Override
	public void suppress() {
		suppressFlag = true;
	}

}

