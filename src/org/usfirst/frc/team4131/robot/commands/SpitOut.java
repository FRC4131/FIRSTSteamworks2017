package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;

public class SpitOut extends Command {
	
	CANTalon motor;
	
	public SpitOut() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		motor = new CANTalon(RobotMap.COLLECTOR_MOTOR);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		motor.set(-1);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !Robot.OI.getSpitOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		motor.set(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		motor.set(0);
	}

}