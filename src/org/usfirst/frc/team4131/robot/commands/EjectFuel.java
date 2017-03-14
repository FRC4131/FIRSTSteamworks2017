package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EjectFuel extends Command{
	public EjectFuel(){
		requires(Robot.hopper);
	}
	@Override
	protected void execute(){
		Robot.hopper.ejectFuel();
	}
	@Override
	protected boolean isFinished(){
		return false;
	}
	@Override
	protected void end(){
		Robot.hopper.settleFuel();
		Robot.hopper.stopFeeder();
	}
	@Override
	protected void initialize(){
		Robot.hopper.settleFuel();
		Robot.hopper.stopFeeder();
	}
}
