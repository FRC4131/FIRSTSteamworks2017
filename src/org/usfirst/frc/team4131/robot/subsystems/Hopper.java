package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect motor to turn at maximum speed.
 * Test passed
 * ====================================
 * @author Matthew
 * @since 1/20/2017
 */
public class Hopper extends Subsystem {
	private CANTalon hopperMotor;
	public Hopper(){
		hopperMotor = new CANTalon(RobotMap.HOPPER_MOTOR);
	}
	protected void initDefaultCommand() {
	
	}
	public void run() {
		hopperMotor.set(1);
	}
	public void stop() {
		hopperMotor.set(0);
	}
	}