import java.util.Random;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;


public class Junction implements Behavior, SensorPortListener {
	
	
	private LightSensor leftLightSensor = RobotConfigs.getLeftlightsensor();
	private LightSensor rightLightSensor = RobotConfigs.getRightlightsensor();
	private DifferentialPilot pilot = RobotConfigs.getPilot();
	private boolean suppressFlag = false;
	private Random ran;
	private int random;
	
	

	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean takeControl() {
		
		return (leftLightSensor.getLightValue() < 20)
				&& (rightLightSensor.getLightValue() < 20);
		
	}

	@Override
	public void action() {
		
		pilot.stop();
		
		if(ran.nextInt() > 0){
			pilot.arc(RobotConfigs.getTrackwidth()/2, 90);
		}
		else {
			pilot.arc(RobotConfigs.getTrackwidth()/2, -90);
		}
		
		
		
		while(!suppressFlag && !pilot.isMoving()) {
			
			Thread.yield();
			
		}
		
		pilot.stop();
		suppressFlag = false;

	}

	@Override
	public void suppress() {
		suppressFlag = true;

	}

}
