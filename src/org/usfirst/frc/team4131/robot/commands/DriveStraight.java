package org.usfirst.frc.team4131.robot.commands;


import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command{
	private PIDController controller = new PIDController(0.2, 0, 20, Robot.drive.getAngleSource(), this::drive);
	private double distance, speed;
	public DriveStraight(double distance, double heading, double speed){
		requires(Robot.drive);
		speed = Math.abs(speed);
		controller.setAbsoluteTolerance(0);//Because this isn't the end condition, it can run continuously.
		controller.setInputRange(0, 360);
		controller.setContinuous();
		controller.setOutputRange(-speed/2, speed/2);
		controller.setSetpoint(heading);
		this.distance = distance;
		this.speed = Math.copySign(speed, distance);
	}
	@Override
	protected void initialize(){
		Robot.drive.resetDistance();
		controller.reset();
		controller.enable();
	}
	@Override
	protected boolean isFinished(){
		if(distance < 0) return Robot.drive.getDistance() < distance;
		else return Robot.drive.getDistance() > distance;
	}
	@Override
	protected void end(){
		controller.disable();
		Robot.drive.move(0, 0);
	}
	@Override
	protected void interrupted(){
		controller.disable();
		Robot.drive.move(0, 0);
	}
	private void drive(double steer){
		Robot.drive.move(speed - steer, speed + steer);
	}
}
