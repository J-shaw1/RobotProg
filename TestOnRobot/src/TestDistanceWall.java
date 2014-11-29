

import lejos.nxt.Button;
import lejos.robotics.RegulatedMotor;
import lejos.util.Delay;
import rp.robotics.mapping.GridMap;
import rp.robotics.mapping.LocalisationUtils;
import RobotMovement.RobotConfigs;

public class TestDistanceWall {

	static GridMap gridMap =  LocalisationUtils.create2014Map1();
	
	public static boolean isWallInFront(){	
		
		return RobotConfigs.getIrsensor().getDistance() < ((gridMap.getCellSize() * 10) + 20 );		
	}
	
	public static boolean[] getDistancesBool(){
		boolean[] values = new boolean[4];
		
		RegulatedMotor sensorMotor = RobotConfigs.getSensormotor();
		
		int delay = 300;
		
		values[0] = TestDistanceWall.isWallInFront();
		sensorMotor.rotate(-90);
		Delay.msDelay(delay);
		values[3] = TestDistanceWall.isWallInFront();
		sensorMotor.rotate(180);
		Delay.msDelay(delay);
		values[1] = TestDistanceWall.isWallInFront();
		sensorMotor.rotate(90);
		Delay.msDelay(delay);
		values[2] = TestDistanceWall.isWallInFront();
		sensorMotor.rotate(-180);
		
		return values;
				
	}
	
	public static void main(String[] args) {
		
		System.out.println(gridMap.getCellSize() + " Reading " + RobotConfigs.getIrsensor().getDistance());
		
		Button.waitForAnyPress();
		while(true){
			//System.out.println(isWallInFront());
			//Button.waitForAnyPress();
			//System.out.println(gridMap.getCellSize() + " Reading " + RobotConfigs.getIrsensor().getDistance());
			boolean [] B = getDistancesBool();
			for (boolean b : B) {
				System.out.println(b);
			}
			
			System.out.println();
			Button.waitForAnyPress();
		}
	}
}
