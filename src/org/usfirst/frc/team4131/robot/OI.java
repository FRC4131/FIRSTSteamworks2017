package org.usfirst.frc.team4131.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	public Joystick leftStick;
	public Joystick rightStick;
	public JoystickButton leftOne;
	public JoystickButton leftTwo;
	public JoystickButton leftThree;
	public JoystickButton leftFour;
	public JoystickButton leftFive;
	public JoystickButton leftSix;
	public JoystickButton leftSeven;
	public JoystickButton leftEight;
	public JoystickButton leftNine;
	public JoystickButton leftTen;
	public JoystickButton leftEleven;
	public JoystickButton leftTwelve;
	public JoystickButton rightOne;
	public JoystickButton rightTwo;
	public JoystickButton rightThree;
	public JoystickButton rightFour;
	public JoystickButton rightFive;
	public JoystickButton rightSix;
	public JoystickButton rightSeven;
	public JoystickButton rightEight;
	public JoystickButton rightNine;
	public JoystickButton rightTen;
	public JoystickButton rightEleven;
	public JoystickButton rightTwelve;
	public OI() {
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		leftOne = new JoystickButton(leftStick , 1);
		leftTwo = new JoystickButton(leftStick , 2);
		leftThree = new JoystickButton(leftStick , 3);
		leftFour = new JoystickButton(leftStick , 4);
		leftFive = new JoystickButton(leftStick , 5);
		leftSix = new JoystickButton(leftStick , 6);
		leftSeven = new JoystickButton(leftStick , 7);
		leftEight = new JoystickButton(leftStick , 8);
		leftNine = new JoystickButton(leftStick , 9);
		leftTen = new JoystickButton(leftStick , 10);
		leftEleven = new JoystickButton(leftStick , 11);
		leftTwelve = new JoystickButton(leftStick , 12);
		rightOne = new JoystickButton(rightStick , 1);
		rightTwo = new JoystickButton(rightStick , 2);
		rightThree = new JoystickButton(rightStick , 3);
		rightFour = new JoystickButton(rightStick , 4);
		rightFive = new JoystickButton(rightStick , 5);
		rightSix = new JoystickButton(rightStick , 6);
		rightSeven = new JoystickButton(rightStick , 7);
		rightEight = new JoystickButton(rightStick , 8);
		rightNine = new JoystickButton(rightStick , 9);
		rightTen = new JoystickButton(rightStick , 10);
		rightEleven = new JoystickButton(rightStick , 11);
		rightTwelve = new JoystickButton(rightStick , 12);
	}
}

