package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton extends CommandGroup {

	public Auton(){
		addSequential(new AutonTurn(90));
		addSequential(new AutonDrive(90, 60));
	}
}
