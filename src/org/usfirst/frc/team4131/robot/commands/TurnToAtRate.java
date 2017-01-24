package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.ChrisPIDController;
import org.usfirst.frc.team4131.utilities.Point;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToAtRate extends Command {
	private static double DEAD_ZONE = 1;
	private double heading;
	private boolean headingSet = false;
	private Point p = null;
	private ChrisPIDController controller;

	public TurnToAtRate(double heading, double rate) {
		requires(Robot.drive);
		DEAD_ZONE *= rate;
		this.heading = heading;
		controller = new ChrisPIDController(0.8, 0.2, 0.6, -rate, rate);
		headingSet = true;
	}

	public TurnToAtRate(Point coord, double rate) {
		requires(Robot.drive);
		DEAD_ZONE *= rate;
		p = coord;
		controller = new ChrisPIDController(0.8, 0.2, 0.6, -rate, rate);
	}

	@Override
	protected void initialize() {
		if (headingSet) {
			controller.start(getError());
		}
	}

	@Override
	protected void execute() {
		if ((p != null) && (!headingSet)) {
			double x, y, angle;
			x = p.x - Robot.CURRENT_X;
			y = p.y - Robot.CURRENT_Y;
			angle = Math.toDegrees(Math.atan2(x, y));
			if (angle < 0) {
				angle += 360;
			}
			this.heading = angle;
			headingSet = true;
			controller.start(getError());
		}
		double error = getError();
		if (Math.abs(error) < DEAD_ZONE) {
			return;
		}
		double speed = controller.update(error);
		Robot.drive.move(speed, -speed);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(getError()) < DEAD_ZONE;
	}

	@Override
	protected void end() {
		Robot.drive.move(0, 0);
	}

	@Override
	protected void interrupted() {
		Robot.drive.move(0, 0);
	}

	private double getError() {
		double error = (Robot.sensors.getAngle() - heading % 360);
		if (error < 0)
			error += 360;
		if (error > 180)
			error -= 360;
		return (-error);
	}
}