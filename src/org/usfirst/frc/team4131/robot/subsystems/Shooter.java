package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

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
	private CANTalon feederMotor = new CANTalon(RobotMap.FEEDER_MOTOR);
	private CANTalon flywheelMotor = new CANTalon(RobotMap.FLYWHEEL_MOTOR);
	protected void initDefaultCommand() {
	}
	public Shooter(){
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
