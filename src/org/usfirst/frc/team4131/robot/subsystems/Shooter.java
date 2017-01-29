package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	private CANTalon feederMotor;
	private CANTalon flywheelMotor;
	protected void initDefaultCommand() {
	}
	public Shooter(){
		feederMotor = new CANTalon(RobotMap.FEEDER_MOTOR);
		flywheelMotor = new CANTalon(RobotMap.FLYWHEEL_MOTOR);
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
