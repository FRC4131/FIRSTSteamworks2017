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
	private Joystick leftStick;
	private Joystick rightStick;
	private JoystickButton collect;
	private JoystickButton spitOut;
	private JoystickButton chargeShooter;
	private JoystickButton shoot;
	private JoystickButton climb;
	private JoystickButton killShooter;
	public OI() {
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		collect = new JoystickButton(leftStick, 4);
		spitOut = new JoystickButton(rightStick , 3);
		chargeShooter = new JoystickButton(leftStick , 1);
		shoot = new JoystickButton(rightStick , 1);
		climb = new JoystickButton(leftStick , 8);
		killShooter = new JoystickButton(rightStick , 2);
		
		ChargeShooter chargeShooterCommand = new ChargeShooter();
		
		collect.whileHeld(new Collect());
		spitOut.whileHeld(new SpitOut());
		chargeShooter.whenPressed(chargeShooterCommand);
		shoot.whileHeld(new Shoot());
		climb.whileHeld(new Climb());
		killShooter.cancelWhenPressed(chargeShooterCommand);
	}
	public double getLeftSpeed() {
		return leftStick.getRawAxis(1);
	}
	public double getRightSpeed() {
		return rightStick.getRawAxis(1);
	}
}

