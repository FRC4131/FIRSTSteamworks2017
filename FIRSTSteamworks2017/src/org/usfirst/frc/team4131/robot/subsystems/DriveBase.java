package org.usfirst.frc.team4131.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.Move;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CANTalon;

public class DriveBase extends Subsystem {
	private Talon leftMotor1, leftMotor2, rightMotor1, rightMotor2;
	
	//Revolutions per second per 2 inches
	public int rPsPi = 1;
	
	// Connects the motors
	public DriveBase(){
		super();
		leftMotor1 = new Talon(RobotMap.DRIVE_LEFT_MOTOR1);
		leftMotor2 = new Talon(RobotMap.DRIVE_LEFT_MOTOR2);
		rightMotor1 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR1);
		rightMotor2 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR2);

	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new Move());
	}
	
	// When called, sets the speed of the motors
	public void move(double speed1, double speed2){
		leftMotor1.set(speed1);
		leftMotor2.set(speed1);
		rightMotor1.set(speed2);
		rightMotor2.set(speed2);
	}
	
	

}
