package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	// Ports for motor controllers, encoders, etc
	/**
	 * Configuration for the RoboRio(s)
	 */
	public static final String ELECTRICAL_BOT = "ElectricalBot"; //0
	public static final int ELECT_BOT_NUM = 0;

	public static final String PRACTICE_BOT = "PracticeBot";//1
	public static final int PRAC_BOT_NUM = 1;

	public static final String COMP_BOT = "CompetitionBot"; //2
	public static final int COMP_BOT_NUM = 2;

	public static final String CONFIG_FILENAME = "WHOAMI.TXT";

	public static int robotType(String robot) {
		if (robot.equals(ELECTRICAL_BOT)) {
			return 0;
		} else if (robot.equals(PRACTICE_BOT)) {
			return 1;
		} else if (robot.equals(COMP_BOT)) {
			return 2;
		} else {
			return -1;
		}
	}
	
	public static int ROBOT_TYPE = -1;
	
	public static final int LEFT_JOYSTICK = 0;

	public static final int RIGHT_JOYSTICK = 1;

	public static final int DRIVE_LEFT_MOTOR1 = 0;

	public static final int DRIVE_LEFT_MOTOR2 = 1;

	public static final int DRIVE_RIGHT_MOTOR1 = 2;

	public static final int DRIVE_RIGHT_MOTOR2 = 3;

	public static final int DRIVE_LEFT_ENCODERA = 0;

	public static final int DRIVE_LEFT_ENCODERB = 1;

	public static final int DRIVE_RIGHT_ENCODERA = 2;

	public static final int DRIVE_RIGHT_ENCODERB = 3;
	
	public static final double DRIVE_RATIO = 1;// = ((125D + 3D / 16D) / 1033D);
}
