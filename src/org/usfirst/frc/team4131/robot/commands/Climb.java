package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * ========== Test Procedure ==========
 * Run on Robot in a Box
 * We will bind this trigger to the left trigger, and expect it to control the climber.
 * Tests passed
 * ====================================
 * @author Alex
 * @since 2/16/2017
 */
public class Climb extends Command{
	public Climb() {
		requires(Robot.climber);
	}
	protected void initialize(){
		
	}
	protected void execute(){
		Robot.climber.climb();
	}
	@Override 
	protected boolean isFinished() {
		return false;
	}
	protected void end(){
		Robot.climber.stop();
	}
	protected void interrupted(){
		Robot.climber.stop();
	}
}