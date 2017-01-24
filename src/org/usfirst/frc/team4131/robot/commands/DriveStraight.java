
package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.subsystems.DriveBase;
import org.usfirst.frc.team4131.robot.utilities.ChrisPIDController;
import org.usfirst.frc.team4131.robot.utilities.Point;

/**
 *
 */
public class DriveStraight extends PositionCommand {

	private ChrisPIDController angleController;
	private double distance;
	private double heading;
	private double maxSpeed;
	private boolean headingSet = false;
	private boolean noHeading = false;
	private Point p = null;

	private static final double DEAD_ZONE = 12;

	/**
	 * Distance, heading, speed params
	 * 
	 * @param distance
	 * @param heading
	 * @param speed
	 */
	public DriveStraight(double distance, double heading, double speed) {
		super();
		requires(Robot.drive);

		this.maxSpeed = speed;
		this.distance = distance;
		this.heading = heading;

		headingSet = true;

		if (distance < 0)
			maxSpeed *= -1;
	}

	private void requires(DriveBase drive) {
		// TODO Auto-generated method stub
		
	}

	public DriveStraight(Point coord, double speed) {
		p = coord;
		this.maxSpeed = speed;

		requires(Robot.drive);

		maxSpeed = speed;

		if (distance < 0)
			maxSpeed *= -1;

	}

	public DriveStraight(double distance, double speed) {
		if ((distance < 0) != (speed < 0))
			speed *= -1;
		this.distance = distance;
		this.maxSpeed = speed;
		this.noHeading = true;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (noHeading) {
			this.headingSet = true;//to pass the next conditional
			super.initialize();
		} else {
			angleController = new ChrisPIDController(1, 0, 0, -(Math.abs(maxSpeed)) / 2, Math.abs(maxSpeed) / 2);
			double angleError = heading - Robot.sensors.getAngle();

			angleController.start(angleError);

			super.initialize();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!this.headingSet) {//this is only here because init is called before the command physically starts
			if (p != null) {
				double x = p.x - Robot.CURRENT_X;
				double y = p.y - Robot.CURRENT_Y;
				double movementEncured = Math.pow(x * x + y * y, 0.5);

				distance = movementEncured;

				this.heading = Robot.CURRENT_ANGLE;
				this.headingSet = true;

				super.initialize();
			}
		} else if (!initialized) {
			super.initialize();
		}
		if (noHeading) {
			Robot.drive.move(maxSpeed, maxSpeed);
		} else {
			double angleCommand = angleController.update(getError());

			Robot.drive.move(maxSpeed + angleCommand, maxSpeed - angleCommand);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(distance - Robot.drive.getDistance()) <= DEAD_ZONE;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.move(0, 0);
		super.end();
		Robot.drive.resetEncoders();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drive.move(0, 0);
		super.interrupted();
	}

	private double getError() {
		double error = (Robot.sensors.getAngle() - heading % 360);
		if (error < 0)
			error = error + 360;
		if (error > 180)
			error = error - 360;
		return (-error);
	}
}