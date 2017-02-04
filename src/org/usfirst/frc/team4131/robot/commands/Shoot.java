package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
* ========== Test Procedure ==========
* Run on Robot in a Box
* We will bind this command to a button in the OI and expect the hopper to run when it is pressed.
* Tests passed
* ====================================
* @author Ian
* @since 2/4/2017
*/
public class Shoot extends Command{
	public Shoot(){
		requires(Robot.hopper);
	}
	
	@Override
	protected void initialize(){}
	
	@Override
	protected void execute(){
		Robot.hopper.run();
	}
	
	@Override
	protected boolean isFinished(){
		return false;
	}
	
	@Override
	protected void end(){
		Robot.hopper.stop();
	}
	
	@Override
	protected void interrupted(){
		Robot.hopper.stop();
	}
}
