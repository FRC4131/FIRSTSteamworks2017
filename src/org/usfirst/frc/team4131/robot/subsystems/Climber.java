package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Ran on Robot in a Box
 * We will enable teleop, and expect both motors to turn at maximum speed in the same direction.
 * Test passed
 * ====================================
 * @author Matthew
 * @since 1/27/2017
 */

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
