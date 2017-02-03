package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command{
	public Shoot(){
		requires(Robot.hopper);
	}
	
	@Override
	protected void initialize(){}
	
	@Override
	protected void execute(){
		Robot.hopper.run();
	}
	
	@Override
	protected boolean isFinished(){
		return false;
	}
	
	@Override
	protected void end(){
		Robot.hopper.stop();
	}
	
	@Override
	protected void interrupted(){
		Robot.hopper.stop();
	}
}
