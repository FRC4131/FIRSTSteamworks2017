package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
	private CANTalon motor;
	public Climber(){
		motor = new CANTalon(RobotMap.CLIMBER_MOTOR);
	}
	@Override
	protected void initDefaultCommand(){}
	public void engageRope(){
		motor.set(0.5);
	}
	public void climb(){
		motor.set(1);
	}
	public void stop(){
		motor.set(0);
	}
}
