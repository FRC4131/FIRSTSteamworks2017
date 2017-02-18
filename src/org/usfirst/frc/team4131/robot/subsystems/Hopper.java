package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will call {@link #agitateFuel()} and {@link #feedShooter()} in teleopPeriodic, and expect both motors to run when teleop is enabled.
 * ====================================
 * @author Matthew, Ian
 * @since 2/18/2017
 */
public class Hopper extends Subsystem{
	private CANTalon hopperMotor = new CANTalon(RobotMap.HOPPER_MOTOR);
	private CANTalon feederMotor = new CANTalon(RobotMap.FEEDER_MOTOR);
	public Hopper(){}
	protected void initDefaultCommand(){
		
	}
	public void agitateFuel(){
		hopperMotor.set(1);
	}
	public void settleFuel(){
		hopperMotor.set(0);
	}
	public void feedShooter(){
		feederMotor.set(1);
	}
	public void stopFeeder(){
		feederMotor.set(0);
	}
}
