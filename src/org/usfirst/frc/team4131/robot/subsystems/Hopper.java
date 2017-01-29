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
 * @since 1/20/2017
 */
public class Hopper extends Subsystem {
	private CANTalon hopperMotor;
	private CANTalon feederMotor;
	public Hopper(){
		hopperMotor = new CANTalon(RobotMap.HOPPER_MOTOR);
		feederMotor = new CANTalon(RobotMap.FEEDER_MOTOR);
	}
	protected void initDefaultCommand() {
	
	}
	public void runHopper() {
		hopperMotor.set(1);
		feederMotor.set(1);
	}
	public void stopHopper() {
		hopperMotor.set(0);
		feederMotor.set(0);
	}
	
}