package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command{
	private double distance;
	private double speed;
	private PIDController controller = new PIDController(0.05, 0, 0, Robot.drive.getAngleSource(), steer -> Robot.drive.move(speed - steer, speed + steer));
	public DriveStraight(double distance, double heading, double speed){
		requires(Robot.drive);
		speed = Math.abs(speed);
		controller.setInputRange(0, 360);
		controller.setContinuous();
		controller.setOutputRange(-speed/2, speed/2);
		controller.setSetpoint(heading);
		
		this.speed = Math.copySign(speed, distance);
		this.distance = distance;
	}
	protected void initialize(){
		Robot.drive.shiftDown();
		Robot.drive.resetDistance();
		controller.reset();
		controller.enable();
	}
	protected boolean isFinished(){
		return Math.abs(distance) < Math.abs(Robot.drive.getDistance());
	}
	protected void end(){
		controller.disable();
		Robot.drive.move(0, 0);
	}
	protected void interrupted(){
		controller.disable();
		Robot.drive.move(0, 0);
	}
}
