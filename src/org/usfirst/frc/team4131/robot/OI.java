package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.ChargeShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	public OI(){
		Joystick joystick = new Joystick(0);
		JoystickButton button1 = new JoystickButton(joystick , 1);
		button1.whenPressed(new ChargeShooter()); 
	}
}

