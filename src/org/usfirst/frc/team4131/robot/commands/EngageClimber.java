package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect the motor to turn at half speed.
 * Test passed
 * ====================================
 * @author Calvin
 * @since 2/17/2017
 */
public class EngageClimber extends Command {
	public EngageClimber() {
		requires(Robot.climber);
	}
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.climber.engage();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.climber.stop();
	}

	@Override
	protected void interrupted() {
		Robot.climber.stop();
	}

}
