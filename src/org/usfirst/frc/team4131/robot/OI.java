package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.Climb;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	public OI(){
		new JoystickButton(new Joystick(0),1).whileHeld(new Climb());
	}
}

