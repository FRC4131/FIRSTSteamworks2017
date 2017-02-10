package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ChargeShooter extends Command {
	
	protected void initialize() {
	
	}
	protected void execute() {
	Robot.shooter.runFlywheel();	
	}
	protected boolean isFinished() {
		
		return false;
	}

}
