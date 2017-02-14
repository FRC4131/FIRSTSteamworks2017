package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * ========== Test Procedure ==========
 * Run on Robot in a Box
 * Assigned the command to a joystick button, when pressed the motor will run continuously at full speed.
 * Tests passed
 * ====================================
 * 
 * @author Matthew
 * @since 2/14/2017
 * 
 */

public class Collect extends Command {

	@Override
	protected void initialize() {
		
	}
	protected void execute() {
	Robot.collector.collect();	
	}
	protected boolean isFinished() {
		
		return false;
	}

}
