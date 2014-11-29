import lejos.nxt.Button;
import rp.robotics.localisation.ActionModel;
import rp.robotics.localisation.GridPositionDistribution;
import rp.robotics.mapping.GridMap;
import rp.robotics.mapping.Heading;
import rp.robotics.mapping.LocalisationUtils;
import searchFramework.ConvertDirToAct;
import RobotMovement.FollowUntilJunction;
import RobotMovement.Moves;
import RobotMovement.RobotConfigs;

public class CornersAlgorithm {
	private PerfectSensorModel sensorModel = new PerfectSensorModel();

	 GridMap gridMap = LocalisationUtils.create2014Map1();
	
	 GridPositionDistribution gridPosDis = new
	 GridPositionDistribution(gridMap);
	
	 ActionModel actionModel = new PerfectActionModel();

	Moves followLine = new FollowUntilJunction();

	public void run() {
		boolean one = false;
		boolean two = false;
		ConvertDirToAct.facingEast();
		// first corner, going to top right, north east
		for (int i = 0; i < gridMap.getGridWidth(); i++) {
			RobotConfigs.getGOEAST().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.PLUS_X);
			ConvertDirToAct.facingEast();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				one = true;
			}

			RobotConfigs.getGONORTH().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.MINUS_Y);
			ConvertDirToAct.facingNorth();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				two = true;
			}

			if (one && two) {
				one = false;
				two = false;
				break;
			} else {
				one = false;
				two = false;
			}

		}
		
		//Second corner, going to top right, north west
		for (int i = 0; i < gridMap.getGridWidth(); i++) {
			
			RobotConfigs.getGOWEST().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.MINUS_X);
			ConvertDirToAct.facingWest();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				one = true;
			}

			RobotConfigs.getGONORTH().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.MINUS_Y);
			ConvertDirToAct.facingNorth();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				two = true;
			}

			if (one && two) {
				one = false;
				two = false;
				break;
			} else {
				one = false;
				two = false;
			}

		}
		
		//Third corner, bottom left, south west
		for (int i = 0; i < gridMap.getGridWidth(); i++) {
			
			RobotConfigs.getGOWEST().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.MINUS_X);
			ConvertDirToAct.facingWest();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				one = true;
			}

			RobotConfigs.getGOSOUTH().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.PLUS_Y);
			ConvertDirToAct.facingSouth();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				two = true;
			}

			if (one && two) {
				one = false;
				two = false;
				break;
			} else {
				one = false;
				two = false;
			}

		}
		
		//Fourth corner, bottom left, south east
		for (int i = 0; i < gridMap.getGridWidth(); i++) {
			
			RobotConfigs.getGOEAST().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.PLUS_X);
			ConvertDirToAct.facingEast();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				one = true;
			}

			RobotConfigs.getGOSOUTH().move();
			gridPosDis = actionModel.updateAfterMove(gridPosDis,Heading.PLUS_Y);
			ConvertDirToAct.facingSouth();
			if (!TestDistanceWall.isWallInFront()) {
				followLine.move();
			} else {
				two = true;
			}

			if (one && two) {
				one = false;
				two = false;
				break;
			} else {
				one = false;
				two = false;
			}

		}
		
	}
	

	private void runSearch() {
		
		int startX = 10;
		int startY = 0;
		int midX = 5;
		int midY = 5;
		int endX = 0;
		int endY = 0;
	
		
		TestGrid t = new TestGrid(startX,startY,midX,midY);
		TestGrid t2 = new TestGrid(midX,midY,endX,endY);
		
	}
	

	public static void main(String[] args) {
		RobotConfigs.calibrate();
		CornersAlgorithm alg = new CornersAlgorithm();
		//alg.run();
		ConvertDirToAct.facingNorth();
		RobotConfigs.getGONORTH().move();
		ConvertDirToAct.facingNorth();
		alg.runSearch();
		System.out.println("finished");

		Button.waitForAnyPress();

	}
}
