package org.usfirst.frc.team4131.robot.commands;


import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveFor extends Command{
	private double time, speed;
	private Timer timer = new Timer();
	public DriveFor(double time, double speed){
		requires(Robot.drive);
		this.time = time;
		this.speed = speed;
	}
	protected void initialize(){
		timer.reset();
		timer.start();
	}
	protected void execute(){
		Robot.drive.shiftUp();
		Robot.drive.move(speed, speed);
	}
	protected boolean isFinished(){
		return timer.hasPeriodPassed(time);
	}
	protected void end(){
		Robot.drive.move(0, 0);
		timer.stop();
	}
	protected void interrupted(){
		Robot.drive.move(0, 0);
		timer.stop();
	}
}
