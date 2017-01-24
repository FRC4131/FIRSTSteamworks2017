package org.usfirst.frc.team4131.robot.autonomous;

import org.usfirst.frc.team4131.robot.commands.DriveStraight;
import org.usfirst.frc.team4131.robot.commands.TurnToAtRate;
//import org.usfirst.frc.team4131.robot.commands.VisionSeek;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous {
	private NumericConfiguration startPos = new NumericConfiguration("AutonStartPos", "Starting Position ", 1, 5);
	private Configuration<?>[] configurations = {startPos};
	
	public Autonomous() {
	}

	public void init() {
		for (Configuration<?> config : configurations)
			config.init();
	}

	public int startPosition() {
		return startPos.value();
	}

	public Command assembleCommand() {
		CommandGroup cmd = new CommandGroup();
		//Move to firing position
/*		switch (startPosition()) {
		case(1):
			cmd.addSequential(new DriveStraight(60 * (2.0 + 4.0 / 9.0), 0, 0.5));
			cmd.addSequential(new TurnToAtRate(46, 0.5));
			break;
		case(2):
			cmd.addSequential(new DriveStraight(130 * (2.0 + 4.0 / 9.0), 0, 0.5));
			cmd.addSequential(new TurnToAtRate(46, 0.5));
			break;
		case(3):
			cmd.addSequential(new TurnToAtRate(45, 0.5));
			cmd.addSequential(new DriveStraight(45 * (2.0 + 4.0 / 9.0), 0.5));
			cmd.addSequential(new TurnToAtRate(0, 0.5));
			break;
		case(4):
			cmd.addSequential(new DriveStraight(20 * (2.0 + 4.0 / 9.0), 0, 0.5));
			break;
		case(5):
			cmd.addSequential(new TurnToAtRate(335, 0.5));
			cmd.addSequential(new DriveStraight(60 * (2.0 + 4.0 / 9.0), 0.5));
			cmd.addSequential(new TurnToAtRate(0, 0.5));
			break;
		}
		cmd.addSequential(new VisionSeek());
*/		return cmd;
	}
}
