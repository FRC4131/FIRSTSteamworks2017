package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot{
	//Subsystems
	public static final DriveBase drive = new DriveBase();
	public static final Collector collector = new Collector();
	public static final Hopper hopper = new Hopper();
	public static final Climber climber = new Climber();
	public static final Shooter shooter = new Shooter();
	//OI
	public static final OI OI = new OI();
	public static final Compressor compressor = new Compressor(RobotMap.PCM_ID);
	
	public Robot(){}
	@Override
	public void robotInit(){
		drive.resetGyro();
		drive.resetDistance();
		compressor.setClosedLoopControl(true);
	}
	@Override
	public void autonomousInit(){
		drive.resetDistance();
	}
	@Override
	public void autonomousPeriodic(){
		Scheduler.getInstance().run();
		dashboard();
	}
	@Override
	public void teleopInit(){
		
	}
	@Override
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
		dashboard();
	}
	@Override
	public void testInit(){
		
	}
	@Override
	public void testPeriodic(){
		Scheduler.getInstance().run();
		dashboard();
	}
	@Override
	public void disabledInit(){
		
	}
	@Override
	public void disabledPeriodic(){
		dashboard();
	}
	private void dashboard(){
		SmartDashboard.putNumber("Angle", drive.getAngle());
		SmartDashboard.putNumber("Encoder", drive.getDistance());
	}
}
