package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int PCM_ID = 62;
	//Input devices
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	
	//Motors
	public static final int DRIVE_LEFT[] = {4, 5, 6};
	public static final int DRIVE_RIGHT[] = {1, 2, 3};
	public static final int FLYWHEEL_MOTOR = 7;
	public static final int FEEDER_MOTOR = 9;
	public static final int HOPPER_MOTOR = 10;
	public static final int COLLECTOR_MOTOR = 11;
	public static final int CLIMBER_MOTOR = 8;
	
	//Digital IO
	public static final int LEFT_SHIFTER1 = 0;
	public static final int LEFT_SHIFTER2 = 1;
	public static final int RIGHT_SHIFTER1 = 2;
	public static final int RIGHT_SHIFTER2 = 3;
	
	//Constants
	public static final int DRIVE_ENCODER_TICKS = 20;
	public static final double HIGH_GEAR_RATIO = 0.224, DRIVE_WHEEL_RADIUS = 2;
	public static final double DRIVE_WHEEL_CIRCUMFERENCE = 2 * Math.PI * DRIVE_WHEEL_RADIUS;
	public static final double DRIVE_CONVERSION_FACTOR = HIGH_GEAR_RATIO * DRIVE_WHEEL_CIRCUMFERENCE / 80;//The 80 is arbitrary but it works
	public static final double DRIVE_RAMP_RATE = 12 / 1.5;//Volts per second; full power (12V) divided by time from zero to full
	public static final boolean DRIVE_LEFT_INVERTED = true, DRIVE_RIGHT_INVERTED = false;
}
