package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect both motors to turn at maximum speed in the same direction.
 * Test passed
 * ====================================
 * @author Matthew
 * @since 1/28/2017
 */

public class Shooter extends Subsystem {
	private CANTalon feederMotor;
	private CANTalon flywheelMotor;
	protected void initDefaultCommand() {
	}
	public Shooter(){
		feederMotor = new CANTalon(RobotMap.FEEDER_MOTOR);
		flywheelMotor = new CANTalon(RobotMap.FLYWHEEL_MOTOR);
		flywheelMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		flywheelMotor.configEncoderCodesPerRev(7);
		flywheelMotor.changeControlMode(TalonControlMode.Speed);
		flywheelMotor.setPID(0.3,0,0);
		flywheelMotor.enableControl();
	}
	public void runFeeder() {
		feederMotor.set(1);
	}
	public void stopFeeder() {
		feederMotor.set(0);
	}
	public void runFlywheel() {
		flywheelMotor.set(1);
	}
	public void stopFlywheel() {
		flywheelMotor.set(0);
	}
}

