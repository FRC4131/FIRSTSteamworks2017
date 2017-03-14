package org.usfirst.frc.team4131.robot.commands;


import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTo extends Command{
	private double distance, speed;
	public DriveTo(double distance, double speed){
		requires(Robot.drive);
		speed = Math.abs(speed);
		this.distance = distance;
		this.speed = Math.copySign(speed, distance);
	}
	protected void initialize(){
		Robot.drive.resetDistance();
	}
	protected void execute(){
		Robot.drive.shiftDown();
		Robot.drive.move(speed, speed);
	}
	protected boolean isFinished(){
		if(distance < 0) return Robot.drive.getDistance() < distance;
		else return Robot.drive.getDistance() > distance;
	}
	protected void end(){
		Robot.drive.move(0, 0);
	}
	protected void interrupted(){
		Robot.drive.move(0, 0);
	}
}
