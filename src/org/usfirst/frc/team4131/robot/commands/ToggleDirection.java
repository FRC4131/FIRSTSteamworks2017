package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDirection extends Command {
	private static boolean forward = true;
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		forward = !forward;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
	
	public static boolean isForward() {
		return forward;
	}
}
