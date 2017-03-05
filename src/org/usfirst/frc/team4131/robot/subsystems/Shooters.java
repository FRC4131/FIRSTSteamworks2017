package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will call {@link #run()} in teleopPeriodic, and expect both flywheels to turn at maximum speed in opposite directions.
 * ====================================
 * @author Matthew, Ian
 * @since 1/28/2017
 */
public class Shooters extends Subsystem{
	private static final double LEFT_SPEED = 0.535, RIGHT_SPEED = 0.7,
			LEFT_ADJUSTMENT = 1 - LEFT_SPEED, RIGHT_ADJUSTMENT = 1 - RIGHT_SPEED;
	private CANTalon leftFlywheel = new CANTalon(RobotMap.LEFT_FLYWHEEL_MOTOR),
			rightFlywheel = new CANTalon(RobotMap.RIGHT_FLYWHEEL_MOTOR);
	public Shooters(){
		leftFlywheel.setInverted(RobotMap.LEFT_SHOOTER_INVERTED);
		leftFlywheel.reverseOutput(RobotMap.LEFT_SHOOTER_INVERTED);
		leftFlywheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftFlywheel.changeControlMode(TalonControlMode.PercentVbus);
		leftFlywheel.setEncPosition(0);
		
		rightFlywheel.setInverted(RobotMap.RIGHT_SHOOTER_INVERTED);
		rightFlywheel.reverseOutput(RobotMap.RIGHT_SHOOTER_INVERTED);
		rightFlywheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightFlywheel.changeControlMode(TalonControlMode.PercentVbus);
		rightFlywheel.setEncPosition(0);
	}
	protected void initDefaultCommand(){}
	public void run(){
		leftFlywheel.set(LEFT_SPEED + LEFT_ADJUSTMENT * Robot.OI.getShooterAdjustment());
		rightFlywheel.set(RIGHT_SPEED + RIGHT_ADJUSTMENT * Robot.OI.getShooterAdjustment());
//		leftFlywheel.set(1);
//		rightFlywheel.set(1);
	}
	public void stop(){
		leftFlywheel.set(0);
		rightFlywheel.set(0);
	}
}
