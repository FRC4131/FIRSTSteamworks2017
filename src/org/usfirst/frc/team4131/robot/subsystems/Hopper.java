package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will call {@link #agitateFuel()} and {@link #feedShooter()} in teleopPeriodic, and expect both motors to run when teleop is enabled.
 * Tests passed
 * ====================================
 * @author Matthew, Ian
 * @since 2/18/2017
 */
public class Hopper extends Subsystem{
	private CANTalon hopperMotor = new CANTalon(RobotMap.HOPPER_MOTOR);
	private CANTalon leftFeeder = new CANTalon(RobotMap.LEFT_FEEDER_MOTOR);
	private CANTalon rightFeeder = new CANTalon(RobotMap.RIGHT_FEEDER_MOTOR);
	public Hopper(){
		leftFeeder.setInverted(RobotMap.LEFT_FEEDER_INVERTED);
		leftFeeder.reverseOutput(RobotMap.LEFT_FEEDER_INVERTED);
		
		rightFeeder.setInverted(RobotMap.RIGHT_FEEDER_INVERTED);
		rightFeeder.reverseOutput(RobotMap.RIGHT_FEEDER_INVERTED);
	}
	protected void initDefaultCommand(){
		
	}
	public void agitateFuel(){
		hopperMotor.set(1);
	}
	public void settleFuel(){
		hopperMotor.set(0);
	}
	public void ejectFuel(){
		hopperMotor.set(-1);
		leftFeeder.set(-1);
		rightFeeder.set(-1);
	}
	public void feedShooter(){
		leftFeeder.set(1);
		rightFeeder.set(1);
	}
	public void stopFeeder(){
		leftFeeder.set(0);
		rightFeeder.set(0);
	}
}
