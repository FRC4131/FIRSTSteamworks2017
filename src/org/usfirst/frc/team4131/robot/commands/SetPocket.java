package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SetPocket extends Command{
	private boolean extend;
	public SetPocket(boolean extend){
		requires(Robot.gearPocket);
		this.extend = extend;
	}
	protected void execute(){
		if(extend) Robot.gearPocket.extend();
		else Robot.gearPocket.retract();
	}
	protected boolean isFinished(){
		return true;
	}
}
