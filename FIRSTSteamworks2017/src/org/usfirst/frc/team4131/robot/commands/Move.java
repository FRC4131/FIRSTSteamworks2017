package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4131.robot.Robot;

public class Move extends Command {
	
	public Move() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.drive.move(Robot.oi.getLeftSpeed(), Robot.oi.getRightSpeed());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.drive.move(0, 0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.drive.move(0, 0);
	}

}
