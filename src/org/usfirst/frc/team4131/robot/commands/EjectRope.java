package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EjectRope extends Command{
	public EjectRope(){
		requires(Robot.climber);
	}
	@Override
	protected void execute(){
		Robot.climber.reverse();
	}
	@Override
	protected boolean isFinished(){
		return false;
	}
	@Override
	protected void end(){
		Robot.climber.stop();
	}
	@Override
	protected void initialize(){
		Robot.climber.stop();
	}
}
