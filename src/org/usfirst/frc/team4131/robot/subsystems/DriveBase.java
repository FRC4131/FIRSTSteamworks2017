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
	private CANTalon leftMotor1, leftMotor2, leftMotor3, rightMotor1, rightMotor2, rightMotor3;
	public DriveBase(){
		leftMotor1 = new CANTalon(RobotMap.DRIVE_LEFT1);
		leftMotor2 = new CANTalon(RobotMap.DRIVE_LEFT2);
		leftMotor3 = new CANTalon(RobotMap.DRIVE_LEFT3);
		rightMotor1 = new CANTalon(RobotMap.DRIVE_RIGHT1);
		rightMotor2 = new CANTalon(RobotMap.DRIVE_RIGHT2);
		rightMotor3 = new CANTalon(RobotMap.DRIVE_RIGHT3);
	}
	protected void initDefaultCommand(){
		
	}
	public void move(double speed1, double speed2) {
		leftMotor1.set(-speed1);
		leftMotor2.set(-speed1);
		leftMotor3.set(-speed1);
		rightMotor1.set(-speed2);
		rightMotor2.set(-speed2);
		rightMotor3.set(-speed2);
	}
}
