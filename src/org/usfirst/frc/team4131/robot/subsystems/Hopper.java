package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {
	private CANTalon hopper_motor;
	private CANTalon feeder_motor;
	public Hopper(){
		hopper_motor = new CANTalon(RobotMap.HOPPER_MOTOR);
		feeder_motor = new CANTalon(RobotMap.FEEDER_MOTOR);
	}
	protected void initDefaultCommand() {
	
	}
	public void run_hopper() {
		hopper_motor.set(1);
	}
	public void run_feeder() {
		feeder_motor.set(1);
	}
	public void stop_hopper() {
		hopper_motor.set(0);
	}
	public void stop_feeder() {
		feeder_motor.set(0);
	}
}