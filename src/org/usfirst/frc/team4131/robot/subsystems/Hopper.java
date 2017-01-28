package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {
	private CANTalon hopperMotor;
	private CANTalon feederMotor;
	public Hopper(){
		hopperMotor = new CANTalon(RobotMap.HOPPERMOTOR);
		feederMotor = new CANTalon(RobotMap.FEEDERMOTOR);
	}
	protected void initDefaultCommand() {
	
	}
	public void runHopper() {
		hopperMotor.set(1);
	}
	public void runFeeder() {
		feederMotor.set(1);
	}
	public void stopHopper() {
		hopperMotor.set(0);
	}
	public void stopFeeder() {
		feederMotor.set(0);
	}
}