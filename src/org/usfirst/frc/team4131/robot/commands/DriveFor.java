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
	@Override
	protected void initialize(){
		Robot.drive.resetDistance();
		timer.reset();
		timer.start();
	}
	@Override
	protected void execute(){
		Robot.drive.move(speed, speed);
	}
	@Override
	protected boolean isFinished(){
		return timer.hasPeriodPassed(time);
	}
	@Override
	protected void end(){
		Robot.drive.move(0, 0);
		timer.stop();
	}
	@Override
	protected void interrupted(){
		Robot.drive.move(0, 0);
		timer.stop();
	}
}
