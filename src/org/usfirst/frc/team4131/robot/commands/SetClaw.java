package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetClaw extends Command{
	private boolean open;
	public SetClaw(boolean open){
		requires(Robot.gearClaw);
		this.open = open;
	}
	protected void execute(){
		if(open) Robot.gearClaw.open();
		else Robot.gearClaw.close();
	}
	protected boolean isFinished(){return true;}
	protected void end(){
		Robot.gearClaw.close();
	}
	protected void interrupted(){
		Robot.gearClaw.close();
	}
}
