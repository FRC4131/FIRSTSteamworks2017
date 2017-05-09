package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CollectGear extends Command{
	public CollectGear(){
		requires(Robot.gearRamp);
	}
	protected void execute(){
		Robot.gearRamp.extend();
	}
	protected boolean isFinished(){return false;}
	protected void end(){
		Robot.gearRamp.retract();
	}
	protected void interrupted(){
		Robot.gearRamp.retract();
	}
}
