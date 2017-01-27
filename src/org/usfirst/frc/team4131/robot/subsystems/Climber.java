package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private CANTalon climber_motor1;
	private CANTalon climber_motor2;
	public Climber(){
		climber_motor1 = new CANTalon(RobotMap.CLIMBER_MOTOR1);
		climber_motor2 = new CANTalon(RobotMap.CLIMBER_MOTOR2);
	}
	@Override
	protected void initDefaultCommand() {
		
	}
	public void run() {
		climber_motor1.set(1);
		climber_motor2.set(1);
	}
	public void stop() {
		climber_motor1.set(0);
		climber_motor2.set(0);
	}
}
