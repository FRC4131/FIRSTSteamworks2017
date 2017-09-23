package org.usfirst.frc.team4131.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	static Joystick LeftJoy = new Joystick(0);
	static Joystick RightJoy = new Joystick(1);
	static Joystick SecondaryJoy = new Joystick(2);
	static CANTalon LF = new CANTalon(3);
	static CANTalon LB = new CANTalon(2);
	static CANTalon RF = new CANTalon(6);
	static CANTalon RB = new CANTalon(5);
	static RobotDrive Drive = new RobotDrive(LF, LB, RF, RB);
	static Compressor Comp = new Compressor(62);
	
	static CANTalon C1 = new CANTalon(7);
	static CANTalon C2 = new CANTalon(8);
	
	static Solenoid Clamp1 = new Solenoid(62, 1);
	static Solenoid Clamp2 = new Solenoid(62, 0);
	
	static Solenoid Basket1 = new Solenoid(62, 2);
	static Solenoid Basket2 = new Solenoid(62, 3);
	
	double ClimbSpeed = 0.5; 
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Drive.tankDrive(LeftJoy, RightJoy);
		
				
		if(SecondaryJoy.getRawButton(6) == true)
		{
			if(ClimbSpeed < 1.0)
			{
				ClimbSpeed = ClimbSpeed + 0.01;
			}
			C1.set(ClimbSpeed);
			C2.set(ClimbSpeed);
		}
		else if(SecondaryJoy.getRawButton(4) == true)
		{
			ClimbSpeed = 0.5;
			C1.set(ClimbSpeed);
			C2.set(ClimbSpeed);
		}
		else
		{
			C1.set(0);
			C2.set(0);
		}
		
		if(SecondaryJoy.getRawButton(1) == true)
		{
			Basket1.set(true);
			Basket2.set(false);
			
			if(SecondaryJoy.getRawButton(2) == true)
			{
				Clamp1.set(true);
				Clamp2.set(false);
			}
			else
			{
				Clamp1.set(false);
				Clamp2.set(true);
			}
			
		}
		else
		{
			Basket1.set(false);
			Basket2.set(true);
		}
						
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		
		
	}
}

