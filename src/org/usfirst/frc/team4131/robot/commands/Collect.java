package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Collect extends Command {

	@Override
	protected void initialize() {
		
	}
	protected void execute() {
	Robot.collector.collect();	
	}
	protected boolean isFinished() {
		
		return false;
	}

}
