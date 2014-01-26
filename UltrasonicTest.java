import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class UltrasonicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UltrasonicSensor uSensor = new UltrasonicSensor(SensorPort.S2);

		uSensor.continuous();

		while (true) {
			
			
			
			//System.out.println(uSensor.getDistance());
			//Delay.msDelay(1000);
		}
	}

}
