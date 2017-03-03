package org.usfirst.frc.team4131.robot.commands;


import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class TurnTo extends Command{
	private PIDController controller = new PIDController(0.2, 0, 20, Robot.drive.getAngleSource(), steer -> Robot.drive.move(-steer, steer));
	public TurnTo(double heading){
		requires(Robot.drive);
		controller.setAbsoluteTolerance(0.5);
		controller.setInputRange(0, 360);
		controller.setContinuous();
		controller.setOutputRange(-1, 1);
		controller.setSetpoint(heading);
	}
	@Override
	protected void initialize(){
		controller.reset();
		controller.enable();
	}
	@Override
	protected boolean isFinished(){
		return controller.onTarget();
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
}
