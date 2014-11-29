package RobotMovement;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class RobotConfigs {
	private static Moves GONORTH = new GoFoward();
	private static Moves GOEAST = new TurnLeft();
	private static Moves GOSOUTH = new GoBackwards();
	private static Moves GOWEST = new TurnRight();
	private static final double wheelDiameter = 56.0;
	private static final double trackWidth = 128.0;
	private static final RegulatedMotor rightMotor = Motor.A;
	private static final RegulatedMotor leftMotor = Motor.B;
	private static final DifferentialPilot pilot = new DifferentialPilot(
			wheelDiameter, trackWidth, leftMotor, rightMotor, false);
	private static final LightSensor leftLightSensor = new LightSensor(
			SensorPort.S4);
	private static final int LS_LOW = 50;
	private static final int TURN_SPEED = 250;
	private static final OpticalDistanceSensor IRsensor= new OpticalDistanceSensor(SensorPort.S3);

	//Sensor movement
	private static final RegulatedMotor sensorMotor = Motor.C;
	
	public static RegulatedMotor getSensormotor() {
		return sensorMotor;
	}

	public static OpticalDistanceSensor getIrsensor() {
		return IRsensor;
	}

	public static Moves getGONORTH() {
		return GONORTH;
	}

	public static void setGONORTH(Moves gONORTH) {
		GONORTH = gONORTH;
	}

	public static Moves getGOEAST() {
		return GOEAST;
	}

	public static void setGOEAST(Moves gOEAST) {
		GOEAST = gOEAST;
	}

	public static Moves getGOSOUTH() {
		return GOSOUTH;
	}

	public static void setGOSOUTH(Moves gOSOUTH) {
		GOSOUTH = gOSOUTH;
	}

	public static Moves getGOWEST() {
		return GOWEST;
	}

	public static void setGOWEST(Moves gOWEST) {
		GOWEST = gOWEST;
	}

	public static int getTurnSpeed() {
		return TURN_SPEED;
	}

	public static int getLsLow() {
		return LS_LOW;
	}

	public static LightSensor getLeftlightsensor() {
		return leftLightSensor;
	}

	public static LightSensor getRightlightsensor() {
		return rightLightSensor;
	}

	public static void calibrate() {

		leftLightSensor.setFloodlight(true);
		rightLightSensor.setFloodlight(true);

		System.out.println("Set low");
		Button.waitForAnyPress();
		leftLightSensor.calibrateLow();
		rightLightSensor.calibrateLow();

		System.out.println("Set high");
		Button.waitForAnyPress();
		leftLightSensor.calibrateHigh();
		rightLightSensor.calibrateHigh();
	
		System.out.println("Press to run");
		Button.waitForAnyPress();
	}
	
	public static int[] getDistances(){
		int[] values = new int[4];
		
		int delay = 300;
		
		values[0] = IRsensor.getDistance();
		sensorMotor.rotate(-90);
		Delay.msDelay(delay);
		values[3] = IRsensor.getDistance();
		sensorMotor.rotate(180);
		Delay.msDelay(delay);
		values[1] = IRsensor.getDistance();
		sensorMotor.rotate(90);
		Delay.msDelay(delay);
		values[2] = IRsensor.getDistance();
		sensorMotor.rotate(-180);
		
		return values;
				
	}
	
	private static final LightSensor rightLightSensor = new LightSensor(
			SensorPort.S1);

	public static DifferentialPilot getPilot() {
		return pilot;
	}

	public static double getWheeldiameter() {
		return wheelDiameter;
	}

	public static double getTrackwidth() {
		return trackWidth;
	}

	public static RegulatedMotor getRightmotor() {
		return rightMotor;
	}

	public static RegulatedMotor getLeftmotor() {
		return leftMotor;
	}
}
