package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Command;
/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect to turn at half speed.
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
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.climber.engage();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.climber.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.climber.stop();
	}

}
