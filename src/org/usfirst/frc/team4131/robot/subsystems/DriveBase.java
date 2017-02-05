package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

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
