package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command{
	public Climb() {
		requires(Robot.climber);
	}
	protected void initialize(){
		
	}
	protected void execute(){
		Robot.climber.climb();
	}
	@Override 
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void end(){
		Robot.climber.stop();
	}
	protected void interrupted(){
		Robot.climber.stop();
	}
}