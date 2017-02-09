package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect both motors to turn at maximum speed.
 * Test passed
 * ====================================
 * @author Calvin
 * @since 2/4/2017
 */
public class DriveBase extends Subsystem {
	private CANTalon leftMotor, rightMotor;
	public DriveBase(){
		leftMotor = new CANTalon(RobotMap.DRIVE_LEFT);
		rightMotor = new CANTalon(RobotMap.DRIVE_RIGHT);
	}
	protected void initDefaultCommand(){
		
	}
	public void move(double speed1, double speed2) {
		leftMotor.set(speed1);
		rightMotor.set(speed2);
	}
}
