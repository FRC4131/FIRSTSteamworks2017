package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.DriveStraight;
import org.usfirst.frc.team4131.robot.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot{
	//Subsystems
	public static final DriveBase drive = new DriveBase();
	public static final GearRamp gearRamp = new GearRamp();
	public static final GearPocket gearPocket = new GearPocket();
	public static final GearClaw gearClaw = new GearClaw();
	public static final Climber climber = new Climber();
	//OI
	public static final OI OI = new OI();
	//Electronic components
	public static final Compressor compressor = new Compressor(RobotMap.PCM_ID);
	//Autonomous
	private Command autonomousCommand = new DriveStraight(48, 0, 0.7);
	@Override
	public void robotInit(){
		drive.resetAngle();
		drive.resetDistance();
		compressor.setClosedLoopControl(true);
		compressor.start();
	}
	@Override
	public void autonomousInit(){
		drive.resetAngle();
		drive.resetDistance();
		if(autonomousCommand != null) autonomousCommand.start();
	}
	@Override
	public void autonomousPeriodic(){
		Scheduler.getInstance().run();
	}
	@Override
	public void teleopInit(){
		if(autonomousCommand != null) autonomousCommand.cancel();
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
	}
	public void robotPeriodic(){
		SmartDashboard.putNumber("Angle", drive.getAngle());
		SmartDashboard.putBoolean("AngleReady", drive.isAngleReady());
		SmartDashboard.putNumber("Distance", drive.getDistance());
		SmartDashboard.putBoolean("Pressurized", !compressor.getPressureSwitchValue());
	}
}
