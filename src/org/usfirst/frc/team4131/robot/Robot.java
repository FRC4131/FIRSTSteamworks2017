package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.*;
import org.usfirst.frc.team4131.robot.subsystems.*;
import org.usfirst.frc.team4131.robot.utility.VisionThread;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
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
	public static final Spark lights = new Spark(9);
	//Autonomous
	private Command autonomousCommand = new CommandGroup(){{
		addSequential(new DriveStraight(-48, 0, 0.5));
		addSequential(new TurnTo(60));
		addSequential(new SetPocket(true));
		addSequential(new VisionSeek(-40, 0.5));
		addSequential(new SetClaw(true));
		addSequential(new DriveFor(0.25, 0.5));
		addSequential(new SetClaw(false));
		addSequential(new SetPocket(false));
	}};
	@Override
	public void robotInit(){
		drive.resetAngle();
		drive.resetDistance();
		compressor.setClosedLoopControl(true);
		
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(800, 600);
		camera.setFPS(10);
		camera.setBrightness(20);
		camera.getProperty("contrast").set(100);
		camera.getProperty("saturation").set(100);
		camera.setWhiteBalanceManual(6500);
		camera.getProperty("gain").set(100);
		camera.getProperty("sharpness").set(0);
		camera.setExposureManual(3);
		camera.getProperty("focus_auto").set(0);
		camera.getProperty("focus_absolute").set(0);
		
		VisionThread.instance();
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
	public void testInit(){}
	@Override
	public void testPeriodic(){
		Scheduler.getInstance().run();
	}
	@Override
	public void disabledInit(){}
	@Override
	public void disabledPeriodic(){}
	public void robotPeriodic(){
		lights.set(1);
		SmartDashboard.putNumber("Angle", drive.getAngle());
		SmartDashboard.putBoolean("AngleReady", drive.isAngleReady());
		SmartDashboard.putNumber("Distance", drive.getDistance());
		SmartDashboard.putBoolean("Pressurized", !compressor.getPressureSwitchValue());
	}
}
