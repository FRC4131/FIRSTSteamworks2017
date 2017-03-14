package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * I will change the Talon id's and test every button and both joysticks to make sure they move the intended motors correctly.
 * All test passed
 * ====================================
 * @author Matthew
 * @since 2/18/2017
 */

public class OI{
	private Joystick leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
	private Joystick rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
	private Joystick auxilliary = new Joystick(RobotMap.AUXILLIARY_CONTROLLER);
	
	private JoystickButton collect = new JoystickButton(auxilliary, 5);
	private JoystickButton spitOut = new JoystickButton(auxilliary, 3);
	private JoystickButton ejectFuel = new JoystickButton(auxilliary, 11);
	private JoystickButton chargeShooter = new JoystickButton(leftStick, 1);
	private JoystickButton shoot = new JoystickButton(rightStick, 1);
	private JoystickButton climb = new JoystickButton(auxilliary, 6);
	private JoystickButton slowClimb = new JoystickButton(auxilliary, 4);
	private JoystickButton ejectRope = new JoystickButton(auxilliary, 12);
	private JoystickButton killShooter = new JoystickButton(rightStick, 2);
	private JoystickButton shift = new JoystickButton(rightStick, 4);
	public OI(){
		ChargeShooter chargeShooterCommand = new ChargeShooter();
		
		collect.whileHeld(new Collect());
		spitOut.whileHeld(new SpitOut());
		ejectFuel.whileHeld(new EjectFuel());
		chargeShooter.whenPressed(chargeShooterCommand);
		shoot.whileHeld(new Shoot());
		climb.whileHeld(new Climb());
		slowClimb.whileHeld(new EngageClimber());
		ejectRope.whileHeld(new EjectRope());
		killShooter.cancelWhenPressed(chargeShooterCommand);
	}
	public double getLeftSpeed(){
		return constrain(leftStick.getRawAxis(1));
	}
	public double getRightSpeed(){
		return constrain(rightStick.getRawAxis(1));
	}
	public boolean shiftDown(){
		return shift.get();
	}
	public double getShooterAdjustment(){
		return (-constrain(leftStick.getRawAxis(3)) + 1)/2d;//0 is bottom, 1 is top
	}
	private double constrain(double value){
		return Math.max(-1, Math.min(1, value));
	}
}
