package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
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
	private DoubleSolenoid leftShifter, rightShifter;
	private Encoder leftEncoder, rightEncoder;
	public DriveBase(){
		leftMotor = new CANTalon(RobotMap.DRIVE_LEFT);
		rightMotor = new CANTalon(RobotMap.DRIVE_RIGHT);
		leftShifter = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.LEFT_SHIFTER1, RobotMap.LEFT_SHIFTER2);
		rightShifter = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.RIGHT_SHIFTER1, RobotMap.RIGHT_SHIFTER2);
		
		leftEncoder = new Encoder(RobotMap.ENCODER_LEFT1, RobotMap.ENCODER_LEFT2);
		rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT1, RobotMap.ENCODER_RIGHT2);
		leftEncoder.setDistancePerPulse(RobotMap.DRIVE_INCHES_PER_PULSE);
		rightEncoder.setDistancePerPulse(RobotMap.DRIVE_INCHES_PER_PULSE);
	}
	protected void initDefaultCommand(){
		
	}
	public void move(double speed1, double speed2) {
		leftMotor.set(speed1);
		rightMotor.set(speed2);
	}
	public void shiftUp(){
		leftShifter.set(DoubleSolenoid.Value.kForward);
		rightShifter.set(DoubleSolenoid.Value.kForward);
	}
	public void shiftDown(){
		leftShifter.set(DoubleSolenoid.Value.kReverse);
		rightShifter.set(DoubleSolenoid.Value.kReverse);
	}
	public void resetDistance(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	public double getDistance(){
		return leftEncoder.getDistance();
	}
	public PIDSource getDistanceSource(){
		return leftEncoder;
	}
}
