package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect both motors to turn corresponding to the joysticks.
 * We will push the shift button and expect the shifters to shift down then release and expect them to shift up.
 * Test passed
 * ====================================
 * @author Calvin, Dylan
 * @since 2/18/2017
 */
public class Move extends Command {
	
	public Move() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
	}
	@Override
	protected void initialize() {
	}
	public void execute() {
		Robot.drive.move(Robot.OI.getLeftSpeed(), Robot.OI.getRightSpeed());
		if(Robot.OI.shiftDown()){
			Robot.drive.shiftDown();
		}else{
			Robot.drive.shiftUp();
		}
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.drive.move(0, 0);
	}
	protected void interrupted() {
		Robot.drive.move(0, 0);
	}

}
