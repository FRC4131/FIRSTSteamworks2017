package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

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