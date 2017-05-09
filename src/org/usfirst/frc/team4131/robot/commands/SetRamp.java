package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetRamp extends Command{
	private boolean extend;
	public SetRamp(boolean extend){
		requires(Robot.gearRamp);
		this.extend = extend;
	}
	protected void execute(){
		if(extend) Robot.gearRamp.extend();
		else Robot.gearRamp.retract();
	}
	protected boolean isFinished(){return true;}
	protected void end(){
		Robot.gearRamp.retract();
	}
	protected void interrupted(){
		Robot.gearRamp.retract();
	}
}
