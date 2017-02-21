package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int PCM_ID = 20;
	//Input devices
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	//Motors
	public static final int[] left = {4, 5, 6};
	public static final int[] right = {1, 2, 3};
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
	public static final int ENCODER_LEFT1 = 0;
	public static final int ENCODER_LEFT2 = 1;
	public static final int ENCODER_RIGHT1 = 2;
	public static final int ENCODER_RIGHT2 = 3;
	
	//Constants
	public static final int DRIVE_INCHES_PER_PULSE = 1;
}
