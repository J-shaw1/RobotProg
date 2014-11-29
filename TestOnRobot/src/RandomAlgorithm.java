import RobotMovement.FollowUntilJunction;
import RobotMovement.Moves;
import RobotMovement.RobotConfigs;
import rp.robotics.localisation.ActionModel;
import rp.robotics.localisation.GridPositionDistribution;
import rp.robotics.mapping.GridMap;
import rp.robotics.mapping.Heading;
import rp.robotics.mapping.LocalisationUtils;
import searchFramework.ConvertDirToAct;
import lejos.nxt.Button;
import lejos.nxt.Sound;

public class RandomAlgorithm {
	private PerfectSensorModel sensorModel = new PerfectSensorModel();

	GridMap gridMap = LocalisationUtils.create2014Map1();

	GridPositionDistribution gridPosDis = new GridPositionDistribution(gridMap);

	ActionModel actionModel = new PerfectActionModel();

	Moves followLine = new FollowUntilJunction();
	
	private static int highestX = 0;
	private static int highestY = 0;

	public void run() {

		ConvertDirToAct.facingEast();
		gridPosDis = sensorModel.updateReading(gridPosDis, actionModel, Heading.PLUS_X);

		// Starting East
		if (TestDistanceWall.isWallInFront()) {
			gridPosDis = actionModel.pushProbs(gridPosDis,Heading.PLUS_X);
			
		}
		
		while (!thresholdMet(1.0f)) {

			int rand = randomNumber();

			// Up minus Y
			if (rand == 0) {
				Heading heading = Heading.MINUS_Y;			
				
				RobotConfigs.getGONORTH().move();
				ConvertDirToAct.facingNorth();
				updatePosition(heading);
				
				
				if (TestDistanceWall.isWallInFront()) {
					System.out.println("Pushing " + heading);
					gridPosDis = actionModel.pushProbs(gridPosDis,heading);
					
				} else {
					System.out.println("No wall");
					followLine.move();
				}
				gridPosDis = sensorModel.updateReading(gridPosDis, actionModel, heading);

			}
			// right plus X
			else if (rand == 1) {
				Heading heading = Heading.PLUS_X;
				
				RobotConfigs.getGOEAST().move();
				ConvertDirToAct.facingEast();
				updatePosition(heading);
				

				if (TestDistanceWall.isWallInFront()) {
					System.out.println("Pushing " + heading);
					gridPosDis = actionModel.pushProbs(gridPosDis,heading);
				} else {
					System.out.println("No wall");
					followLine.move();
				}
				gridPosDis = sensorModel.updateReading(gridPosDis, actionModel, heading);

			}
			// Down plus Y
			else if (rand == 2) {
				Heading heading = Heading.PLUS_Y;
				
				RobotConfigs.getGOSOUTH().move();
				ConvertDirToAct.facingSouth();	
				updatePosition(heading);

				if (TestDistanceWall.isWallInFront()) {
					System.out.println("Pushing " + heading);
					gridPosDis = actionModel.pushProbs(gridPosDis,heading);
				} else {
					System.out.println("No wall");
					followLine.move();
				}
				gridPosDis = sensorModel.updateReading(gridPosDis, actionModel, heading);

			}
			// left minus X
			else if (rand == 3) {
				Heading heading = Heading.MINUS_X;
				
				RobotConfigs.getGOWEST().move();
				ConvertDirToAct.facingWest();
				updatePosition(heading);

				if (TestDistanceWall.isWallInFront()) {
					System.out.println("Pushing " + heading);
					gridPosDis = actionModel.pushProbs(gridPosDis,heading);
				} else {
					System.out.println("No wall");
					followLine.move();
				}
				gridPosDis = sensorModel.updateReading(gridPosDis, actionModel, heading);

			} else {
				throw new RuntimeException("Random out of range");
			}



		}

	}

	private void updatePosition(Heading action) {
		gridPosDis = actionModel.updateAfterMove(gridPosDis, action);
	}

	private boolean thresholdMet(float threshold) {
		float highestsofar = 0f;
		int total = 0;
		for (int i = 0; i < gridPosDis.getGridWidth(); i++) {
			for (int j = 0; j < gridPosDis.getGridHeight(); j++) {
				if (gridPosDis.isValidGridPoint(i, j)) {
					
					if(gridPosDis.getProbability(i, j) != 0){
						total = total + 1;
					}
					
					if (gridPosDis.getProbability(i, j) > highestsofar){
						highestsofar = gridPosDis.getProbability(i, j);
						highestX = i;
						highestY = j;
					}
					if (gridPosDis.getProbability(i, j) >= threshold) {
						System.out.println("Above threshold");
						System.out.println(i + ", " + j);
						return true;
					}
				}
			}
		}
		System.out.println(highestsofar + " T:" + total);
		System.out.println(highestX + ", " + highestY);
		return false;
	}

	public int randomNumber() {
		return (int) (Math.random() * 4);
	}

	private void runSearch() {
		
		int startX = highestX;
		int startY = 6 - highestY;
		int midX = 5;
		int midY = 5;
		int endX = 0;
		int endY = 0;
	
		
		TestGrid t = new TestGrid(startX,startY,midX,midY);
		TestGrid t2 = new TestGrid(midX,midY,endX,endY);
		
	}
	
	public static void main(String[] args) {
		RobotConfigs.calibrate();
		RandomAlgorithm alg = new RandomAlgorithm();
		alg.run();
		RobotConfigs.getGONORTH().move();
		ConvertDirToAct.facingNorth();
		System.out.println("My X: " + highestX);
		System.out.println("My Y: " + highestY);
		Sound.beep();
		Button.waitForAnyPress();
		alg.runSearch();
		
		System.out.println("finished");
		
		Button.waitForAnyPress();

	}

}
