package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Command;

public class EngageClimber extends Command {
	public EngageClimber() {
		requires(Robot.climber);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.climber.engage();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.climber.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.climber.stop();
	}

}
