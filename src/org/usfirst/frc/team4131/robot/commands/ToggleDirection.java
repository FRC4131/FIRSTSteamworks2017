package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDirection extends Command {
	private static boolean forward = true;
<<<<<<< HEAD

	@Override
	protected void initialize() {
=======
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

>>>>>>> origin/master
	}

	@Override
	protected void execute() {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
>>>>>>> origin/master
		forward = !forward;
	}

	@Override
	protected boolean isFinished() {
<<<<<<< HEAD
		return true;
=======
		// TODO Auto-generated method stub
		return false;
>>>>>>> origin/master
	}

	@Override
	protected void end() {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub

>>>>>>> origin/master
	}

	@Override
	protected void interrupted() {
<<<<<<< HEAD
	}

	public static boolean isForward() {
		return forward;
	}
}
=======
		// TODO Auto-generated method stub

	}
	
	public static boolean isForward() {
		return forward;
	}
}
>>>>>>> origin/master
