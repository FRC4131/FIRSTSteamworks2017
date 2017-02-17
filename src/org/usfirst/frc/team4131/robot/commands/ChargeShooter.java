package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * ========== Test Procedure ==========
 * Run on Robot in a Box
 * I will press button one on the left joystick, and one of the motors will move at full speed.
 * Tests passed
 * ====================================
 * @author Matthew
 * @since 2/10/2017
 */

public class ChargeShooter extends Command {
	
	protected void initialize() {
	
	}
	protected void execute() {
	Robot.shooter.runFlywheel();	
	}
	protected boolean isFinished() {
		return false;
	}
	protected void interrupted() {
		Robot.shooter.stopFlywheel();
	}
}
