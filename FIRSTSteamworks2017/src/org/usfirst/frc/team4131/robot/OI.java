package org.usfirst.frc.team4131.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team4131.robot.commands.ToggleDirection;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	private Joystick leftStick;
	private Joystick rightStick;
	
	public double getLeftSpeed() {
		return Math.pow(leftStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}

	public double getRightSpeed() {
		return Math.pow(rightStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}

}
