import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.robotics.navigation.DifferentialPilot;

public class Listener implements SensorPortListener {

	private DifferentialPilot pilot;

	public Listener(DifferentialPilot pilot) {
		this.pilot = pilot;
	}

	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {
		if (aNewValue < 500) {
			pilot.travel(-100);
			pilot.arc(0, 180);
			pilot.forward();

		}
	}
}
