package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.subsystems.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot{
	//Subsystems
	public static final DriveBase drive = new DriveBase();
	public static final GearPocket gearPocket = new GearPocket();
	public static final GearClaw gearClaw = new GearClaw();
	public static final Climber climber = new Climber();
	//OI
	public static final OI OI = new OI();
	//Electronic components
	public static final Compressor compressor = new Compressor(RobotMap.PCM_ID);
	public static final Spark lights = new Spark(9);
	
	@Override
	public void robotInit(){
		compressor.clearAllPCMStickyFaults();
		compressor.setClosedLoopControl(true);
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
		gearClaw.close();
		gearPocket.retract();
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
		lights.set(1);
	}
	@Override
	public void disabledInit(){
	}
	@Override
	public void disabledPeriodic(){
	}
	public void robotPeriodic(){
		lights.set(1);
		SmartDashboard.putBoolean("Pressurized", !compressor.getPressureSwitchValue());
		SmartDashboard.putBoolean("PressureCharging", compressor.enabled());
		SmartDashboard.putBoolean("PressureControlled", compressor.getClosedLoopControl());
		SmartDashboard.putNumber("PressureCurrent", compressor.getCompressorCurrent());
	}
}
