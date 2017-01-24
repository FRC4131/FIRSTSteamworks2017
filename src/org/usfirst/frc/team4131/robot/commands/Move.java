package org.usfirst.frc.team4131.robot.commands;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4131.robot.Robot;

=======
import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

>>>>>>> origin/master
public class Move extends Command {
	
	public Move() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

<<<<<<< HEAD
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Robot.drive.move(Robot.oi.leftStick.getRawAxis(1), Robot.oi.rightStick.getRawAxis(1));
=======
	public void execute() {
		// TODO Auto-generated method stub
		Robot.drive.move(Robot.oi.leftStick.getRawAxis(1));// Robot.oi.getRightSpeed());
>>>>>>> origin/master
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		Robot.drive.move(0, 0);
=======
		Robot.drive.move(0);
>>>>>>> origin/master
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		Robot.drive.move(0, 0);
	}

=======
		Robot.drive.move(0);
	}
>>>>>>> origin/master
}
