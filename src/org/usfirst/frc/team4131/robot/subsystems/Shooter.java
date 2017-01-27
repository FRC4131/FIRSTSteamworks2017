package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	@Override
	protected void initDefaultCommand() {
	}
		private CANTalon shooter_motor1;
		private CANTalon shooter_motor2;
		public Shooter(){
			shooter_motor1 = new CANTalon(RobotMap.SHOOTER_MOTOR1);
			shooter_motor2 = new CANTalon(RobotMap.SHOOTER_MOTOR2);

	}
    public void run() {
    	shooter_motor1.set(1);
    	shooter_motor2.set(1);
    }
    public void stop() {
    	shooter_motor1.set(0);
    	shooter_motor2.set(0);
    }
}
