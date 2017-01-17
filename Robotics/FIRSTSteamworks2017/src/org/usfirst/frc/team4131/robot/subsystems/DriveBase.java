package org.usfirst.frc.team4131.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.Move;
import edu.wpi.first.wpilibj.TalonSRX;

public class DriveBase extends Subsystem {
	private TalonSRX leftMotor1, leftMotor2, rightMotor1, rightMotor2;
	
	// Connects the motors
	public DriveBase(){
		super();
		leftMotor1 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR1);
		leftMotor2 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR2);
		rightMotor1 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR1);
		rightMotor2 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR2);
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
