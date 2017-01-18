package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

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

	public void execute() {
		// TODO Auto-generated method stub
		Robot.drive.move(Robot.oi.leftStick.getRawAxis(1));// Robot.oi.getRightSpeed());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.drive.move(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.drive.move(0);
	}
}
