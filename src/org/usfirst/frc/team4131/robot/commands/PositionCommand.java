package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PositionCommand extends Command {
	private double distanceInit;
	public double distanceTraveled = 0;
	public boolean initialized = false;

	public PositionCommand() {
		distanceInit = Robot.drive.getDistance();
	}

	protected void initialize() {
		initialized = true;
		Robot.drive.resetEncoders();
		distanceInit = Robot.drive.getDistance();
	}

	protected void execute() {
		updatePosition();
	}

	protected void end() {
		updatePosition();
	}

	protected void interrupted() {
		updatePosition();
	}

	protected boolean isFinished() {
		return false;
	}

	private void updatePosition() {
		distanceTraveled = distanceInit - Robot.drive.getDistance();
		double angleOfMovement = Robot.CURRENT_ANGLE;
		double xMoved = -Math.sin(Math.toRadians(angleOfMovement)) * distanceTraveled;
		double yMoved = -Math.cos(Math.toRadians(angleOfMovement)) * distanceTraveled;
		Robot.CURRENT_X += xMoved;
		Robot.CURRENT_Y += yMoved;
		distanceInit = Robot.drive.getDistance();
	}
}