package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.subsystems.Hopper;
import org.usfirst.frc.team4131.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot{
	//Subsystems
	public static final Hopper hopper = new Hopper();
	public static final OI OI = new OI();
	public static final Shooter shooter = new Shooter();
	public Robot(){
		
	}
	@Override
	public void robotInit(){
		
	}
	@Override
	public void autonomousInit(){
		
	}
	@Override
	public void autonomousPeriodic(){
		Scheduler.getInstance().run();
	}
	@Override
	public void teleopInit(){
		
	}
	@Override
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
	}
	@Override
	public void testInit(){
		
	}
	@Override
	public void testPeriodic(){
		Scheduler.getInstance().run();
	}
	@Override
	public void disabledInit(){
		
	}
	@Override
	public void disabledPeriodic(){
		Scheduler.getInstance().run();
	}
}
