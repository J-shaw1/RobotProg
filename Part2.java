import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class Part2 {

	public static void main(String[] args) {
		
		RobotConfigs.calibrate();
		
		Behavior foward = new Foward();
		Behavior correctLeft = new CorrectLeft();
		Behavior correctRight = new CorrectRight();
		Behavior junction = new Junction();

		Behavior[] behaviors = {foward,correctLeft,correctRight,junction};
		
		Arbitrator arbs = new Arbitrator(behaviors);
		arbs.start();
		
	}

}
