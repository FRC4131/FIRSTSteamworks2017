package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.VisionSeek;
import org.usfirst.frc.team4131.robot.subsystems.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot{
	//Subsystems
	public static final DriveBase drive = new DriveBase();
	public static final Collector collector = new Collector();
	public static final Hopper hopper = new Hopper();
	public static final Climber climber = new Climber();
	public static final Shooters shooters = new Shooters();
	//OI
	public static final OI OI = new OI();
	//Electronic components
	public static final Compressor compressor = new Compressor(RobotMap.PCM_ID);
	//Autonomous
	private Command autonomousCommand = new VisionSeek(-40, 0.5);
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
		dashboard();
	}
	@Override
	public void teleopInit(){
		if(autonomousCommand != null) autonomousCommand.cancel();
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
		SmartDashboard.putBoolean("AngleReady", drive.isAngleReady());
		SmartDashboard.putNumber("Distance", drive.getDistance());
		SmartDashboard.putNumber("ShooterAdjust", OI.getShooterAdjustment());
	}
}
