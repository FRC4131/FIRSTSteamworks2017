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
	private CANTalon leftMotor1, rightMotor1;
	
	public DriveBase(){
		leftMotor1 = new CANTalon(RobotMap.DRIVE_LEFT1);
		rightMotor1 = new CANTalon(RobotMap.DRIVE_RIGHT1);
		leftMotor1.setInverted(true);
	}
	protected void initDefaultCommand(){
		
	}
	
	public void move(double speed1, double speed2) {
		leftMotor1.set(speed1);
		rightMotor1.set(speed2);
	}
}
