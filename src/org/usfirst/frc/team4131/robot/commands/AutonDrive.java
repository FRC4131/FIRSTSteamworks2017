package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class AutonDrive extends Command {

	private PIDController angleController = new PIDController(0.1, 0, 0, Robot.drive.getAngleSource(), speed ->{
		Robot.drive.move(-0.5 - speed, -0.5 + speed);
	});
	
	public AutonDrive(double direction, double distance) {
		angleController.setInputRange(0, 360);
		angleController.setContinuous();
		angleController.setOutputRange(-1, 1);
		angleController.setSetpoint(direction);
		angleController.setAbsoluteTolerance(5);
		requires(Robot.drive);
		this.distance = distance;
	}
	
	private double distance;
	
	protected void initialize() {
		angleController.enable();
		Robot.drive.resetDistance();
	}
	protected boolean isFinished() {
		return Robot.drive.getDistance()>= distance;
	}
	protected void interrupted() {
		angleController.disable();
		Robot.drive.move(0, 0);
	}
	protected void end() {
		angleController.disable();
		Robot.drive.move(0, 0);
	}

}
