package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
	private CANTalon motor;
	public Climber(){
		motor = new CANTalon(RobotMap.CLIMBER_MOTOR1);
		CANTalon motor2 = new CANTalon(RobotMap.CLIMBER_MOTOR2);
		motor2.changeControlMode(TalonControlMode.Follower);
		motor2.set(RobotMap.CLIMBER_MOTOR1);
	}
	@Override
	protected void initDefaultCommand(){}
	public void engage(){
		motor.set(0.5);
	}
	public void climb(){
		motor.set(1);
	}
	public void stop(){
		motor.set(0);
	}
}
