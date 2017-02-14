package org.usfirst.frc.team4131.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4131.robot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick launchpad;
	
	private Button spitOut;
	private Button engageClimb;
	
	public OI() {
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		
		launchpad = new Joystick(RobotMap.LAUNCHPAD);
		
		spitOut = new JoystickButton(launchpad, RobotMap.UNLOAD);
		spitOut.whileHeld(new SpitOut());
		
		engageClimb = new JoystickButton(launchpad, RobotMap.ENGAGE_CLIMB);
		engageClimb.whileHeld(new EngageClimber());
	}
	
	public boolean getSpitOut() {
		return spitOut.get();
	}
	
	public boolean getEngageClimb() {
		return engageClimb.get();
	}
	
}

