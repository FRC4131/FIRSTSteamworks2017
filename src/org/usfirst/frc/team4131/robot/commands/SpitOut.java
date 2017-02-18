package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect reverse at maximum speed while the 'Spit Out' button is pressed.
 * Test passed
 * ====================================
 * @author Calvin
 * @since 2/12/2017
 */
public class SpitOut extends Command {
	
	
	public SpitOut() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.collector);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Robot.collector.eject();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.collector.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.collector.stop();
	}

}
