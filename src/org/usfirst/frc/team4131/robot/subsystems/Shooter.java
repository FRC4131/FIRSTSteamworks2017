package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	private CANTalon flywheel_motor;
	public Shooter(){
		flywheel_motor = new CANTalon(RobotMap.SHOOTER_MOTOR);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	public void run() {
		flywheel_motor.set(1);
	}
	public void stop() {
		flywheel_motor.set(0);
	}
}
