package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightFor extends Command{
	private double time, speed;
	private Timer timer = new Timer();
	private PIDController controller = new PIDController(0.05, 0, 0, Robot.drive.getAngleSource(), steer -> Robot.drive.move(speed - steer, speed + steer));
	public DriveStraightFor(double time, double heading, double speed){
		requires(Robot.drive);
		controller.setInputRange(0, 360);
		controller.setContinuous();
		controller.setOutputRange(-Math.abs(speed)/2, Math.abs(speed)/2);
		controller.setSetpoint(heading);
		
		this.speed = speed;
		this.time = time;
	}
	protected void initialize(){
		Robot.drive.shiftDown();
		Robot.drive.resetDistance();
		controller.reset();
		controller.enable();
		timer.reset();
		timer.start();
	}
	protected boolean isFinished(){
		return timer.hasPeriodPassed(time);
	}
	protected void end(){
		controller.disable();
		Robot.drive.move(0, 0);
		timer.stop();
	}
	protected void interrupted(){
		controller.disable();
		Robot.drive.move(0, 0);
		timer.stop();
	}
}
