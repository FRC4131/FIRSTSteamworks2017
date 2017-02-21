package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.Move;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Run on Competition Bot
 * We will call {@link #move(double, double)} in teleopPeriodic and expect both motors to move. The same number to both should make them rotate in opposite directions.
 * We will report {@link #getAngle()} in teleopPeriodic and expect it to show the robot's angle of rotation about the axis perpendicular to the floor.
 * We will report {@link #getDistance()} in teleopPeriodic and expect it to return the distance traveled since startup.
 * We will call {@link #shiftUp()} and {@link #shiftDown()} and expect the robot to shift to high and low gear. 
 * Tests passed
 * ====================================
 * @author Calvin, Ian
 * @since 2/17/2017
 */
public class DriveBase extends Subsystem {
	private CANTalon leftMotor, rightMotor;
	private DoubleSolenoid leftShifter, rightShifter;
	private AHRS imu;
	public DriveBase(){
		//Create left motor
		leftMotor = new CANTalon(RobotMap.DRIVE_LEFT[0]);
		leftMotor.setInverted(RobotMap.DRIVE_LEFT_INVERTED);
		leftMotor.reverseOutput(RobotMap.DRIVE_LEFT_INVERTED);
		leftMotor.setVoltageRampRate(RobotMap.DRIVE_RAMP_RATE);
		leftMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftMotor.reverseSensor(RobotMap.DRIVE_LEFT_INVERTED);
		leftMotor.configEncoderCodesPerRev(RobotMap.DRIVE_ENCODER_TICKS);
		
		//Create right motor
		rightMotor = new CANTalon(RobotMap.DRIVE_RIGHT[0]);
		rightMotor.setInverted(RobotMap.DRIVE_RIGHT_INVERTED);
		rightMotor.reverseOutput(RobotMap.DRIVE_RIGHT_INVERTED);
		rightMotor.setVoltageRampRate(RobotMap.DRIVE_RAMP_RATE);
		rightMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightMotor.reverseSensor(RobotMap.DRIVE_RIGHT_INVERTED);
		rightMotor.configEncoderCodesPerRev(RobotMap.DRIVE_ENCODER_TICKS);
		
		
		//Create other motors (as followers)
		for(int i=1; i<3; ++i){
			CANTalon left = new CANTalon(RobotMap.DRIVE_LEFT[i]);
			left.changeControlMode(TalonControlMode.Follower);
			left.set(RobotMap.DRIVE_LEFT[0]);
			
			CANTalon right = new CANTalon(RobotMap.DRIVE_RIGHT[i]);
			right.changeControlMode(TalonControlMode.Follower);
			right.set(RobotMap.DRIVE_RIGHT[0]);
		}
		//Create shifters
		leftShifter = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.LEFT_SHIFTER1, RobotMap.LEFT_SHIFTER2);
		rightShifter = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.RIGHT_SHIFTER1, RobotMap.RIGHT_SHIFTER2);
		
		imu = new AHRS(SPI.Port.kMXP);
	}
	
	protected void initDefaultCommand(){
		setDefaultCommand(new Move());
	}
	public void move(double left, double right) {
		leftMotor.set(left);
		rightMotor.set(right);
	}
	public void shiftUp(){
		leftShifter.set(DoubleSolenoid.Value.kReverse);
		rightShifter.set(DoubleSolenoid.Value.kReverse);
	}
	public void shiftDown(){
		leftShifter.set(DoubleSolenoid.Value.kForward);
		rightShifter.set(DoubleSolenoid.Value.kForward);
	}
	public void resetDistance(){
		leftMotor.setEncPosition(0);
		rightMotor.setEncPosition(0);
	}
	public double getDistance(){
		return compute(leftMotor.getEncPosition(), rightMotor.getEncPosition());
	}
	public double getVelocity(){
		return compute(leftMotor.getEncVelocity(), rightMotor.getEncVelocity());
	}
	/**
	 * Utility method for computing an output value from two encoder input values.
	 * This method:
	 * - Inverts the inputs' signs in accordance with {@link org.usfirst.frc.team4131.robot.RobotMap#DRIVE_LEFT_INVERTED} and {@link org.usfirst.frc.team4131.robot.RobotMap#DRIVE_RIGHT_INVERTED}
	 * - Averages the two inputs to create the output
	 * - Multiplies by the robot's gear ratio and wheel circumference to convert the output to inches
	 * @param left The raw value from the left encoder
	 * @param right The raw value from the right encoder
	 * @return The computed output value
	 */
	private double compute(int left, int right){
		if(RobotMap.DRIVE_LEFT_INVERTED) left = -left;
		if(RobotMap.DRIVE_RIGHT_INVERTED) right = -right;
		return -(left + right) / 2 * RobotMap.DRIVE_CONVERSION_FACTOR;
	}
	public PIDSource getDistanceSource(){
		return new PIDSource(){
			private PIDSourceType type;
			public void setPIDSourceType(PIDSourceType pidSource){type = pidSource;}
			public PIDSourceType getPIDSourceType(){return type;}
			public double pidGet(){
				switch(type){
					case kDisplacement: return getDistance();
					case kRate: return getVelocity();
					default: return 0;
				}
			}
		};
	}
	public void resetGyro(){
		imu.reset();
	}
	public double getAngle(){
		return imu.getYaw();
	}
	public double getAngularVelocity(){
		return imu.getRate();
	}
	public PIDSource getAngleSource(){
		return new PIDSource(){
			private PIDSourceType type;
			public void setPIDSourceType(PIDSourceType pidSource){type = pidSource;}
			public PIDSourceType getPIDSourceType(){return type;}
			public double pidGet(){
				switch(type){
					case kDisplacement: return getAngle();
					case kRate: return getAngularVelocity();
					default: return 0;
				}
			}
		};
	}
}
