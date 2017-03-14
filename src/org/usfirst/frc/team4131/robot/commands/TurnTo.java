package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class TurnTo extends Command{
	private PIDController controller = new PIDController(0.05, 0, 0.5, Robot.drive.getAngleSource(), speed -> Robot.drive.move(-speed, speed));
	public TurnTo(double angle){
		requires(Robot.drive);
		controller.setAbsoluteTolerance(0.5);
		controller.setInputRange(0, 360);
		controller.setContinuous();
		controller.setOutputRange(-1, 1);
		controller.setSetpoint(angle);
	}
	protected void initialize(){
		Robot.drive.shiftDown();
		controller.enable();
	}
	protected boolean isFinished(){
		return controller.onTarget() && Math.abs(controller.get()) < 0.5;
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
