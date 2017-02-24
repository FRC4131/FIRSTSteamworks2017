package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * ========== Test Procedure ==========
 * Run on Competition Bot
 * We will call {@link #engage()} with the climber directly under the rope, and expect the climber to engage the rope and begin to climb.
 * We will call {@link #climb()} in teleop, and expect the robot to climb the rope.
 * Tests passed
 * ====================================
 * @author Ian
 * @since 1/24/2017
 */
public class Climber extends Subsystem{
	private CANTalon motor;
	public Climber(){
		motor = new CANTalon(RobotMap.CLIMBER_MOTOR);
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
