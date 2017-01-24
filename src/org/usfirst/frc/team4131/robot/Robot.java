
package org.usfirst.frc.team4131.robot;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.usfirst.frc.team4131.robot.autonomous.Autonomous;
import org.usfirst.frc.team4131.robot.autonomous.Configuration;
//import org.usfirst.frc.team4131.robot.commands.VisionFire;
//import org.usfirst.frc.team4131.robot.subsystems.Cameras;
//import org.usfirst.frc.team4131.robot.subsystems.Collector;
import org.usfirst.frc.team4131.robot.subsystems.Sensors;
//import org.usfirst.frc.team4131.robot.subsystems.Shooter;
import org.usfirst.frc.team4131.robot.subsystems.DriveBase;

//import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
=======
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4131.robot.commands.Auto;
import org.usfirst.frc.team4131.robot.commands.Move;
import org.usfirst.frc.team4131.robot.subsystems.DriveBase;

>>>>>>> origin/master

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
<<<<<<< HEAD
	public static double CURRENT_X;
	public static double CURRENT_Y;
	public static double CURRENT_ANGLE;

//	public static Cameras camera;
	public static Sensors sensors;
	public static DriveBase drive;
//	public static Shooter shooter;
//	public static Collector collector;
	public static OI oi;

	private Autonomous autonomous;
	private Configuration<Boolean> version;
	private Command autonomousCommand;

	public Robot() {
		super();
		String whoami = null;
		byte[] buffer = null;
		Path configPath = FileSystems.getDefault().getPath(RobotMap.CONFIG_FILENAME);
		try {
			buffer = Files.readAllBytes(configPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (buffer != null) {
			whoami = new String(buffer);
			RobotMap.ROBOT_TYPE = RobotMap.robotType(whoami);
		}
		autonomous = new Autonomous();
	}
=======

	public static final Auto auto = new Auto();
	

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
>>>>>>> origin/master

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
<<<<<<< HEAD
	public void robotInit() {
		if (RobotMap.ROBOT_TYPE == RobotMap.ELECT_BOT_NUM) {
			// electricalBot Code
		} else {
//			camera = new Cameras();
			sensors = new Sensors();
			drive = new DriveBase();
//			shooter = new Shooter();
//			collector = new Collector();
//			pdp = new PowerDistributionPanel(RobotMap.PDP);
			
			oi = new OI();

			version = new Configuration<Boolean>("AutonVersion").put("Low-bar", true).put("Procedural", false);
			version.init();
			autonomous = new Autonomous();
			autonomous.init();
			
			SmartDashboard.putNumber("TARGET RPM", 4500);
		}
=======
	@Override
	public void robotInit() {
		drive = new DriveBase();
		oi = new OI();
		chooser.addDefault("Default Auto", new Auto());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
>>>>>>> origin/master
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
<<<<<<< HEAD
	public void disabledInit() {
	}

=======
	@Override
	public void disabledInit() {

	}

	@Override
>>>>>>> origin/master
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		dashboard();
//		try{camera.execute();}catch(Exception e){}
	}

<<<<<<< HEAD
	public void autonomousInit() {
		drive.resetEncoders();
		CURRENT_ANGLE = sensors.getAngle();
		CURRENT_X = 0;// TODO whatever our starting position is based on
		CURRENT_Y = 0;// TODO whatever our starting position is based on
		sensors.resetGyro();
		if (version.value()){
//			autonomousCommand = ;
		}else{
			autonomousCommand = autonomous.assembleCommand();//procedural selection
		}
		SmartDashboard.putString("-Autonomous Command", String.valueOf(autonomousCommand));
=======
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
>>>>>>> origin/master
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
<<<<<<< HEAD
=======
	@Override
>>>>>>> origin/master
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		CURRENT_ANGLE = sensors.getAngle();
		dashboard();
//		camera.execute();
	}

<<<<<<< HEAD
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();// End autonomous when teleop starts
=======
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
>>>>>>> origin/master
	}

	/**
	 * This function is called periodically during operator control
	 */
<<<<<<< HEAD
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		dashboard();
//		try{camera.execute();}catch(Exception e){}
	}

	public void testInit() {

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		Scheduler.getInstance().run();
		dashboard();
//		try{camera.execute();}catch(Exception e){}
	}

	public static double constrain(double value, double min, double max) {
		double trueMin = Math.min(min, max), trueMax = Math.max(min, max);
		return Math.min(Math.max(value, trueMin), trueMax);
	}

	private void dashboard() {
		if (RobotMap.ROBOT_TYPE == RobotMap.ELECT_BOT_NUM) {
			// electricalBot Code
		} else {
//			SmartDashboard.putNumber("Snooter Speed", shooter.getRate());
//			SmartDashboard.putNumber("Shooter Command", shooter.getSpeed());
			
			SmartDashboard.putNumber("Drive Distance", drive.getDistance());
			SmartDashboard.putNumber("Gyro Angle", sensors.getAngle());
			SmartDashboard.putNumber("Robot X", CURRENT_X);
			SmartDashboard.putNumber("Robot Y", CURRENT_Y);
			SmartDashboard.putNumber("Right Tread Command", drive.getRightCommand());
			SmartDashboard.putNumber("Left Tread Command", drive.getLeftCommand());
			SmartDashboard.putNumber("Right Encoder", drive.getRightEncoder());
			SmartDashboard.putNumber("Left Encoder", drive.getLeftEncoder());
		}	
=======
	@Override
	public void teleopPeriodic() {
		Move now = new Move();
		Scheduler.getInstance().run();
		while(isEnabled())
		{
			now.execute();
			
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	//Subsystems
	public static DriveBase drive;
	public static OI oi;
	//OI
	public static final OI OI = new OI();
	
	public Robot(){
		
>>>>>>> origin/master
	}
}
