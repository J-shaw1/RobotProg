import lejos.nxt.Button;
import RobotMovement.RobotConfigs;

public class testDistance {
	public static void main(String[] args) {
		
		Button.waitForAnyPress();
		
		int[] values = RobotConfigs.getDistances();
		
		for (int i : values) {
			System.out.println(i);
		}
		
		Button.waitForAnyPress();
	}
}
