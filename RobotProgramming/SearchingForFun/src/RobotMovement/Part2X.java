package RobotMovement;

import java.util.ArrayList;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Part2X {

	private ArrayList<Moves> moveList = new ArrayList<Moves>();
	private DifferentialPilot pilot;
	private LightSensor l1;
	private LightSensor r1;
	private static final int F_SPEED = 150;

	public Part2X(ArrayList<Moves> movelist) {
		super();
		this.moveList.addAll(movelist);
		for (Moves m : moveList) {
			System.out.print(m);
			System.out.print(",");
		}
		this.pilot = RobotConfigs.getPilot();
		this.l1 = RobotConfigs.getLeftlightsensor();
		this.r1 = RobotConfigs.getRightlightsensor();
	}

	public void run() {

		int i = 0;
		// System.out.println(moveList.toString());
		System.out.println(RobotConfigs.getGONORTH());
		pilot.setTravelSpeed(F_SPEED);

		while (true) {
			// Junction detected

			if (i == moveList.size())
				break;

			System.out.println("Junction, running move" + i);

			Moves move = moveList.get(i);

			System.out.println("Junction, running move: " + move);

			// Button.waitForAnyPress();

			move.move();

			// Button.waitForAnyPress();

			i++;

		}
		pilot.arc(0, 360);
		System.out.println("Finished");
		Button.waitForAnyPress();
	}

}
