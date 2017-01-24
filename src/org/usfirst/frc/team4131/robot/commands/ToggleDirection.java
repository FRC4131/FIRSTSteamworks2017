package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDirection extends Command {
	private static boolean forward = true;

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		forward = !forward;
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

	public static boolean isForward() {
		return forward;
	}
}