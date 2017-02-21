package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
* ========== Test Procedure ==========
* Run on Robot in a Box
* We will start this command in teleopInit and expect the hopper motor and feeder motor to run while the robot is enabled in teleop.
* Tests passed
* ====================================
* @author Ian
* @since 2/18/2017
*/
public class Shoot extends Command{
	public Shoot(){
		requires(Robot.hopper);
	}
	@Override
	protected void initialize(){}
	@Override
	protected void execute(){
		Robot.hopper.agitateFuel();
		Robot.hopper.feedShooter();
	}
	@Override
	protected boolean isFinished(){
		return false;
	}
	@Override
	protected void end(){
		Robot.hopper.settleFuel();
		Robot.hopper.stopFeeder();
	}
	@Override
	protected void interrupted(){
		Robot.hopper.settleFuel();
		Robot.hopper.stopFeeder();
	}
}
