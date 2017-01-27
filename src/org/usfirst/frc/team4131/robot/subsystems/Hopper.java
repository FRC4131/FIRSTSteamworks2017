package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect both motors to turn at maximum speed in the same direction.
 * Test passed
 * ====================================
 * @author Matthew
 * @since 1/20/2017
 */
public class Hopper extends Subsystem {
	private CANTalon hopper_motor;
	private CANTalon flywheel_motor;
	public Hopper(){
		hopper_motor = new CANTalon(RobotMap.HOPPER_MOTOR);
		flywheel_motor = new CANTalon(RobotMap.FLYWHEEL_MOTOR);
	}
	protected void initDefaultCommand() {
	
	}
	public void run() {
		hopper_motor.set(1);
		flywheel_motor.set(1);
	}
	public void stop() {
		hopper_motor.set(0);
		flywheel_motor.set(0);
	}
}