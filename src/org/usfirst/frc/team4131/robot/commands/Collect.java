package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * Set command to a joystick button and press the button, the motor will run continuously at full speed.
 * Test passed
 * ====================================
 * @author Matthew
 * @since 2/14/2017
 */
public class Collect extends Command {
	public Collect(){
		requires(Robot.collector);
	}
	@Override
	protected void initialize() {
	}
	protected void execute() {
		Robot.collector.collect();
	}
	protected boolean isFinished() {	
		return false;
	}
	protected void end() {
		Robot.collector.stop();
	}
}
