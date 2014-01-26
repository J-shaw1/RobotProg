import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * The listener class for when the sensor is pressed in part2b
 */
public class Listener implements SensorPortListener {

	private DifferentialPilot pilot;

	/**
	 * Constructor to set up the pilot
	 * @param pilot The pilot to use for movement
	 */
	public Listener(DifferentialPilot pilot) {
		this.pilot = pilot;
	}

	/**
	 * What to do when the sensor is presssed
	 * @param aSource The sensor port that has been pressed
	 * @param aOldValue The previous value of the sensor
	 * @param aNewValue The new value of the sensor 
	 */
	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		if (aNewValue < 500) {
			pilot.travel(-100);
			pilot.arc(0, 180);
			pilot.forward();

		}
	}
}
