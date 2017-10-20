package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI{
	private Joystick leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
	private Joystick rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
	private Joystick auxilliary = new Joystick(RobotMap.AUXILLIARY_CONTROLLER);
	
	//private JoystickButton 
	private JoystickButton deployPocket = new JoystickButton(auxilliary, 2);
	private JoystickButton expelGear = new JoystickButton(auxilliary, 1);
	private JoystickButton climb = new JoystickButton(auxilliary, 3);
	private JoystickButton slowClimb = new JoystickButton(auxilliary, 5);
	public OI(){
		deployPocket.whileHeld(new SetPocket(true));
		deployPocket.whenReleased(new SetPocket(false));
		expelGear.whileHeld(new SetClaw(true));
		expelGear.whenReleased(new SetClaw(false));
		climb.whileHeld(new Climb());
		slowClimb.whileHeld(new EngageClimber());
	}
	public double getLeftSpeed(){
		return constrain(leftStick.getRawAxis(1));
	}
	public double getRightSpeed(){
		return constrain(rightStick.getRawAxis(1));
	}
	private double constrain(double value){
		return Math.max(-1, Math.min(1, value));
	}
}
