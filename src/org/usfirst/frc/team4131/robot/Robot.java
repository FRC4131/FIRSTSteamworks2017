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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveBase drive;
	public static OI oi;

	public Robot() {
		super();
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		drive = new DriveBase();
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
	}

	public void disabledPeriodic() {
	}

	public void autonomousInit() {
		drive.resetEncoders();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
	}

	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
	}

	public void testInit() {

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	}

	}
}
