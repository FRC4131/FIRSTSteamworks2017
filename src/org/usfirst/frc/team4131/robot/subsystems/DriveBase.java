package org.usfirst.frc.team4131.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.Move;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.CANTalon;

public class DriveBase extends Subsystem {
	private Talon leftMotor1, leftMotor2, rightMotor1, rightMotor2;
	private Encoder leftEncoder, rightEncoder;
	
	// Connects the motors
	public DriveBase(){
		super();
		leftMotor1 = new Talon(RobotMap.DRIVE_LEFT_MOTOR1);
		leftMotor2 = new Talon(RobotMap.DRIVE_LEFT_MOTOR2);
		rightMotor1 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR1);
		rightMotor2 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR2);
		leftEncoder = new Encoder(RobotMap.DRIVE_LEFT_ENCODERA, RobotMap.DRIVE_LEFT_ENCODERB, false);
		rightEncoder = new Encoder(RobotMap.DRIVE_RIGHT_ENCODERA, RobotMap.DRIVE_RIGHT_ENCODERB,false);
		leftEncoder.setDistancePerPulse(RobotMap.DRIVE_RATIO);
		rightEncoder.setDistancePerPulse(RobotMap.DRIVE_RATIO);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Move());
	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	/**
	 * Sets motor controllers to set speed
	 * 
	 * @param speed1
	 * @param speed2
	 */
	public void move(double speed1, double speed2) {
		leftMotor1.set(speed1);
		leftMotor2.set(speed1);
		rightMotor1.set(-speed2);
		rightMotor2.set(-speed2);
	}

	public double getRightCommand(){
		return (rightMotor1.get() + rightMotor2.get()) / 2;
	}
	public double getLeftCommand(){
		return (leftMotor1.get() + leftMotor2.get()) / 2;
	}
	/**
	 * Returns the average distance calculated from both encoders.
	 * 
	 * @return (double) Average of two encoders
	 */
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2.0;
	}
	public int getLeftEncoder(){
		return leftEncoder.get();
	}
	public int getRightEncoder(){
		return rightEncoder.get();
	}
}
