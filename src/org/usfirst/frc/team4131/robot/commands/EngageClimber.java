package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class EngageClimber extends Command {
	CANTalon motor;
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		motor = new CANTalon(RobotMap.CLIMBER_MOTOR);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		motor.set(0.5);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		motor.set(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		motor.set(0);
	}

}
