package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Input devices
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	
	//Motors
	public static final int DRIVE_LEFT = 0;
	public static final int DRIVE_RIGHT = 1;
	public static final int FLYWHEEL_MOTOR = 7;
	public static final int FEEDER_MOTOR = 8;
	public static final int HOPPER_MOTOR = 9;
	public static final int COLLECTOR_MOTOR = 10;
	public static final int CLIMBER_MOTOR = 12;
	
}
